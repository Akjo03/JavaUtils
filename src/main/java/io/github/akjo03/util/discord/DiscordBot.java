package io.github.akjo03.util.discord;

import io.github.akjo03.util.discord.auth.DiscordAuth;
import io.github.akjo03.util.discord.checks.DiscordScheduledCheck;
import io.github.akjo03.util.discord.events.EventType;
import io.github.akjo03.util.discord.status.DiscordBotStatus;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ExceptionEvent;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public abstract class DiscordBot implements Runnable, EventListener {
	private static final Logger LOGGER = LoggerManager.getLogger(DiscordBot.class, LoggingLevel.INFO);

	private final JDA botInstance;

	protected final String name;
	protected volatile DiscordBotStatus status;
	protected volatile boolean shouldShutdown;
	protected Guild activeGuild;

	private final List<DiscordScheduledCheck> scheduledChecks;

	protected DiscordBot(@NotNull DiscordAuth auth, String name, String startGuildID) {
		this.name = name;
		this.status = DiscordBotStatus.STARTING;

		LOGGER.log(this.name + " is being initialized...", LoggingLevel.INFO);
		this.scheduledChecks = new ArrayList<>();
		initializeBot();
		if (auth.getBotToken() == null) {
			LOGGER.log(this.name + " has no bot token for authentication.", LoggingLevel.FATAL);
			System.exit(1);
		}
		LOGGER.log(this.name + " is being created and authenticated...", LoggingLevel.INFO);
		JDABuilder builder = JDABuilder.createDefault(auth.getBotToken(), Arrays.stream(GatewayIntent.values()).toList());
		builder.addEventListeners(this);
		builder.setAutoReconnect(false);
		builder = createBot(builder);
		try {
			botInstance = builder.build();
		} catch (LoginException e) {
			LOGGER.log("Failed to login to Discord. Please check your bot token.", LoggingLevel.FATAL, e);
			System.exit(1);
			throw new IllegalStateException("Expected to exit on login exception...");
		}
		LOGGER.log(this.name + " has been initialized, created and authenticated!", LoggingLevel.SUCCESS);
		this.status = DiscordBotStatus.INITIALIZED;
		try {
			botInstance.awaitReady();
		} catch (InterruptedException e) {
			LOGGER.log("Failed to wait for bot to be ready.", LoggingLevel.FATAL, e);
			System.exit(1);
		}
		this.activeGuild = botInstance.getGuildById(startGuildID);
		run();
		botInstance.shutdown();
		shutdown();
	}

	public static void main(String[] args) {}

	@Override
	public void run() {
		LOGGER.log(this.name + " is running on Guild \"" + activeGuild.getName() + "\"!", LoggingLevel.INFO);
		for (DiscordScheduledCheck check : scheduledChecks) {
			check.start();
		}
	}

	private void shutdown() {
		for (DiscordScheduledCheck check : scheduledChecks) {
			check.stop();
		}
		shutdownBot();
	}

	protected abstract void initializeBot();
	protected abstract JDABuilder createBot(JDABuilder builder);
	protected abstract void shutdownBot();

	protected void registerCheck(DiscordScheduledCheck check) {
		scheduledChecks.add(check);
	}

	protected DiscordScheduledCheck getCheck(long id) {
		return scheduledChecks.stream()
				.filter(check -> check.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void onEvent(@NotNull GenericEvent genericEvent) {
		switch (EventType.getByName(genericEvent.getClass().getSimpleName())) {
			case EXCEPTION -> {
				ExceptionEvent exceptionEvent = (ExceptionEvent) genericEvent;
				LOGGER.log("An exception occurred in " + this.name + ".", LoggingLevel.ERROR, exceptionEvent.getCause());
			}
			case READY -> {
				LOGGER.log(this.name + " is ready!", LoggingLevel.INFO);
				this.status = DiscordBotStatus.ONLINE;
			}
			case SHUTDOWN -> {
				LOGGER.log(this.name + " is shutting down...", LoggingLevel.INFO);
				this.status = DiscordBotStatus.SHUTTING_DOWN;
			}
			case DISCONNECT -> {
				LOGGER.log(this.name + " has disconnected from Discord.", LoggingLevel.INFO);
				this.status = DiscordBotStatus.OFFLINE;
			}
			case RECONNECTED -> {
				LOGGER.log(this.name + " has reconnected to Discord.", LoggingLevel.INFO);
				this.status = DiscordBotStatus.ONLINE;
			}
			case RESUMED -> {
				LOGGER.log(this.name + " has resumed the session to Discord.", LoggingLevel.INFO);
				this.status = DiscordBotStatus.ONLINE;
			}
			default -> {
			}
		}
	}
}
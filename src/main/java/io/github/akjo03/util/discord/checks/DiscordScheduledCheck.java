package io.github.akjo03.util.discord.checks;

import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public abstract class DiscordScheduledCheck implements Runnable {
	@Getter
	private final long id;
	private final ScheduledExecutorService executor;
	private final long periodTime;
	private final TimeUnit periodUnit;

	protected DiscordScheduledCheck(long id, long periodTime, TimeUnit periodUnit) {
		this.id = id;
		this.executor = Executors.newSingleThreadScheduledExecutor();
		this.periodTime = periodTime;
		this.periodUnit = periodUnit;
	}

	public void start() {
		this.executor.scheduleAtFixedRate(this, 0, periodTime, periodUnit);
	}

	public void stop() {
		this.executor.shutdown();
	}
}
package io.github.akjo03.util.net.server;

import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public abstract class HttpServer implements Runnable {
	protected final Logger LOGGER;

	@Getter
	@NotNull private final ServerAddress serverAddress;

	@Getter
	@NotNull private ServerStatus serverStatus;

	@NotNull private final com.sun.net.httpserver.HttpServer serverInstance;
	@NotNull private final Thread serverThread;

	public HttpServer(@NotNull ServerAddress serverAddress) {
		this.LOGGER = LoggerManager.getLogger(getClass(), LoggingLevel.INFO);

		this.serverStatus = ServerStatus.INITIALIZING;
		this.serverAddress = serverAddress;
		try {
			this.serverInstance = com.sun.net.httpserver.HttpServer.create(serverAddress.toSocketAddress(), 0);
		} catch (final Exception e) {
			LOGGER.log("Failed to create HttpServer instance!", LoggingLevel.ERROR, e);
			throw new RuntimeException(e);
		}
		this.serverThread = new Thread(this);
		initialize();
		this.serverStatus = ServerStatus.INITIALIZED;
	}

	protected abstract void initialize();

	protected void registerHandler(@NotNull ServerHandler handler) {
		this.serverInstance.createContext(handler.getPath(), handler);
	}

	public void start() {
		this.serverStatus = ServerStatus.STARTING;
		if (!this.serverThread.isAlive()) {
			this.serverThread.start();
		} else {
			this.run();
		}
		this.serverStatus = ServerStatus.RUNNING;
	}

	@Override
	public void run() {
		serverInstance.start();
		LOGGER.log("Server started at " + (serverAddress.getHost() != null ? serverAddress.getHost() : "localhost") + " on port " + serverAddress.getPort() + "!", LoggingLevel.INFO);
		this.onServerStart();
	}

	protected abstract void onServerStart();

	public void stop() {
		this.serverStatus = ServerStatus.STOPPING;
		this.serverInstance.stop(0);
		this.onServerStop();
		this.serverStatus = ServerStatus.HALTED;
	}

	protected abstract void onServerStop();

	public void shutdown() {
		if (this.serverStatus == ServerStatus.RUNNING) {
			this.stop();
		}
		this.serverStatus = ServerStatus.SHUTTING_DOWN;
		this.serverThread.interrupt();
		this.onServerShutdown();
		this.serverStatus = ServerStatus.SHUTDOWN;
	}

	protected abstract void onServerShutdown();
}
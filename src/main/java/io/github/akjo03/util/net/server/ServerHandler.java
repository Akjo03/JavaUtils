package io.github.akjo03.util.net.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public abstract class ServerHandler implements HttpHandler {
	protected final Logger LOGGER;

	@Getter
	@NotNull private final String path;

	public ServerHandler(@NotNull String path) {
		this.LOGGER = LoggerManager.getLogger(getClass(), LoggingLevel.INFO);
		this.path = path;
	}

	@Override
	public void handle(@NotNull HttpExchange exchange) {
		if (!exchange.getRequestURI().getPath().equals(path)) {
			return;
		}
		LOGGER.log("Handling " + exchange.getRequestMethod() + " request at path \"" + path + "\"...", LoggingLevel.INFO);
		ServerRequest request = new ServerRequest(exchange);
		ServerResponse response = switch (exchange.getRequestMethod()) {
			case "GET" -> get(request);
			case "POST" -> post(request);
			default -> {
				LOGGER.log("Unsupported request method \"" + exchange.getRequestMethod() + "\".", LoggingLevel.WARN);
				yield ServerResponse.UNSUPPORTED_METHOD;
			}
		};
		try {
			exchange.getResponseBody().write(response.getBytes());
		} catch (IOException e) {
			LOGGER.log("Failed to write response to client.", LoggingLevel.ERROR, e);
			throw new RuntimeException(e);
		}
	}

	protected abstract ServerResponse get(@NotNull ServerRequest request);
	protected abstract ServerResponse post(@NotNull ServerRequest request);
}
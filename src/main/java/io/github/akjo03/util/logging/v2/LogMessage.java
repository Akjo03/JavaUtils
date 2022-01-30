package io.github.akjo03.util.logging.v2;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class LogMessage {
	@Getter
	private final String message;
	@Getter
	private final LoggingLevel level;
	@Getter
	private final Throwable throwable;

	LogMessage(String message, LoggingLevel level) {
		this.message = message;
		this.level = level;
		this.throwable = null;
	}

	LogMessage(String message, LoggingLevel level, Throwable throwable) {
		this.message = message;
		this.level = level;
		this.throwable = throwable;
	}

	LogMessage(@NotNull Throwable throwable) {
		this.message = throwable.getMessage();
		this.level = LoggingLevel.ERROR;
		this.throwable = throwable;
	}

	LogMessage(@NotNull Throwable throwable, LoggingLevel level) {
		this.message = throwable.getMessage();
		this.level = level;
		this.throwable = throwable;
	}

	LogMessage(Object message, LoggingLevel level) {
		if (message == null) {
			this.message = "null";
		} else {
			this.message = message.toString();
		}
		this.level = level;
		this.throwable = null;
	}

	LogMessage(Object message, LoggingLevel level, Throwable throwable) {
		if (message == null) {
			this.message = "null";
		} else {
			this.message = message.toString();
		}
		this.level = level;
		this.throwable = throwable;
	}

	@Override
	public String toString() {
		return "LogMessage{" + "message='" + message + '\'' + ", level=" + level + ", throwable=" + throwable + '}';
	}
}
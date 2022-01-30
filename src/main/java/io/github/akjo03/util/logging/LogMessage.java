package io.github.akjo03.util.logging;

import io.github.akjo03.util.ThrowableCompare;
import lombok.Getter;

import java.util.Objects;

/**
 * Defines a message that can be used in a {@link LogEntry}
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-25
 * @version 1.0.0
 */
@Getter
public class LogMessage {
	/**
	 * The actual message
	 */
	private final String message;
	/**
	 * The importance of the message
	 */
	private final LoggingLevel level;
	/**
	 * The {@link Throwable} that caused this message
	 */
	private final Throwable throwable;

	/**
	 * Creates a new LogMessage with the specified message and level of importance.
	 * @param message The actual message
	 * @param level The importance of the message
	 */
	LogMessage(String message, LoggingLevel level) {
		this.message = message;
		this.level = level;
		this.throwable = null;
	}

	/**
	 * Creates a new LogMessage with the specified message, level of importance and the throwable that caused this message.
	 * @param message The actual message
	 * @param level The importance of the message
	 * @param throwable The {@link Throwable} that caused this message
	 */
	LogMessage(String message, LoggingLevel level, Throwable throwable) {
		this.message = message;
		this.level = level;
		this.throwable = throwable;
	}

	/**
	 * Creates a new LogMessage with the specified message and level of importance.
	 * @param message The actual message
	 * @param level The importance of the message
	 */
	LogMessage(Object message, LoggingLevel level) {
		if (message == null) {
			this.message = "null";
		} else {
			this.message = message.toString();
		}
		this.level = level;
		this.throwable = null;
	}

	/**
	 * Creates a new LogMessage with the specified message, level of importance and the throwable that caused this message.
	 * @param message The actual message
	 * @param level The importance of the message
	 * @param throwable The {@link Throwable} that caused this message
	 */
	LogMessage(Object message, LoggingLevel level, Throwable throwable) {
		if (message == null) {
			this.message = "null";
		} else {
			this.message = message.toString();
		}
		this.level = level;
		this.throwable = throwable;
	}

	//region == General Object Methods ===

	/**
	 * @return A String representation of this LogMessage
	 */
	@Override
	public String toString() {
		return "LogMessage{" + "message='" + message + '\'' + ", level=" + level + ", throwable=" + throwable + '}';
	}

	/**
	 * Compares the given object with this LogMessage to see if they're equal.
	 * @param o The object to compare this LogMessage to
	 * @return If the object is the same as this LogMessage
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LogMessage that = (LogMessage) o;
		return Objects.equals(message, that.message) && level == that.level && ThrowableCompare.compareThrowable(throwable, that.throwable, false);

	}

	/**
	 * @return The hash code for this LogMessage
	 */
	@Override
	public int hashCode() {
		return Objects.hash(message, level, throwable);
	}

	//endregion
}
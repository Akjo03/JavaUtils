package io.github.akjo03.util.logging;

import io.github.akjo03.util.ConsoleColor;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Defines the importance of a {@link LogMessage}
 *
 * Level descriptions mostly taken from <a href="https://stackoverflow.com/a/2031209">here</a>.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-25
 * @version 1.0.0
 */
@SuppressWarnings("unused")
@Getter
public enum LoggingLevel {
	/**
	 * Should only be used to trace code to find one part of a method.
	 */
	TRACE("TRACE", -200, ConsoleColor.WHITE, false),
	/**
	 * Should be used for information that is diagnostically helpful to people more than just developers.
	 */
	DEBUG("DEBUG", -100),
	/**
	 * Should be used for general information to log. This should generally be the default config level.
	 */
	INFO("INFO", 0),
	/**
	 * Should be used if an operation was successfully completed. Alternative to {@link LoggingLevel#INFO}.
	 */
	SUCCESS("SUCCESS", 10, ConsoleColor.GREEN, false),
	/**
	 * Should be used if an input is requested or input is required. Alternative to {@link LoggingLevel#INFO}.
	 */
	INPUT("INPUT", 20, ConsoleColor.CYAN, false),
	/**
     * Should be used if an input operation was not completed successfully. Alternative to {@link LoggingLevel#ERROR}.
     */
	INPUT_ERROR("INPUT_ERROR", 22, ConsoleColor.YELLOW_BRIGHT, true),
	/**
	 * Should be used to log anything that can potentially cause application oddities, but that can be automatically recovered from.
	 */
	WARN("WARN", 100, ConsoleColor.YELLOW, false),
	/**
	 * Should be used to log any error which is fatal to the operation, but not the service or application.
	 */
	ERROR("ERROR", 200, ConsoleColor.RED, false),
	/**
	 * Should be used to log any error that is forcing a shutdown of the service or application to either prevent data loss or that can't be automatically recovered from.
	 */
	FATAL("FATAL", 300, ConsoleColor.RED, true);

	/**
	 * The name that is displayed for the logging level (%l).
	 *
	 * @see LogEntry#FORMAT
	 */
	private final String name;

	/**
	 * The integer value of the logging level.
	 */
	private final int level;

	/**
	 * The color for the message that should be used if logged with this logging level.
	 */
	private final ConsoleColor color;
	/**
	 * If the message should be bold if logged with this logging level.
	 */
	private final boolean bold;

	/**
	 * Creates a new LoggingLevel with the specified name
	 * @param name The name that is displayed for the logging level
	 */
	LoggingLevel(String name, int level) {
		this.name = name;
		this.level = level;
		this.color = null;
		this.bold = false;
	}

	/**
	 * Creates a new LoggingLevel with the specified name and color and defines if the message should be bold, if the text is logged with this logging level.
	 * @param name The name that is displayed for the logging level (%l).
	 * @param color The color for the message that should be used if logged with this logging level.
	 * @param bold If the message should be bold if logged with this logging level.
	 */
	@SuppressWarnings("SameParameterValue")
	LoggingLevel(String name, int level, ConsoleColor color, boolean bold) {
		this.name = name;
		this.level = level;
		this.color = color;
		this.bold = bold;
	}

	/**
	 * @return A String representation of this LoggingLevel.
	 */
	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "LoggingLevel{" + "name='" + name + '\'' + ", color=" + color + ", bold=" + bold + '}';
	}
}
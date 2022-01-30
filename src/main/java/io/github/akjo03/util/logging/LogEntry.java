package io.github.akjo03.util.logging;

import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 * A log entry to be printed to the console or to be written to a {@link LogFile}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-20
 * @version 1.0.0
 */
@SuppressWarnings({"unused", "ClassCanBeRecord"})
public class LogEntry {
	/**
	 * The format this LogEntry should follow.<br />
	 * <ul>
	 *     <li>%t - Current time in pattern "yyyy-MM-dd HH:mm:ss.SSS"</li>
	 *     <li>%c - Class that called the log (full classpath)"</li>
	 *     <li>%l - Level of Importance of the message inside this entry</li>
	 *     <li>%m - The message itself</li>
	 *     <li>%s - An exclamation point if the special flag is set. This means this should not be logged to a log file.</li>
	 * </ul>
	 */
	static final String FORMAT = "[%t] [%s%c / %l]: %m";
	/**
	 * The formatter for the date and time of this LogEntry
	 */
	static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
																 .ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
																 .withLocale(Locale.getDefault())
																 .withZone(ZoneId.systemDefault());

	/**
	 * The class that has called to log this LogEntry
	 */
	@Getter
	private final Class<?> clazz;
	/**
	 * The message that should be logged by this LogEntry
	 */
	@Getter
	private final LogMessage message;
	/**
	 * If this LogEntry is not saved to a log file, this should be true.
	 * Only set this in very special occasions.
	 */
	@Getter
	private final boolean special;

	/**
	 * Creates a new LogEntry by the specified class with the specified message and if the LogEntry is not saved to a log file.
	 * @param clazz The class that has called to log this LogEntry
	 * @param message The message that should be logged by this LogEntry
	 * @param special If this LogEntry is not saved to a log file, this should be true.
	 */
	LogEntry(Class<?> clazz, LogMessage message, boolean special) {
		this.clazz = clazz;
		this.message = message;
		this.special = special;
	}

	/**
	 * Print new line for this LogEntry to {@link System#out System.out}. Uses the {@link LogEntry#generate()} method to generate the message text.
	 * Also colorizes the text as defined in {@link LoggingLevel}.
	 */
	public void print() {
		System.out.println(message.getLevel().getColor() != null ? message.getLevel().getColor().colorize(generate(), message.getLevel().isBold()) : generate());
	}

	/**
	 * Print new line for this LogEntry to {@link System#out System.out}. Uses the {@link LogEntry#generate()} method to generate the message text.
	 * Also colorizes the text as defined in {@link LoggingLevel}.
	 */
	public void printInput() {
		System.out.print(message.getLevel().getColor() != null ? message.getLevel().getColor().colorize(generate(), message.getLevel().isBold()) : generate());
	}

	/**
	 * Generates the message to be logged defined by the {@link LogEntry#FORMAT}.
	 * @return The formatted message
	 */
	public String generate() {
		String result = FORMAT
						.replace("%t", DATE_TIME_FORMATTER.format(Instant.now()))
						.replace("%c", clazz.getName())
						.replace("%l", message.getLevel().getName())
						.replace("%m", message.getMessage())
						.replace("%s", special ? "!" : "");
		if (message.getThrowable() != null) {
			result += " | " + message.getThrowable().getClass().getName() + ": " + message.getThrowable().getLocalizedMessage();
		}
		return result;
	}

	//region === General Object Methods ===

	/**
	 * @return A String representation of this LogEntry
	 */
	@Override
	public String toString() {
		return "LogEntry{" + "clazz=" + clazz + ", message=" + message + ", special=" + special + '}';
	}

	/**
	 * Compares the given object with this LogEntry to see if they're equal.
	 * @param o The object to compare this LogEntry to
	 * @return If the object is the same as this LogEntry
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LogEntry logEntry = (LogEntry) o;
		return special == logEntry.special && Objects.equals(clazz, logEntry.clazz) && Objects.equals(message, logEntry.message);
	}

	/**
	 * @return The hash code for this LogEntry
	 */
	@Override
	public int hashCode() {
		return Objects.hash(clazz, message, special);
	}

	//endregion
}
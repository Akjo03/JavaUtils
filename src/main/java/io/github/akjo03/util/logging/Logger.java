package io.github.akjo03.util.logging;

import io.github.akjo03.util.ProjectDirectory;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Logs {@link LogEntry LogEntries} to the console and saves them to {@link LogFile LogFiles}. Also saves a history of the last (n = {@link Logger#HISTORY_SIZE}) {@link LogMessage LogMessages}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-25
 * @version 0.1.0
 */
@SuppressWarnings("unused")
public final class Logger {
	/**
	 * The class this Logger corresponds to
	 */
	@Getter
	private final Class<?> clazz;
	/**
	 * The name of this Logger
	 */
	@Getter
	private final String name;

	/**
	 * The history of log messages. Maximum amount of messages defined by {@link Logger#HISTORY_SIZE}.
	 */
	@Getter
	private final List<LogMessage> logMessages;
	/**
	 * The maximum amount of log messages being saved for history.
	 * @see Logger#logMessages
	 */
	@Getter
	private static int HISTORY_SIZE = 500;

	/**
	 * The log files that are written to by this logger.
	 */
	private final List<LogFile> logFiles;

	/**
	 * If, by default, log message should be written instantly to all log files. Defaults to true.
	 */
	private boolean defaultWriteInstantly;

	/**
	 * Minimum log level to be written to this logger. Defaults to {@link LoggingLevel#INFO}.
	 */
	private LoggingLevel minimumLoggingLevel = LoggingLevel.INFO;

	/**
	 * Creates a new Logger with the specified class and name.
	 * @param clazz The class this new Logger should correspond to
	 * @param name The name of this new Logger
	 */
	Logger(Class<?> clazz, String name) {
		this.clazz = clazz;
		this.name = name;
		this.logMessages = new ArrayList<>();
		this.logFiles = new ArrayList<>();
		this.defaultWriteInstantly = true;
	}

	/**
	 * Creates a new Logger with the specified class and name and if, by default, should be written instantly to all log files.
	 * @param clazz The class this new Logger should correspond to
	 * @param name The name of this new Logger
	 * @param defaultWriteInstantly If, by default, log message should be written instantly to all log files. Defaults to true.
	 */
	Logger(Class<?> clazz, String name, boolean defaultWriteInstantly) {
		this.clazz = clazz;
		this.name = name;
		this.logMessages = new ArrayList<>();
		this.logFiles = new ArrayList<>();
		this.defaultWriteInstantly = defaultWriteInstantly;
	}

	/**
	 * Logs the specified message with the specified level of importance
	 * @param message The message to log
	 * @param level The level of importance of the message
	 */
	public void log(String message, LoggingLevel level) {
		log(new LogMessage(message, level), defaultWriteInstantly);
	}

	/**
	 * Logs the specified message with the specified level of importance
	 * @param message The message to log
	 * @param level The level of importance of the message
	 * @param throwable The cause of the message
	 */
	public void log(String message, LoggingLevel level, Throwable throwable) {
		log(new LogMessage(message, level, throwable), defaultWriteInstantly);
	}

	/**
	 * Logs the specified message with the specified level of importance
	 * @param message The message to log
	 * @param level The level of importance of the message
	 * @param writeInstantly If the message should be written to all log files immediately. See {@link Logger#defaultWriteInstantly} for default value.
	 */
	public void log(String message, LoggingLevel level, boolean writeInstantly) {
		log(new LogMessage(message, level), writeInstantly);
	}

	/**
	 * Logs the specified message with the specified level of importance
	 * @param message The message to log
	 * @param level The level of importance of the message
	 * @param throwable The cause of the message
	 * @param writeInstantly If the message should be written to all log files immediately. See {@link Logger#defaultWriteInstantly} for default value.
	 */
	public void log(String message, LoggingLevel level, Throwable throwable, boolean writeInstantly) {
		log(new LogMessage(message, level, throwable), writeInstantly);
	}

	/**
	 * Logs the specified log message.
	 * @param logMessage The log message to log.
	 * @param writeInstantly If the message should be written to all log files immediately. See {@link Logger#defaultWriteInstantly} for default value.
	 */
	private void log(@NotNull LogMessage logMessage, boolean writeInstantly) {
		if (logMessage.getLevel().getLevel() < minimumLoggingLevel.getLevel()) {
			return;
		}

		LogEntry entry = new LogEntry(clazz, logMessage, false);
		if (logMessage.getLevel() == LoggingLevel.INPUT || logMessage.getLevel() == LoggingLevel.INPUT_ERROR) {
			entry.printInput();
		} else {
			entry.print();
		}

		for (LogFile logFile : logFiles) {
			logFile.addEntry(entry);
			if (writeInstantly) {
				logFile.writeEntryAndClear(entry);
			}
		}
		if (logMessages.size() >= HISTORY_SIZE) {
			logMessages.remove(0);
		}
		logMessages.add(logMessage);
	}

	/**
	 * Adds a default log file to write to. Will be created under {@link ProjectDirectory#getProjectLogDirectory()}.
	 */
	void addLogFile() {
		logFiles.add(new LogFile(Path.of(ProjectDirectory.getProjectLogDirectory().toString(), name + ".log")));
	}

	/**
	 * Adds a log file to write to. Should use a path inside {@link ProjectDirectory#getProjectLogDirectory()}.
	 * @param logFile The log file to write to
	 */
	void addLogFile(LogFile logFile) {
		logFiles.add(logFile);
	}

	/**
	 * Sets the minimum logging level to be logged.
	 * @param minimumLoggingLevel The minimum logging level to be logged
	 */
	public void setLevel(LoggingLevel minimumLoggingLevel) {
        this.minimumLoggingLevel = minimumLoggingLevel;
    }

	/**
	 * Sets if the logger should write instantly to all log files by default.
	 * @param defaultWriteInstantly If the logger should write instantly to all log files by default
	 */
	public void setDefaultWriteInstantly(boolean defaultWriteInstantly) {
        this.defaultWriteInstantly = defaultWriteInstantly;
    }

	/**
	 * Sets the maximum amount of saved log messages in history. Must be more or equal to 0. 0 will not save any log message.
	 * @param historySize The new maximum amount of saved log messages in history.
	 */
	public static void setHistorySize(int historySize) {
		if (historySize < 0) {
			new LogEntry(Logger.class, new LogMessage("Cannot set history size of Logger to less than zero! Keeping it at " + HISTORY_SIZE + "...", LoggingLevel.ERROR), true).print();
			return;
		}
		HISTORY_SIZE = historySize;
	}

	//region === General Object Methods ===

	/**
	 * @return A String representation of this Logger
	 */
	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "Logger{" + "clazz=" + clazz + ", name='" + name + '\'' + ", logMessages=" + logMessages + ", logFiles=" + logFiles + ", defaultWriteInstantly=" + defaultWriteInstantly + '}';
	}

	/**
	 * Compares the given object with this Logger to see if they're equal.
	 * @param o The object to compare this Logger to
	 * @return If the object is the same as this Logger
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Logger logger = (Logger) o;
		return defaultWriteInstantly == logger.defaultWriteInstantly && Objects.equals(clazz, logger.clazz) && Objects.equals(name, logger.name) && Objects.equals(logMessages, logger.logMessages) && Objects.equals(logFiles, logger.logFiles);
	}

	/**
	 * @return The hash code for this LogMessage
	 */
	@Override
	public int hashCode() {
		return Objects.hash(clazz, name, logMessages, logFiles, defaultWriteInstantly);
	}

	//endregion
}
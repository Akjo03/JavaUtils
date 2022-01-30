package io.github.akjo03.util.logging;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Manages multiple {@link Logger Loggers} for each class in a project
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-20
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public final class LoggerManager {
	/**
	 * List of all the loggers. Every class has a maximum of one {@link Logger}.
	 */
	private static final ArrayList<Logger> LOGGERS = new ArrayList<>();

	/**
	 * <strong>This should never be called!!!</strong>
	 */
	private LoggerManager() {
		throw new UnsupportedOperationException("LoggerManager class cannot be instantiated!");
	}

	/**
	 * Gets a logger for its class. Will create a new logger if none exists.
	 * @param clazz The class to get the logger for
	 * @return The logger to use for the class
	 */
	public static @NotNull Logger getLogger(Class<?> clazz) {
		for (Logger logger : LOGGERS) {
			if (logger.getClazz() == clazz) {
				return logger;
			}
		}
		String loggerName = clazz.getSimpleName() + "Logger";
		String finalLoggerName = loggerName;
		if (LOGGERS.stream().anyMatch(logger -> Objects.equals(logger.getName(), finalLoggerName))) {
			loggerName += LOGGERS.stream().filter(logger -> logger.getName().startsWith(finalLoggerName)).count();
		}
		Logger newLogger = new Logger(clazz, loggerName);
		LOGGERS.add(newLogger);
		return newLogger;
	}
}
package io.github.akjo03.util.logging.v2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("unused")
public final class LoggerManager {
	private static final ArrayList<Logger> LOGGERS = new ArrayList<>();

	private LoggerManager() {
		throw new UnsupportedOperationException("LoggerManager class cannot be instantiated!");
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static @NotNull Logger getLogger(Class<?> clazz, LoggingLevel minLevel) {
		if (LOGGERS.stream().anyMatch(logger -> Objects.equals(logger.getClass(), clazz))) {
			return LOGGERS.stream().filter(logger -> Objects.equals(logger.getClass(), clazz)).findFirst().get();
		}
		Logger logger = new Logger(clazz.getSimpleName(), clazz, minLevel);
		LOGGERS.add(logger);
		return logger;
	}

	@SuppressWarnings("OptionalGetWithoutIsPresent")
	public static @NotNull Logger getLogger(String name, LoggingLevel minLevel) {
		if (LOGGERS.stream().anyMatch(logger -> Objects.equals(logger.getName(), name))) {
			return LOGGERS.stream().filter(logger -> Objects.equals(logger.getName(), name)).findFirst().get();
		}
		Logger logger = new Logger(name, null, minLevel);
		LOGGERS.add(logger);
		return logger;
	}

	public static void removeLogger(Class<?> clazz) {
		LOGGERS.removeIf(logger -> Objects.equals(logger.getClass(), clazz));
	}

	public static void removeLogger(String name) {
		LOGGERS.removeIf(logger -> Objects.equals(logger.getName(), name));
	}
}
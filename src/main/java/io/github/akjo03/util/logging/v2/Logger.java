package io.github.akjo03.util.logging.v2;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class Logger {
	@Getter
	@NotNull private final String name;
	@Getter
	@Nullable private final Class<?> clazz;

	private final List<LogFile> logFiles;

	@Getter
	private LoggingLevel minimumLoggingLevel;
	@Getter
	private String loggingFormat = "[%t] [%s%c / %l]: %m";

	public Logger(@NotNull String name, @Nullable Class<?> clazz, @NotNull LoggingLevel minimumLoggingLevel) {
		this.name = name;
		this.clazz = clazz;
		this.logFiles = new ArrayList<>();
		this.minimumLoggingLevel = minimumLoggingLevel;
	}

	public Logger setMinimumLoggingLevel(LoggingLevel level) {
		this.minimumLoggingLevel = level;
		return this;
	}

	public Logger setLoggingFormat(String loggingFormat) {
		this.loggingFormat = loggingFormat;
		return this;
	}

	public void empty() {
		System.out.println();
	}

	public void log(Object obj, LoggingLevel level) {
		log(new LogMessage(obj.toString(), level));
	}

	public void log(Object obj, LoggingLevel level, Throwable throwable) {
		log(new LogMessage(obj.toString(), level, throwable));
	}

	public void log(String message, LoggingLevel level) {
		log(new LogMessage(message, level));
	}

	public void log(String message, LoggingLevel level, Throwable throwable) {
		log(new LogMessage(message, level, throwable));
	}

	public void log(Throwable throwable) {
		log(new LogMessage(throwable));
	}

	public void log(Throwable throwable, LoggingLevel level) {
		log(new LogMessage(throwable, level));
	}

	private void log(@NotNull LogMessage logMessage) {
		if (logMessage.getLevel().getLevel() < minimumLoggingLevel.getLevel()) {
			return;
		}

		LogEntry entry = new LogEntry(clazz, logMessage, loggingFormat, name, false);
		entry.print();

		for (LogFile logFile : logFiles) {
			logFile.write(entry);
		}
	}

	public void trace(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.TRACE));
	}

	public void trace(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.TRACE, throwable));
	}

	public void trace(String message) {
		log(new LogMessage(message, LoggingLevel.TRACE));
	}

	public void trace(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.TRACE));
	}

	public void trace(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.TRACE, throwable));
	}

	public void debug(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.DEBUG));
	}

	public void debug(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.DEBUG, throwable));
	}

	public void debug(String message) {
		log(new LogMessage(message, LoggingLevel.DEBUG));
	}

	public void debug(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.DEBUG));
	}

	public void debug(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.DEBUG, throwable));
	}

	public void info(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.INFO));
	}

	public void info(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.INFO, throwable));
	}

	public void info(String message) {
		log(new LogMessage(message, LoggingLevel.INFO));
	}

	public void info(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.INFO));
	}

	public void info(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.INFO, throwable));
	}

	public void success(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.SUCCESS));
	}

	public void success(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.SUCCESS, throwable));
	}

	public void success(String message) {
		log(new LogMessage(message, LoggingLevel.SUCCESS));
	}

	public void success(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.SUCCESS));
	}

	public void success(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.SUCCESS, throwable));
	}

	public void warn(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.WARN));
	}

	public void warn(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.WARN, throwable));
	}

	public void warn(String message) {
		log(new LogMessage(message, LoggingLevel.WARN));
	}

	public void warn(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.WARN));
	}

	public void warn(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.WARN, throwable));
	}

	public void error(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.ERROR));
	}

	public void error(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.ERROR, throwable));
	}

	public void error(String message) {
		log(new LogMessage(message, LoggingLevel.ERROR));
	}

	public void error(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.ERROR));
	}

	public void error(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.ERROR, throwable));
	}

	public void fatal(Object obj) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.FATAL));
	}

	public void fatal(Object obj, Throwable throwable) {
		log(new LogMessage(obj == null ? "null" : obj.toString(), LoggingLevel.FATAL, throwable));
	}

	public void fatal(String message) {
		log(new LogMessage(message, LoggingLevel.FATAL));
	}

	public void fatal(Throwable throwable) {
		log(new LogMessage(throwable, LoggingLevel.FATAL));
	}

	public void fatal(String message, Throwable throwable) {
		log(new LogMessage(message, LoggingLevel.FATAL, throwable));
	}

	void addLogFile(@NotNull LogFile logFile) {
		logFiles.add(logFile);
	}
}
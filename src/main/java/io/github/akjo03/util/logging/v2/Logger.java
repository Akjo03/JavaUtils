package io.github.akjo03.util.logging.v2;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class Logger {
	@Getter
	@NotNull private final String name;
	@Getter
	@Nullable private final Class<?> clazz;

	private final List<LogFile> logFiles;

	@Getter
	@Setter
	private LoggingLevel minimumLoggingLevel;
	@Getter
	@Setter
	private String loggingFormat = "[%t] [%s%c / %l]: %m";

	public Logger(@NotNull String name, @Nullable Class<?> clazz, @NotNull LoggingLevel minimumLoggingLevel) {
		this.name = name;
		this.clazz = clazz;
		this.logFiles = new ArrayList<>();
		this.minimumLoggingLevel = minimumLoggingLevel;
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

	void addLogFile(@NotNull LogFile logFile) {
		logFiles.add(logFile);
	}
}
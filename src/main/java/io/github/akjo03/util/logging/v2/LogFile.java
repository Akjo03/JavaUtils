package io.github.akjo03.util.logging.v2;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LogFile {
	@Getter
	private final ArrayList<Logger> loggers;
	@Getter
	private final Path filePath;
	private final BufferedWriter logFileWriter;

	public LogFile(Path filePath) {
		this.loggers = new ArrayList<>();
		this.filePath = filePath;
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot delete existing log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
		}
		try {
			Files.createDirectories(filePath.getParent());
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create directiories for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
		}
		try {
			Files.createFile(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
		}
		this.logFileWriter = getBufferedWriter();
	}

	public void addLogger(Logger logger) {
		if (logger == null) { return; }
		if (loggers.contains(logger)) { return; }
		loggers.add(logger);
		logger.addLogFile(this);
	}

	public void write(LogEntry logEntry) {
		if (logFileWriter == null) { return; }
		try {
			logFileWriter.write(logEntry.generate() + System.lineSeparator());
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot write to log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
		}
		try {
			logFileWriter.flush();
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot flush writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
		}
	}

	private @Nullable BufferedWriter getBufferedWriter() {
		BufferedWriter logFileWriter;
		try {
			logFileWriter = Files.newBufferedWriter(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), "[%t] [%s%c / %l]: %m", "LogFile", true).print();
			return null;
		}
		return logFileWriter;
	}
}
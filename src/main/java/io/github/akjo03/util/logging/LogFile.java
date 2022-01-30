package io.github.akjo03.util.logging;

import io.github.akjo03.util.ProjectDirectory;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Logs {@link LogEntry LogEntries} from multiple {@link Logger Loggers} to a log file.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-26
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class LogFile {
	/**
	 * The {@link Logger Loggers} this log file is getting logs from.
	 */
	@Getter
	private final ArrayList<Logger> loggers;
	/**
	 * The {@link LogEntry LogEntries} this log file has received. Can get huge! Should be cleared through {@link LogFile#clear()}, {@link LogFile#writeAndClear()} or {@link LogFile#writeEntryAndClear}.
	 */
	@Getter
	private ArrayList<LogEntry> logEntries;
	/**
	 * The path for the log file. Should be in {@link ProjectDirectory#getProjectLogDirectory()}.
	 */
	@Getter
	private final Path filePath;
	/**
	 * The writer that writes to the log file
	 */
	private final BufferedWriter logFileWriter;

	/**
	 * Creates a new LogFile at the specified file path
	 * @param filePath The file path where the log should be located at. Should be in {@link ProjectDirectory#getProjectLogDirectory()}.
	 */
	public LogFile(Path filePath) {
		this.loggers = new ArrayList<>();
		this.logEntries = new ArrayList<>();
		this.filePath = filePath;
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot delete old log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		try {
			Files.createDirectories(filePath.getParent());
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create parent directories for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		try {
			Files.createFile(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		this.logFileWriter = getBufferedWriter();
	}

	/**
	 * Adds a logger to listen to write logs to this log file from.
	 * @param logger The logger to write logs to this log file from.
	 */
	@SuppressWarnings("unused")
	public void addLogger(Logger logger) {
		if (loggers.stream().anyMatch(loggerP -> loggerP.getClazz().equals(logger.getClazz()))) {
			new LogEntry(LogFile.class, new LogMessage("Cannot add Logger \"" + logger.getName() + "\" more than once to log file!", LoggingLevel.ERROR), true).print();
		} else {
			loggers.add(logger);
			logger.addLogFile(this);
		}
	}

	@SuppressWarnings("unused")
	public void removeLogger(Logger logger) {
		if (loggers.stream().noneMatch(loggerP -> loggerP.getClazz().equals(logger.getClazz()))) {
			new LogEntry(LogFile.class, new LogMessage("Cannot remove Logger \"" + logger.getName() + "\" from log file, because it is not added!", LoggingLevel.ERROR), true).print();
		} else {
			loggers.remove(logger);
			logger.removeLogFile(this);
		}
	}

	/**
	 * Adds a new {@link LogEntry} to this log file.<br /><br />
	 * The {@link Logger} that is used with this LogEntry should be added before logging an entry!<br /><br />
	 * @param logEntry The log entry to log to this log file.
	 */
	void addEntry(LogEntry logEntry) {
		logEntries.add(logEntry);
	}

	/**
	 * Writes a {@link LogEntry} directly to the log file
	 * @param logEntry The LogEntry to log to the log file
	 */
	public void writeEntry(LogEntry logEntry) {
		if (logFileWriter == null) { return; }
		try {
			logFileWriter.write(logEntry.generate() + System.lineSeparator());
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot write to log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		try {
			logFileWriter.flush();
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot flush writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
	}

	/**
	 * Writes a {@link LogEntry} directly to the log file by its index
	 * @param index The index of the LogEntry inside of {@link LogFile#logEntries}
	 */
	public void writeEntry(int index) {
		if (logFileWriter == null) { return; }
		try {
			logFileWriter.write(logEntries.get(index).generate() + System.lineSeparator());
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot write to log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		try {
			logFileWriter.flush();
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot flush writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
	}

	/**
	 * Writes a {@link LogEntry} directly to the log file and clears {@link LogFile#logEntries}
	 * @param logEntry The LogEntry to log to the log file
	 */
	public void writeEntryAndClear(LogEntry logEntry) {
		writeEntry(logEntry);
		clear();
	}

	/**
	 * Writes a {@link LogEntry} directly to the log file by its index and clears {@link LogFile#logEntries}
	 * @param index The index of the LogEntry inside of {@link LogFile#logEntries}
	 */
	public void writeEntryAndClear(int index) {
		writeEntry(index);
		clear();
	}

	/**
	 * Writes all the log entries to this log file and clears {@link LogFile#logEntries}
	 */
	public void writeAndClear() {
		if (!writeAllLogEntries())
			return;
		try {
			logFileWriter.flush();
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot flush writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
		clear();
	}

	/**
	 * Writes all the log entries to this log file
	 */
	@SuppressWarnings("unused")
	public void write() {
		if (!writeAllLogEntries())
			return;
		try {
			logFileWriter.close();
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot close writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
		}
	}

	/**
	 * Clears {@link LogFile#logEntries}
	 */
	public void clear() {
		logEntries = new ArrayList<>();
	}

	/**
	 * @return The {@link BufferedWriter} of the log file.
	 * @see Files#newBufferedWriter(Path, OpenOption...)
	 */
	private @Nullable BufferedWriter getBufferedWriter() {
		BufferedWriter logFileWriter;
		try {
			logFileWriter = Files.newBufferedWriter(filePath);
		} catch (IOException ioe) {
			new LogEntry(LogFile.class, new LogMessage("Cannot create writer for log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
			return null;
		}
		return logFileWriter;
	}

	/**
	 * Writes all the {@link LogEntry LogEntries} to the log file.
	 * @return If all the LogEntries were written to the log file successfully.
	 */
	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	private boolean writeAllLogEntries() {
		LogEntry writeLogEntry = new LogEntry(LogFile.class, new LogMessage("Writing log to log file at \"" + filePath + "\"...", LoggingLevel.INFO), false);
		writeLogEntry.print();
		if (Runtime.getRuntime().freeMemory() >= 50_000_000L) { addEntry(writeLogEntry); }
		if (logFileWriter == null) {
			return false;
		}
		for (LogEntry logEntry : logEntries) {
			try {
				logFileWriter.write(logEntry.generate() + System.lineSeparator());
			} catch (IOException ioe) {
				new LogEntry(LogFile.class, new LogMessage("Cannot write to log file at \"" + filePath + "\"!", LoggingLevel.ERROR, ioe), true).print();
			}
		}
		return true;
	}

	//region === General Object Methods ===

	/**
	 * @return A String representation of this LogFile
	 */
	@Override
	public String toString() {
		return "LogFile{" + "loggers=" + loggers + ", logEntries=" + logEntries + ", filePath=" + filePath + ", logFileWriter=" + logFileWriter + '}';
	}

	/**
	 * Compares the given object with this LogFile to see if they're equal.
	 * @param o The object to compare this LogFile to
	 * @return If the object is the same as this LogFile
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LogFile logFile = (LogFile) o;
		return Objects.equals(loggers, logFile.loggers) && Objects.equals(logEntries, logFile.logEntries) && Objects.equals(filePath, logFile.filePath) && Objects.equals(logFileWriter, logFile.logFileWriter);
	}

	/**
	 * @return The hash code for this LogFile
	 */
	@Override
	public int hashCode() {
		return Objects.hash(loggers, logEntries, filePath, logFileWriter);
	}

	//endregion
}
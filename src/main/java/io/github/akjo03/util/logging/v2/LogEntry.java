package io.github.akjo03.util.logging.v2;

import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
public class LogEntry {
	private final String format;

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
			.withLocale(Locale.getDefault())
			.withZone(ZoneId.systemDefault());

	@Getter
	private final Class<?> clazz;
	@Getter
	private final String loggerName;
	@Getter
	private final LogMessage message;
	@Getter
	private final boolean special;

	LogEntry(Class<?> clazz, LogMessage message, String format, String loggerName, boolean special) {
		this.clazz = clazz;
		this.message = message;
		this.format = format;
		this.loggerName = loggerName;
		this.special = special;
	}

	public void print() {
		System.out.println(message.getLevel().getColor() != null ? message.getLevel().getColor().colorize(generate(), message.getLevel().isBold()) : generate());
	}

	public String generate() {
		String result = format
				.replace("%t", DATE_TIME_FORMATTER.format(Instant.now()))
				.replace("%h", Thread.currentThread().getName())
				.replace("%c", clazz != null ? clazz.getName() : loggerName)
				.replace("%i", clazz != null ? clazz.getSimpleName() : loggerName)
				.replace("%a", loggerName)
				.replace("%n", System.lineSeparator())
				.replace("%l", message.getLevel().getName())
				.replace("%m", message.getMessage())
				.replace("%s", special ? "!" : "");
		if (message.getThrowable() != null) {
			result += " | " + message.getThrowable().getClass().getName() + ": " + message.getThrowable().getLocalizedMessage();
		}
		return result;
	}
}
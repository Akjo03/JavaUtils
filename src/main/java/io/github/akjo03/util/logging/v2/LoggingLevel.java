package io.github.akjo03.util.logging.v2;

import io.github.akjo03.util.ConsoleColor;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum LoggingLevel {
	TRACE("TRACE", -200, ConsoleColor.WHITE, false),
	DEBUG("DEBUG", -100),
	INFO("INFO", 0),
	SUCCESS("SUCCESS", 10, ConsoleColor.GREEN, false),
	INPUT("INPUT", 20, ConsoleColor.CYAN, false),
	INPUT_ERROR("INPUT_ERROR", 22, ConsoleColor.YELLOW_BRIGHT, true),
	WARN("WARN", 100, ConsoleColor.YELLOW, false),
	ERROR("ERROR", 200, ConsoleColor.RED, false),
	FATAL("FATAL", 300, ConsoleColor.RED, true);

	@Getter
	private final String name;
	@Getter
	private final int level;
	@Getter
	private final ConsoleColor color;
	@Getter
	private final boolean bold;

	LoggingLevel(String name, int level) {
		this.name = name;
		this.level = level;
		this.color = null;
		this.bold = false;
	}

	LoggingLevel(String name, int level, ConsoleColor color, boolean bold) {
		this.name = name;
		this.level = level;
		this.color = color;
		this.bold = bold;
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "LoggingLevel." + super.name();
	}
}
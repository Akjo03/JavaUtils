package io.github.akjo03.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class can be used to colorize text in the console or to get color escape codes
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-25
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public enum ConsoleColor {
	BLACK("\033[%c;30m"),
	RED("\033[%c;31m"),
	GREEN("\033[%c;32m"),
	YELLOW("\033[%c;33m"),
	BLUE("\033[%c;34m"),
	PURPLE("\033[%c;35m"),
	CYAN("\033[%c;36m"),
	WHITE("\033[%c;37m"),
	BLACK_BRIGHT("\033[%c;90m"),
	RED_BRIGHT("\033[%c;91m"),
	GREEN_BRIGHT("\033[%c;92m"),
	YELLOW_BRIGHT("\033[%c;93m"),
	BLUE_BRIGHT("\033[%c;94m"),
	PURPLE_BRIGHT("\033[%c;95m"),
	CYAN_BRIGHT("\033[%c;96m"),
	WHITE_BRIGHT("\033[%c;97m");

	/**
	 * The ANSI escape code for the color
	 * @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code"></a>
	 */
	private final String code;

	/**
	 * Creates a new ConsoleColor with the specified <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a>
	 * @param code The ANSI escape code for the new color
	 */
	ConsoleColor(String code) {
		this.code = code;
	}

	/**
	 * Returns the <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a> (either as bold text or not)
	 * @param bold If the code should be used for bold text
	 * @return The ANSI escape code
	 */
	@Contract(pure = true)
	public @NotNull String getCode(boolean bold) {
		return code.replace("%c", bold ? "1" : "0");
	}

	/**
	 * Colorizes the specified text with this color either as bold text or not
	 * @param text The text to colorize
	 * @param bold If the text should be bold
	 * @return The colorized text as a string to be outputted to the console
	 */
	@Contract(pure = true)
	public @NotNull String colorize(String text, boolean bold) {
		return getCode(bold) + text + "\033[0m";
	}

	/**
	 * @return A String representation of this ConsoleColor
	 */
	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "ConsoleColor{" + "code='" + code + '\'' + '}';
	}
}
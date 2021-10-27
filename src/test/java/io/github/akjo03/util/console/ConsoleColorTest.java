package io.github.akjo03.util.console;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the enum {@link ConsoleColor}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-26
 * @version 0.1.0
 */
public class ConsoleColorTest {
	/**
	 * Tests if there are enough values inside the ConsoleColor enum and if all the enum values have the right name and codes.
	 */
	@Test
	public void validateEnums() {
		assertEquals(16, ConsoleColor.values().length, "Enum ConsoleColor has missing entries!");
		assertArrayEquals(new String[] {
				"BLACK",
				"RED",
				"GREEN",
				"YELLOW",
				"BLUE",
				"PURPLE",
				"CYAN",
				"WHITE",
				"BLACK_BRIGHT",
				"RED_BRIGHT",
				"GREEN_BRIGHT",
				"YELLOW_BRIGHT",
				"BLUE_BRIGHT",
				"PURPLE_BRIGHT",
				"CYAN_BRIGHT",
				"WHITE_BRIGHT"
		}, Arrays.stream(ConsoleColor.values()).map(Enum::name).toArray(), "Enum ConsoleColor has invalid entries or is in an invalid order!");
		assertArrayEquals(new String[] {
				"\033[0;30m", // BLACK
				"\033[0;31m", // RED
				"\033[0;32m", // GREEN
				"\033[0;33m", // YELLOW
				"\033[0;34m", // BLUE
				"\033[0;35m", // PURPLE
				"\033[0;36m", // CYAN
				"\033[0;37m", // WHITE
				"\033[0;90m", // BLACK_BRIGHT
				"\033[0;91m", // RED_BRIGHT
				"\033[0;92m", // GREEN_BRIGHT
				"\033[0;93m", // YELLOW_BRIGHT
				"\033[0;94m", // BLUE_BRIGHT
				"\033[0;95m", // PURPLE_BRIGHT
				"\033[0;96m", // CYAN_BRIGHT
				"\033[0;97m"  // WHITE_BRIGHT
		}, Arrays.stream(ConsoleColor.values()).map(consoleColor -> consoleColor.getCode(false)).toArray(), "Enum ConsoleColor has one or more invalid color code values!");
		assertArrayEquals(new String[] {
				"\033[1;30m", // BLACK
				"\033[1;31m", // RED
				"\033[1;32m", // GREEN
				"\033[1;33m", // YELLOW
				"\033[1;34m", // BLUE
				"\033[1;35m", // PURPLE
				"\033[1;36m", // CYAN
				"\033[1;37m", // WHITE
				"\033[1;90m", // BLACK_BRIGHT
				"\033[1;91m", // RED_BRIGHT
				"\033[1;92m", // GREEN_BRIGHT
				"\033[1;93m", // YELLOW_BRIGHT
				"\033[1;94m", // BLUE_BRIGHT
				"\033[1;95m", // PURPLE_BRIGHT
				"\033[1;96m", // CYAN_BRIGHT
				"\033[1;97m"  // WHITE_BRIGHT
		}, Arrays.stream(ConsoleColor.values()).map(consoleColor -> consoleColor.getCode(true)).toArray(), "Enum ConsoleColor has one or more invalid color code values!");
	}

	/**
	 * Checks if the {@link ConsoleColor#colorize(String, boolean)} correctly colorizes the text with every color.
	 */
	@Test
	public void checkColorizingText() {
		assertArrayEquals(new String[] {
				"\033[0;30mTest\033[0m",
				"\033[0;31mTest\033[0m",
				"\033[0;32mTest\033[0m",
				"\033[0;33mTest\033[0m",
				"\033[0;34mTest\033[0m",
				"\033[0;35mTest\033[0m",
				"\033[0;36mTest\033[0m",
				"\033[0;37mTest\033[0m",
				"\033[0;90mTest\033[0m",
				"\033[0;91mTest\033[0m",
				"\033[0;92mTest\033[0m",
				"\033[0;93mTest\033[0m",
				"\033[0;94mTest\033[0m",
				"\033[0;95mTest\033[0m",
				"\033[0;96mTest\033[0m",
				"\033[0;97mTest\033[0m"
		}, Arrays.stream(ConsoleColor.values()).map(consoleColor -> consoleColor.colorize("Test", false)).toArray());
		assertArrayEquals(new String[] {
				"\033[1;30mTest\033[0m",
				"\033[1;31mTest\033[0m",
				"\033[1;32mTest\033[0m",
				"\033[1;33mTest\033[0m",
				"\033[1;34mTest\033[0m",
				"\033[1;35mTest\033[0m",
				"\033[1;36mTest\033[0m",
				"\033[1;37mTest\033[0m",
				"\033[1;90mTest\033[0m",
				"\033[1;91mTest\033[0m",
				"\033[1;92mTest\033[0m",
				"\033[1;93mTest\033[0m",
				"\033[1;94mTest\033[0m",
				"\033[1;95mTest\033[0m",
				"\033[1;96mTest\033[0m",
				"\033[1;97mTest\033[0m"
		}, Arrays.stream(ConsoleColor.values()).map(consoleColor -> consoleColor.colorize("Test", true)).toArray());
	}

	/**
	 * Checks if the {@link ConsoleColor#toString} converts the ConsoleColor into the correct string.
	 */
	@Test
	public void checkToString() {
		assertArrayEquals(new String[] {
				"ConsoleColor{code='\033[%c;30m'}",
				"ConsoleColor{code='\033[%c;31m'}",
				"ConsoleColor{code='\033[%c;32m'}",
				"ConsoleColor{code='\033[%c;33m'}",
				"ConsoleColor{code='\033[%c;34m'}",
				"ConsoleColor{code='\033[%c;35m'}",
				"ConsoleColor{code='\033[%c;36m'}",
				"ConsoleColor{code='\033[%c;37m'}",
				"ConsoleColor{code='\033[%c;90m'}",
				"ConsoleColor{code='\033[%c;91m'}",
				"ConsoleColor{code='\033[%c;92m'}",
				"ConsoleColor{code='\033[%c;93m'}",
				"ConsoleColor{code='\033[%c;94m'}",
				"ConsoleColor{code='\033[%c;95m'}",
				"ConsoleColor{code='\033[%c;96m'}",
				"ConsoleColor{code='\033[%c;97m'}"
		}, Arrays.stream(ConsoleColor.values()).map(ConsoleColor::toString).toArray());
	}
}
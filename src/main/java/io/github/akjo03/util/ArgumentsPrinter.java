package io.github.akjo03.util;

import org.jetbrains.annotations.NotNull;
import org.silentsoft.arguments.parser.Argument;
import org.silentsoft.arguments.parser.Arguments;

public final class ArgumentsPrinter {
	public static void print(@NotNull Arguments arguments) {
		arguments.forEach(argument -> {
			System.out.println(argument.getKey() + ": " + argument.getValue());
		});
	}

	public static @NotNull String toString(@NotNull Arguments arguments) {
		StringBuilder builder = new StringBuilder();

		builder.append("[");
		int count = 0;
		for (Argument ignored : arguments) {
			count++;
		}
		int i = 0;
		for (Argument argument : arguments) {
			i++;
			builder.append(argument.getKey()).append(": ").append(argument.getValue());
			if (i < count) {
				builder.append(", ");
			}
		}
		builder.append("]");

		return builder.toString();
	}
}
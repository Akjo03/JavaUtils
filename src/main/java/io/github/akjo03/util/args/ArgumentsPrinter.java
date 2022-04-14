package io.github.akjo03.util.args;

import io.github.akjo03.util.logging.v2.Logger;
import org.jetbrains.annotations.NotNull;
import org.silentsoft.arguments.parser.Arguments;

public final class ArgumentsPrinter {
	private ArgumentsPrinter() {
		throw new UnsupportedOperationException("Cannot instantiate ArgumentsPrinter!");
	}

	public static String getPrintableString(@NotNull Arguments args) {
		return ArgumentsUtil.toList(args).toString();
	}

	public static void print(@NotNull Arguments args) {
		System.out.println(ArgumentsUtil.toList(args));
	}

	public static void log(@NotNull Logger logger, Arguments args) {
		logger.info(ArgumentsUtil.toList(args));
	}
}
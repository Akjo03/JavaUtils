package io.github.akjo03.util.args;

import org.silentsoft.arguments.parser.Argument;
import org.silentsoft.arguments.parser.Arguments;

import java.util.ArrayList;
import java.util.List;

public final class ArgumentsUtil {
	private ArgumentsUtil() {
		throw new UnsupportedOperationException("Cannot instantiate ArgumentsUtil!");
	}

	public static List<Argument> toList(Arguments args) {
		List<Argument> argumentList = new ArrayList<>();
		for (Argument arg : args) {
			argumentList.add(arg);
		}
		return argumentList;
	}
}
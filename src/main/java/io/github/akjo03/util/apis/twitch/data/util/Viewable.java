package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum Viewable {
	PUBLIC,
	PRIVATE;

	public static Viewable fromString(String str) {
		return switch (str) {
			case "public" -> PUBLIC;
			case "private" -> PRIVATE;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "Viewable." + name();
	}
}
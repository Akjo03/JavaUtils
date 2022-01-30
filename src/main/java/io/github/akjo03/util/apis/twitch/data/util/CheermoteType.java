package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum CheermoteType {
	GLOBAL_FIRST_PARTY,
	GLOBAL_THIRD_PARTY,
	CHANNEL_CUSTOM,
	DISPLAY_ONLY,
	SPONSORED;

	public static CheermoteType fromString(String type) {
		return switch (type) {
			case "global_first_party" -> GLOBAL_FIRST_PARTY;
			case "global_third_party" -> GLOBAL_THIRD_PARTY;
			case "channel_custom" -> CHANNEL_CUSTOM;
			case "display_only" -> DISPLAY_ONLY;
			case "sponsored" -> SPONSORED;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "CheermoteType." + name();
	}
}
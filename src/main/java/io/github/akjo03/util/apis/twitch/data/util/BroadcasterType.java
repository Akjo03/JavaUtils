package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum BroadcasterType {
	PARTNER,
	AFFILIATE,
	NONE,
	UNKNOWN;

	public static BroadcasterType fromString(String type) {
		return switch (type) {
			case "partner" -> PARTNER;
			case "affiliate" -> AFFILIATE;
			case "" -> NONE;
			default -> UNKNOWN;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "BroadcasterType." + name();
	}
}
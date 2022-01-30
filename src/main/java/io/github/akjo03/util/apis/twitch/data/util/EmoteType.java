package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum EmoteType {
	BITS_TIER,
	FOLLOWER,
	SUBSCRIPTION;

	public static EmoteType fromString(String emoteType) {
		return switch (emoteType) {
			case "bitstier " -> BITS_TIER;
			case "follower" -> FOLLOWER;
			case "subscription" -> SUBSCRIPTION;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "ChannelEmoteType." + name();
	}
}
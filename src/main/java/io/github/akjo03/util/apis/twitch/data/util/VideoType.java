package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public enum VideoType {
	UPLOAD,
	ARCHIVE,
	HIGHLIGHT;

	public static VideoType fromString(String type) {
		return switch (type) {
			case "upload" -> UPLOAD;
			case "archive" -> ARCHIVE;
			case "highlight" -> HIGHLIGHT;
			default -> null;
		};
	}

	public static String toString(VideoType type) {
		return switch (type) {
			case UPLOAD -> "upload";
			case ARCHIVE -> "archive";
			case HIGHLIGHT -> "highlight";
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "VideoType." + name();
	}
}
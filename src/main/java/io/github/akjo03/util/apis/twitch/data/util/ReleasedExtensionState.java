package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum ReleasedExtensionState {
	IN_TEST,
	IN_REVIEW,
	REJECTED,
	APPROVED,
	RELEASED,
	DEPRECATED,
	PENDING_ACTION,
	ASSETS_UPLOADED,
	DELETED;

	public static ReleasedExtensionState fromString(String state) {
		return switch (state) {
			case "InTest" -> IN_TEST;
			case "InReview" -> IN_REVIEW;
			case "Rejected" -> REJECTED;
			case "Approved" -> APPROVED;
			case "Released" -> RELEASED;
			case "Deprecated" -> DEPRECATED;
			case "PendingAction" -> PENDING_ACTION;
			case "AssetsUploaded" -> ASSETS_UPLOADED;
			case "Deleted" -> DELETED;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "ReleasedExtensionState." + name();
	}
}
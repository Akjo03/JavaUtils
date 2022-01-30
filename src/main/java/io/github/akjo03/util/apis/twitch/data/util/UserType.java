package io.github.akjo03.util.apis.twitch.data.util;

public enum UserType {
	STAFF,
	ADMIN,
	GLOBAL_MOD,
	USER,
	UNKNOWN;

	public static UserType fromString(String type) {
		return switch (type) {
			case "staff" -> STAFF;
			case "admin" -> ADMIN;
			case "global_mod" -> GLOBAL_MOD;
			case "" -> USER;
			default -> UNKNOWN;
		};
	}
}
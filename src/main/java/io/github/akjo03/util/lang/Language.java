package io.github.akjo03.util.lang;

public enum Language {
	GERMAN_DE("de_DE"),
	ENGLISH_US("en_US"),
	ENGLISH_UK("en_UK");

	private final String language;

	Language(String language) {
		this.language = language;
	}

	public String get() {
		return language;
	}
}
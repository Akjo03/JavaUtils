package io.github.akjo03.util.apis.twitch.data.util;

import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;

import java.net.URI;
import java.util.Arrays;

@SuppressWarnings("unused")
public interface EmoteResponse {
	Logger LOGGER = LoggerManager.getLogger(EmoteResponse.class, LoggingLevel.INFO);

	default int parseScale(String scale) {
		return (int) Double.parseDouble(scale);
	}

	default URI getImageURI(boolean animated, boolean dark, int scale) {
		String themeMode = dark ? "dark" : "light";
		String format = animated ? "animated" : "static";
		if (Arrays.stream(getFormat()).noneMatch(f -> f.equals(format))) {
			LOGGER.log("Emote with ID " + getID() + " does not support format " + format + "!", LoggingLevel.WARN);
			return null;
		}
		if (Arrays.stream(getThemeModes()).noneMatch(t -> t.equals(themeMode))) {
			LOGGER.log("Emote with ID " + getID() + " does not support theme mode " + themeMode + "!", LoggingLevel.WARN);
			return null;
		}
		if (Arrays.stream(getAvailableScales()).noneMatch(s -> s == scale)) {
			LOGGER.log("Emote with ID " + getID() + " does not support scale " + scale + "!", LoggingLevel.WARN);
			return null;
		}
		return URI.create(getTemplate().replace("{{id}}", getID()).replace("{{format}}", format).replace("{{theme_mode}}", themeMode).replace("{{scale}}", String.valueOf(scale)));
	}

	String[] getFormat();
	String[] getThemeModes();
	int[] getAvailableScales();
	String getID();
	String getTemplate();
}
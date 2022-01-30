package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ClassCanBeRecord")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheermoteTierImage implements JsonParsable {
	private final boolean isDark;
	private final boolean isAnimated;
	private final String id;
	private final URI imageURL;

	private CheermoteTierImage(boolean isDark, boolean isAnimated, String id, URI imageURL) {
		this.isDark = isDark;
		this.isAnimated = isAnimated;
		this.id = id;
		this.imageURL = imageURL;
	}

	public static @NotNull List<CheermoteTierImage> parse(@NotNull JsonNode json) {
		List<CheermoteTierImage> images = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.convertValue(json.get("light").get("static"), new TypeReference<>() {});
		for (Map.Entry<String, String> entry : map.entrySet()) {
			images.add(new CheermoteTierImage(false, false, entry.getKey(), URI.create(entry.getValue())));
		}
		map = mapper.convertValue(json.get("light").get("animated"), new TypeReference<>() {});
		for (Map.Entry<String, String> entry : map.entrySet()) {
			images.add(new CheermoteTierImage(false, true, entry.getKey(), URI.create(entry.getValue())));
		}
		map = mapper.convertValue(json.get("dark").get("static"), new TypeReference<>() {});
		for (Map.Entry<String, String> entry : map.entrySet()) {
			images.add(new CheermoteTierImage(true, false, entry.getKey(), URI.create(entry.getValue())));
		}
		map = mapper.convertValue(json.get("dark").get("animated"), new TypeReference<>() {});
		for (Map.Entry<String, String> entry : map.entrySet()) {
			images.add(new CheermoteTierImage(true, true, entry.getKey(), URI.create(entry.getValue())));
		}
		return images;
	}

	@Override
	public String toString() {
		return "CheermoteTierImage{" + "isDark=" + isDark + ", isAnimated=" + isAnimated + ", id='" + id + '\'' + ", imageURL=" + imageURL + '}';
	}
}
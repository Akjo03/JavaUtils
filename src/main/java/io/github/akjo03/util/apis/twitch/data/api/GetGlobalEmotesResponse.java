package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.akjo03.util.apis.twitch.data.util.EmoteResponse;
import lombok.Getter;

import java.util.Arrays;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGlobalEmotesResponse extends TwitchApiResponse<GetGlobalEmotesResponse> implements EmoteResponse {
	private final String id;
	private final String name;
	private final String[] format;
	private final int[] availableScales;
	private final String[] themeModes;
	@JsonIgnore
	private static final String template = "https://static-cdn.jtvnw.net/emoticons/v2/{{id}}/{{format}}/{{theme_mode}}/{{scale}}.0";

	public GetGlobalEmotesResponse(
			@JsonProperty("id")
			String id,
			@JsonProperty("name")
			String name,
			@JsonProperty("images")
			@SuppressWarnings("unused")
			JsonNode images,
			@JsonProperty("format")
			String[] format,
			@JsonProperty("scale")
			String[] availableScales,
			@JsonProperty("theme_mode")
			String[] themeModes
	) {
		this.id = id;
		this.name = name;
		this.format = format;
		this.availableScales = Arrays.stream(availableScales).mapToInt(this::parseScale).toArray();
		this.themeModes = themeModes;
	}

	@Override
	public String[] getFormat() {
		return format;
	}

	@Override
	public String[] getThemeModes() {
		return themeModes;
	}

	@Override
	public int[] getAvailableScales() {
		return availableScales;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getTemplate() {
		return template;
	}

	@Override
	public String toString() {
		return "GetGlobalEmotesResponse{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", format=" + Arrays.toString(format) + ", availableScales=" + Arrays.toString(availableScales) + ", themeModes=" + Arrays.toString(themeModes) + '}';
	}
}
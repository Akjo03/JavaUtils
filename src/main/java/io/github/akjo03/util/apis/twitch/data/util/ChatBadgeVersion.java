package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.net.URI;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatBadgeVersion implements JsonParsable {
	private final String id;
	private final URI imageURL_1x;
	private final URI imageURL_2x;
	private final URI imageURL_4x;

	public ChatBadgeVersion(
			@JsonProperty("id")
			String id,
			@JsonProperty("image_url_1x")
			String imageURL_1x,
			@JsonProperty("image_url_2x")
			String imageURL_2x,
			@JsonProperty("image_url_4x")
			String imageURL_4x
	) {
		this.id = id;
		this.imageURL_1x = URI.create(imageURL_1x);
		this.imageURL_2x = URI.create(imageURL_2x);
		this.imageURL_4x = URI.create(imageURL_4x);
	}

	@Override
	public String toString() {
		return "ChatBadgeVersion{" + "id='" + id + '\'' + ", imageURL_1x=" + imageURL_1x + ", imageURL_2x=" + imageURL_2x + ", imageURL_4x=" + imageURL_4x + '}';
	}
}
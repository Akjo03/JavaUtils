package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.util.List;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheermoteTier implements JsonParsable {
	private final String id;
	private final int minBits;
	private final String hexColor;

	private final List<CheermoteTierImage> images;

	private final boolean canCheer;
	private final boolean showInBitsCard;

	public CheermoteTier(
			@JsonProperty("id")
			String id,
			@JsonProperty("min_bits")
			int minBits,
			@JsonProperty("color")
			String hexColor,
			@JsonProperty("images")
			JsonNode images,
			@JsonProperty("can_cheer")
			boolean canCheer,
			@JsonProperty("show_in_bits_card")
			boolean showInBitsCard
	) {
		this.id = id;
		this.minBits = minBits;
		this.hexColor = hexColor;

		this.images = CheermoteTierImage.parse(images);

		this.canCheer = canCheer;
		this.showInBitsCard = showInBitsCard;
	}

	@Override
	public String toString() {
		return "CheermoteTier{" + "id='" + id + '\'' + ", minBits=" + minBits + ", hexColor='" + hexColor + '\'' + ", images=" + images + ", canCheer=" + canCheer + ", showInBitsCard=" + showInBitsCard + '}';
	}
}
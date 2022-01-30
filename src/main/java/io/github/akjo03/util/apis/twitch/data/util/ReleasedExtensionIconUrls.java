package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.net.URI;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleasedExtensionIconUrls implements JsonParsable {
	private final URI smallURL;
	private final URI mediumURL;
	private final URI largeURL;

	public ReleasedExtensionIconUrls(
			@JsonProperty("24x24")
			String small,
			@JsonProperty("100x100")
			String medium,
			@JsonProperty("300x200")
			String large
	) {
		this.smallURL = URI.create(small);
		this.mediumURL = URI.create(medium);
		this.largeURL = URI.create(large);
	}
}
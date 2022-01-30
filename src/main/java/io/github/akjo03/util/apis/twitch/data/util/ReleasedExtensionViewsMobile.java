package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.net.URI;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleasedExtensionViewsMobile implements JsonParsable {
	private final URI viewerURL;

	public ReleasedExtensionViewsMobile(
			@JsonProperty("viewer_url")
			String viewerURL
	) {
		this.viewerURL = URI.create(viewerURL);
	}

	@Override
	public String toString() {
		return "ReleasedExtensionMobileView{" + "viewerURL=" + viewerURL + '}';
	}
}
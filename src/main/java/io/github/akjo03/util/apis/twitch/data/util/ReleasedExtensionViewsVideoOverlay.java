package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.net.URI;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleasedExtensionViewsVideoOverlay implements JsonParsable {
	private final URI viewerURL;
	private final boolean canLinkExternalContent;

	public ReleasedExtensionViewsVideoOverlay(
			@JsonProperty("viewer_url")
			String viewerURL,
			@JsonProperty("can_link_external_content")
			boolean canLinkExternalContent
	) {
		this.viewerURL = URI.create(viewerURL);
		this.canLinkExternalContent = canLinkExternalContent;
	}

	@Override
	public String toString() {
		return "ReleasedExtensionViewsVideoOverlay{" + "viewerURL=" + viewerURL + ", canLinkExternalContent=" + canLinkExternalContent + '}';
	}
}
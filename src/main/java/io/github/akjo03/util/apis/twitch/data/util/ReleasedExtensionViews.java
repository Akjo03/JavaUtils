package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleasedExtensionViews implements JsonParsable {
	private final ReleasedExtensionViewsMobile mobile;
	private final ReleasedExtensionViewsPanel panel;
	private final ReleasedExtensionViewsVideoOverlay videoOverlay;
	private final ReleasedExtensionViewsComponent component;

	public ReleasedExtensionViews(
			@JsonProperty("mobile")
			ReleasedExtensionViewsMobile mobile,
			@JsonProperty("panel")
			ReleasedExtensionViewsPanel panel,
			@JsonProperty("video_overlay")
			ReleasedExtensionViewsVideoOverlay videoOverlay,
			@JsonProperty("component")
			ReleasedExtensionViewsComponent component
	) {
		this.mobile = mobile;
		this.panel = panel;
		this.videoOverlay = videoOverlay;
		this.component = component;
	}

	@Override
	public String toString() {
		return "ReleasedExtensionViews{" + "mobile=" + mobile + ", panel=" + panel + ", videoOverlay=" + videoOverlay + ", component=" + component + '}';
	}
}
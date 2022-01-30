package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.net.URI;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleasedExtensionViewsComponent implements JsonParsable {
	private final URI viewerURL;
	private final int aspectWidth;
	private final int aspectHeight;
	private final int aspectRatioX;
	private final int aspectRatioY;
	private final boolean autoscale;
	private final int scalePixels;
	private final int targetHeight;
	private final int size;
	private final boolean zoom;
	private final int zoomPixels;
	private final boolean canLinkExternalContent;

	public ReleasedExtensionViewsComponent(
			@JsonProperty("viewer_url")
			String viewerURL,
			@JsonProperty("aspect_width")
			int aspectWidth,
			@JsonProperty("aspect_height")
			int aspectHeight,
			@JsonProperty("aspect_ratio_x")
			int aspectRatioX,
			@JsonProperty("aspect_ratio_y")
			int aspectRatioY,
			@JsonProperty("autoscale")
			boolean autoscale,
			@JsonProperty("scale_pixels")
			int scalePixels,
			@JsonProperty("target_height")
			int targetHeight,
			@JsonProperty("size")
			int size,
			@JsonProperty("zoom")
			boolean zoom,
			@JsonProperty("zoom_pixels")
			int zoomPixels,
			@JsonProperty("can_link_external_content")
			boolean canLinkExternalContent
	) {
		this.viewerURL = URI.create(viewerURL);
		this.aspectWidth = aspectWidth;
		this.aspectHeight = aspectHeight;
		this.aspectRatioX = aspectRatioX;
		this.aspectRatioY = aspectRatioY;
		this.autoscale = autoscale;
		this.scalePixels = scalePixels;
		this.targetHeight = targetHeight;
		this.size = size;
		this.zoom = zoom;
		this.zoomPixels = zoomPixels;
		this.canLinkExternalContent = canLinkExternalContent;
	}

	@Override
	public String toString() {
		return "ReleasedExtensionViewsComponent{" + "viewerURL=" + viewerURL + ", aspectWidth=" + aspectWidth + ", aspectHeight=" + aspectHeight + ", aspectRatioX=" + aspectRatioX + ", aspectRatioY=" + aspectRatioY + ", autoscale=" + autoscale + ", scalePixels=" + scalePixels + ", targetHeight=" + targetHeight + ", size=" + size + ", zoom=" + zoom + ", zoomPixels=" + zoomPixels + ", canLinkExternalContent=" + canLinkExternalContent + '}';
	}
}
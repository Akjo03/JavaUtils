package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoMutedSegment implements JsonParsable {
	private final int duration;
	private final int offset;

	public VideoMutedSegment(
			@JsonProperty("duration")
			int duration,
			@JsonProperty("offset")
			int offset
	) {
		this.duration = duration;
		this.offset = offset;
	}

	@Override
	public String toString() {
		return "VideoMutedSegment{" + "duration=" + duration + ", offset=" + offset + '}';
	}
}
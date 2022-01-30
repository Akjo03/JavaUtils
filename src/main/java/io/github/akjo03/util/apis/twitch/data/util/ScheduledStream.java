package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.time.Instant;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduledStream implements JsonParsable {
	private final String id;
	private final Instant startTime;
	private final Instant endTime;
	private final String streamTitle;
	private final Instant canceledUntil;
	private final ScheduledStreamCategory streamCategory;

	public ScheduledStream(
			@JsonProperty("id")
			String id,
			@JsonProperty("start_time")
			String startTime,
			@JsonProperty("end_time")
			String endTime,
			@JsonProperty("title")
			String streamTitle,
			@JsonProperty("canceled_until")
			String canceledUntil,
			@JsonProperty("category")
			ScheduledStreamCategory streamCategory
	) {
		this.id = id;
		this.startTime = Instant.parse(startTime);
		this.endTime = Instant.parse(endTime);
		this.streamTitle = streamTitle;
		this.canceledUntil = Instant.parse(canceledUntil);
		this.streamCategory = streamCategory;
	}

	@Override
	public String toString() {
		return "ScheduledStream{" + "id='" + id + '\'' + ", startTime=" + startTime + ", endTime=" + endTime + ", streamTitle='" + streamTitle + '\'' + ", canceledUntil=" + canceledUntil + ", streamCategory=" + streamCategory + '}';
	}
}
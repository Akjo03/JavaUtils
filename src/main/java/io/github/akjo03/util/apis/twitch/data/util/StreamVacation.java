package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

import java.time.Instant;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamVacation implements JsonParsable {
	private final Instant startTime;
	private final Instant endTime;

	public StreamVacation(
			@JsonProperty("start_time")
			String startTime,
			@JsonProperty("end_time")
			String endTime
	) {
		this.startTime = Instant.parse(startTime);
		this.endTime = Instant.parse(endTime);
	}

	@Override
	public String toString() {
		return "StreamVacation{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
	}
}
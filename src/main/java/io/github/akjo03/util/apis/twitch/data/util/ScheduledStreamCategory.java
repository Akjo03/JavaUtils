package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduledStreamCategory implements JsonParsable {
	private final String id;
	private final String name;

	public ScheduledStreamCategory(
			@JsonProperty("id")
			String id,
			@JsonProperty("name")
			String name
	) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScheduledStreamCategory{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
}
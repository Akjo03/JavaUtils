package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollChoice implements JsonParsable {
	private final String id;
	private final String title;
	private final int votes;
	private final int channelPointVotes;
	private final int bitsVotes;

	public PollChoice(
			@JsonProperty("id")
			String id,
			@JsonProperty("title")
			String title,
			@JsonProperty("votes")
			int votes,
			@JsonProperty("channel_points_votes")
			int channelPointVotes,
			@JsonProperty("bits_votes")
			int bitsVotes
	) {
		this.id = id;
		this.title = title;
		this.votes = votes;
		this.channelPointVotes = channelPointVotes;
		this.bitsVotes = bitsVotes;
	}

	@Override
	public String toString() {
		return "PollChoice{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", votes=" + votes + ", channelPointVotes=" + channelPointVotes + ", bitsVotes=" + bitsVotes + '}';
	}
}
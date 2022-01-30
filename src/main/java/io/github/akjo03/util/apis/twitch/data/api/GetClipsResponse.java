package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetClipsResponse extends TwitchApiResponse<GetClipsResponse> {
	private final String id;
	private final URI url;
	private final URI embedURL;
	private final String broadcasterID;
	private final String broadcasterName;
	private final String creatorID;
	private final String creatorName;
	private final String videoID;
	private final String gameID;
	private final String language;
	private final String title;
	private final int viewCount;
	private final Instant createdAt;
	private final URI thumbnailURL;
	private final double duration;

	public GetClipsResponse(
			@JsonProperty("id")
			String id,
			@JsonProperty("url")
			String url,
			@JsonProperty("embed_url")
			String embedURL,
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("creator_id")
			String creatorID,
			@JsonProperty("creator_name")
			String creatorName,
			@JsonProperty("video_id")
			String videoID,
			@JsonProperty("game_id")
			String gameID,
			@JsonProperty("language")
			String language,
			@JsonProperty("title")
			String title,
			@JsonProperty("view_count")
			int viewCount,
			@JsonProperty("created_at")
			String createdAt,
			@JsonProperty("thumbnail_url")
			String thumbnailURL,
			@JsonProperty("duration")
			double duration
	) {
		this.id = id;
		this.url = URI.create(url);
		this.embedURL = URI.create(embedURL);
		this.broadcasterID = broadcasterID;
		this.broadcasterName = broadcasterName;
		this.creatorID = creatorID;
		this.creatorName = creatorName;
		this.videoID = videoID;
		this.gameID = gameID;
		this.language = language;
		this.title = title;
		this.viewCount = viewCount;
		this.createdAt = Instant.parse(createdAt);
		this.thumbnailURL = URI.create(thumbnailURL);
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "GetClipsResponse{" + "id='" + id + '\'' + ", url=" + url + ", embedURL=" + embedURL + ", broadcasterID='" + broadcasterID + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", creatorID='" + creatorID + '\'' + ", creatorName='" + creatorName + '\'' + ", videoID='" + videoID + '\'' + ", gameID='" + gameID + '\'' + ", language='" + language + '\'' + ", title='" + title + '\'' + ", viewCount=" + viewCount + ", createdAt=" + createdAt + ", thumbnailURL=" + thumbnailURL + ", duration=" + duration + '}';
	}
}
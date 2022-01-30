package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.VideoMutedSegment;
import io.github.akjo03.util.apis.twitch.data.util.VideoType;
import io.github.akjo03.util.apis.twitch.data.util.Viewable;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetVideosResponse extends TwitchApiResponse<GetVideosResponse> {
	private final String id;
	private final String streamID;
	private final String userID;
	private final String userLogin;
	private final String userName;
	private final String title;
	private final String description;
	private final Instant createdAt;
	private final Instant publishedAt;
	private final URI videoURL;
	private final URI thumbnailURL;
	private final Viewable viewable;
	private final int viewCount;
	private final String language;
	private final VideoType type;
	private final String duration;
	private final List<VideoMutedSegment> mutedSegments;

	public GetVideosResponse(
			@JsonProperty("id")
			String id,
			@JsonProperty("stream_id")
			String streamID,
			@JsonProperty("user_id")
			String userID,
			@JsonProperty("user_login")
			String userLogin,
			@JsonProperty("user_name")
			String userName,
			@JsonProperty("title")
			String title,
			@JsonProperty("description")
			String description,
			@JsonProperty("created_at")
			String createdAt,
			@JsonProperty("published_at")
			String publishedAt,
			@JsonProperty("url")
			String videoURL,
			@JsonProperty("thumbnail_url")
			String thumbnailURL,
			@JsonProperty("viewable")
			String viewable,
			@JsonProperty("view_count")
			int viewCount,
			@JsonProperty("language")
			String language,
			@JsonProperty("type")
			String type,
			@JsonProperty("duration")
			String duration,
			@JsonProperty("muted_segments")
			VideoMutedSegment[] mutedSegments
	) {
		this.id = id;
		this.streamID = streamID;
		this.userID = userID;
		this.userLogin = userLogin;
		this.userName = userName;
		this.title = title;
		this.description = description;
		this.createdAt = Instant.parse(createdAt);
		this.publishedAt = Instant.parse(publishedAt);
		this.videoURL = URI.create(videoURL);
		this.thumbnailURL = URI.create(thumbnailURL.replace("{width}", "1920").replace("{height}", "1080"));
		this.viewable = Viewable.fromString(viewable);
		this.viewCount = viewCount;
		this.language = language;
		this.type = VideoType.fromString(type);
		this.duration = duration;
		this.mutedSegments = mutedSegments != null ? List.of(mutedSegments) : List.of();
	}

	@Override
	public String toString() {
		return "GetVideosResponse{" + "id='" + id + '\'' + ", streamID='" + streamID + '\'' + ", userID='" + userID + '\'' + ", userLogin='" + userLogin + '\'' + ", userName='" + userName + '\'' + ", title='" + title + '\'' + ", description='" + description + '\'' + ", createdAt=" + createdAt + ", publishedAt=" + publishedAt + ", videoURL=" + videoURL + ", thumbnailURL=" + thumbnailURL + ", viewable=" + viewable + ", viewCount=" + viewCount + ", language='" + language + '\'' + ", type=" + type + ", duration='" + duration + '\'' + ", mutedSegments=" + mutedSegments + '}';
	}
}
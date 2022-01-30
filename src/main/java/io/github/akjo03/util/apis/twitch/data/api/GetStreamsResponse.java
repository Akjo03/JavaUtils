package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStreamsResponse extends TwitchApiResponse<GetStreamsResponse> {
	private final String id;
	private final String userID;
	private final String userLogin;
	private final String userName;
	private final String gameID;
	private final String gameName;
	private final boolean isLive;
	private final String title;
	private final int viewerCount;
	private final Instant startedAt;
	private final String language;
	private final URI thumbnailURL;
	private final String[] tagIDs;
	private final boolean isMature;

	public GetStreamsResponse(
			@JsonProperty("id")
			String id,
			@JsonProperty("user_id")
			String userID,
			@JsonProperty("user_login")
			String userLogin,
			@JsonProperty("user_name")
			String userName,
			@JsonProperty("game_id")
			String gameID,
			@JsonProperty("game_name")
			String gameName,
			@JsonProperty("type")
			String type,
			@JsonProperty("title")
			String title,
			@JsonProperty("viewer_count")
			int viewerCount,
			@JsonProperty("started_at")
			String startedAt,
			@JsonProperty("language")
			String language,
			@JsonProperty("thumbnail_url")
			String thumbnailURL,
			@JsonProperty("tag_ids")
			String[] tagIDs,
			@JsonProperty("is_mature")
			boolean isMature
	) {
		this.id = id;
		this.userID = userID;
		this.userLogin = userLogin;
		this.userName = userName;
		this.gameID = gameID;
		this.gameName = gameName;
		this.isLive = type.equals("live");
		this.title = title;
		this.viewerCount = viewerCount;
		this.startedAt = Instant.parse(startedAt);
		this.language = language;
		this.thumbnailURL = URI.create(thumbnailURL.replace("{width}", "1920").replace("{height}", "1080"));
		this.tagIDs = tagIDs;
		this.isMature = isMature;
	}

	@Override
	public String toString() {
		return "GetStreamsResponse{" + "id='" + id + '\'' + ", userID='" + userID + '\'' + ", userLogin='" + userLogin + '\'' + ", userName='" + userName + '\'' + ", gameID='" + gameID + '\'' + ", gameName='" + gameName + '\'' + ", isLive=" + isLive + ", title='" + title + '\'' + ", viewerCount=" + viewerCount + ", startedAt=" + startedAt + ", language='" + language + '\'' + ", thumbnailURL=" + thumbnailURL + ", tagIDs=" + Arrays.toString(tagIDs) + ", isMature=" + isMature + '}';
	}
}
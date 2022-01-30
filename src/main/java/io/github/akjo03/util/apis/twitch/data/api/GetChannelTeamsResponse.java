package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChannelTeamsResponse extends TwitchApiResponse<GetChannelTeamsResponse> {
	private final String broadcasterID;
	private final String broadcasterLogin;
	private final String broadcasterName;
	private final URI backgroundImageURL;
	private final URI bannerURL;
	private final Instant createdAt;
	private final Instant updatedAt;
	private final String description;
	private final URI thumbnailURL;
	private final String teamName;
	private final String teamDisplayName;
	private final String teamID;

	public GetChannelTeamsResponse(
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_login")
			String broadcasterLogin,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("background_image_url")
			String backgroundImageURL,
			@JsonProperty("banner")
			String bannerURL,
			@JsonProperty("created_at")
			String createdAt,
			@JsonProperty("updated_at")
			String updatedAt,
			@JsonProperty("info")
			String description,
			@JsonProperty("thumbnail_url")
			String thumbnailURL,
			@JsonProperty("team_name")
			String teamName,
			@JsonProperty("team_display_name")
			String teamDisplayName,
			@JsonProperty("id")
			String teamID
	) {
		this.broadcasterID = broadcasterID;
		this.broadcasterLogin = broadcasterLogin;
		this.broadcasterName = broadcasterName;
		this.backgroundImageURL = URI.create(backgroundImageURL);
		this.bannerURL = URI.create(bannerURL);
		this.createdAt = Instant.parse(createdAt);
		this.updatedAt = Instant.parse(updatedAt);
		this.description = description;
		this.thumbnailURL = URI.create(thumbnailURL);
		this.teamName = teamName;
		this.teamDisplayName = teamDisplayName;
		this.teamID = teamID;
	}

	@Override
	public String toString() {
		return "GetChannelTeamsResponse{" + "broadcasterID='" + broadcasterID + '\'' + ", broadcasterLogin='" + broadcasterLogin + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", backgroundImageURL=" + backgroundImageURL + ", bannerURL=" + bannerURL + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", description='" + description + '\'' + ", thumbnailURL=" + thumbnailURL + ", teamName='" + teamName + '\'' + ", teamDisplayName='" + teamDisplayName + '\'' + ", teamID='" + teamID + '\'' + '}';
	}
}
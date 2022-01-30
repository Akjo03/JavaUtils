package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.TeamUser;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTeamsResponse extends TwitchApiResponse<GetTeamsResponse> {
	private final List<TeamUser> users;
	private final URI backgroundImageURL;
	private final URI bannerURL;
	private final Instant createdAt;
	private final Instant updatedAt;
	private final String description;
	private final URI thumbnailURL;
	private final String teamName;
	private final String teamDisplayName;
	private final String teamID;

	public GetTeamsResponse(
			@JsonProperty("users")
			TeamUser[] users,
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
		this.users = users != null ? List.of(users) : List.of();
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
		return "GetTeamsResponse{" + "users=" + users + ", backgroundImageURL=" + backgroundImageURL + ", bannerURL=" + bannerURL + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", description='" + description + '\'' + ", thumbnailURL=" + thumbnailURL + ", teamName='" + teamName + '\'' + ", teamDisplayName='" + teamDisplayName + '\'' + ", teamID='" + teamID + '\'' + '}';
	}
}
package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.BroadcasterType;
import io.github.akjo03.util.apis.twitch.data.util.UserType;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUsersResponse extends TwitchApiResponse<GetUsersResponse> {
	private final BroadcasterType broadcasterType;
	private final String description;
	private final String displayName;
	private final String id;
	private final String login;
	private final URI offlineImageURL;
	private final URI profileImageURL;
	private final UserType type;
	private final int viewCount;
	private final String email;
	private final Instant createdAt;

	public GetUsersResponse(
			@JsonProperty("broadcaster_type")
			String broadcasterType,
			@JsonProperty("description")
			String description,
			@JsonProperty("display_name")
			String displayName,
			@JsonProperty("id")
			String id,
			@JsonProperty("login")
			String login,
			@JsonProperty("offline_image_url")
			String offlineImageURL,
			@JsonProperty("profile_image_url")
			String profileImageURL,
			@JsonProperty("type")
			String type,
			@JsonProperty("view_count")
			int viewCount,
			@JsonProperty("email")
			String email,
			@JsonProperty("created_at")
			String createdAt
	) {
		this.broadcasterType = BroadcasterType.fromString(broadcasterType);
		this.description = description;
		this.displayName = displayName;
		this.id = id;
		this.login = login;
		this.offlineImageURL = URI.create(offlineImageURL);
		this.profileImageURL = URI.create(profileImageURL);
		this.type = UserType.fromString(type);
		this.viewCount = viewCount;
		this.email = email;
		this.createdAt = Instant.parse(createdAt);
	}

	@Override
	public String toString() {
		return "GetUsersResponse{" + "broadcasterType=" + broadcasterType + ", description='" + description + '\'' + ", displayName='" + displayName + '\'' + ", id='" + id + '\'' + ", login='" + login + '\'' + ", offlineImageURL=" + offlineImageURL + ", profileImageURL=" + profileImageURL + ", type=" + type + ", viewCount=" + viewCount + ", email='" + email + '\'' + ", createdAt=" + createdAt + '}';
	}
}
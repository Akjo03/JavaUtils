package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserFollowsResponse extends TwitchApiResponse<GetUserFollowsResponse> {
	private final Instant followedAt;
	private final String fromID;
	private final String fromLogin;
	private final String fromName;
	private final String toID;
	private final String toLogin;
	private final String toName;
	private final int total;

	public GetUserFollowsResponse(
			@JsonProperty("followed_at")
			String followedAt,
			@JsonProperty("from_id")
			String fromID,
			@JsonProperty("from_login")
			String fromLogin,
			@JsonProperty("from_name")
			String fromName,
			@JsonProperty("to_id")
			String toID,
			@JsonProperty("to_login")
			String toLogin,
			@JsonProperty("to_name")
			String toName,
			@JsonProperty("total")
			int total
	) {
		this.followedAt = Instant.parse(followedAt);
		this.fromID = fromID;
		this.fromLogin = fromLogin;
		this.fromName = fromName;
		this.toID = toID;
		this.toLogin = toLogin;
		this.toName = toName;
		this.total = total;
	}

	@Override
	public String toString() {
		return "GetUserFollows{" + "followedAt=" + followedAt + ", fromID='" + fromID + '\'' + ", fromLogin='" + fromLogin + '\'' + ", fromName='" + fromName + '\'' + ", toID='" + toID + '\'' + ", toLogin='" + toLogin + '\'' + ", toName='" + toName + '\'' + ", total=" + total + '}';
	}
}
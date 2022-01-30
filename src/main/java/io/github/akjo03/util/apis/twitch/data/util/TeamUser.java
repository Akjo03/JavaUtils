package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamUser implements JsonParsable {
	private final String userID;
	private final String userLogin;
	private final String userName;

	public TeamUser(
			@JsonProperty("user_id")
			String userID,
			@JsonProperty("user_login")
			String userLogin,
			@JsonProperty("user_name")
			String userName
	) {
		this.userID = userID;
		this.userLogin = userLogin;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "TeamUser{" + "userID='" + userID + '\'' + ", userLogin='" + userLogin + '\'' + ", userName='" + userName + '\'' + '}';
	}
}
package io.github.akjo03.util.apis.twitch.data.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Getter
@SuppressWarnings("ClassCanBeRecord")
public class OAuthToken implements JsonParsable {
	@NotNull private final String accessToken;
	private final String refreshToken;
	private final int expiresIn;
	@NotNull private final String[] scopes;
	@NotNull private final String tokenType;

	public OAuthToken(
			@JsonProperty("access_token")
			@NotNull String accessToken,
			@JsonProperty("refresh_token")
			String refreshToken,
			@JsonProperty("expires_in")
			int expiresIn,
			@JsonProperty("scope")
			String[] scopes,
			@JsonProperty("token_type")
			@NotNull String tokenType
	) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expiresIn = expiresIn;
		this.scopes = scopes;
		this.tokenType = tokenType;
	}

	@Override
	public String toString() {
		return "OAuthToken{" + "accessToken='" + accessToken + '\'' + ", refreshToken='" + refreshToken + '\'' + ", expiresIn=" + expiresIn + ", scopes=" + Arrays.toString(scopes) + ", tokenType='" + tokenType + '\'' + '}';
	}
}
package io.github.akjo03.util.apis.twitch;

import io.github.akjo03.util.apis.twitch.data.auth.OAuthToken;
import io.github.akjo03.util.builder.Builder;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import io.github.akjo03.util.net.requests.HttpRequest;
import io.github.akjo03.util.net.requests.HttpRequestBuilder;

import java.io.IOException;
import java.net.URI;

@SuppressWarnings("unused")
public class TwitchClientBuilder implements Builder<TwitchClient> {
	private static final Logger LOGGER = LoggerManager.getLogger(TwitchClientBuilder.class, LoggingLevel.INFO);

	private final String clientID;
	private final String clientSecret;
	private static final String grantType = "client_credentials";
	private String[] scopes;

	public TwitchClientBuilder(String clientID, String clientSecret) {
		this.clientID = clientID;
		this.clientSecret = clientSecret;
	}

	public TwitchClientBuilder withScopes(String... scopes) {
		this.scopes = scopes;
		return this;
	}

	@Override
	public TwitchClient build() {
		URI tokenURI;
		if (scopes == null) {
			tokenURI = URI.create("https://id.twitch.tv/oauth2/token" + "?client_id=" + clientID + "&client_secret=" + clientSecret + "&grant_type=" + grantType);
		} else {
			tokenURI = URI.create("https://id.twitch.tv/oauth2/token" + "?client_id=" + clientID + "&client_secret=" + clientSecret + "&grant_type=" + grantType + "&scope=" + String.join(" ", scopes));
		}
		HttpRequest tokenRequest = new HttpRequestBuilder(tokenURI).build();
		OAuthToken token;
		try {
			token = tokenRequest.post().json(OAuthToken.class);
		} catch (IOException | InterruptedException e) {
			LOGGER.log(e);
			return null;
		}
		return new TwitchClient(clientID, token);
	}
}
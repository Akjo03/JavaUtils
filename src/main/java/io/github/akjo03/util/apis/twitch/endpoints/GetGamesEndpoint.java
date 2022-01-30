package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetGamesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetGamesEndpoint extends TwitchEndpoint<GetGamesResponse> {
	public GetGamesEndpoint() {
		super(GetGamesResponse.class, "GetGames", "/games", new HttpMethods[] { HttpMethods.GET });
	}
}
package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetTopGamesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetTopGamesEndpoint extends TwitchEndpoint<GetTopGamesResponse> {
	public GetTopGamesEndpoint() {
		super(GetTopGamesResponse.class, "GetTopGames", "/games/top", new HttpMethods[] { HttpMethods.GET });
	}
}
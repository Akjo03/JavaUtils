package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetCheermotesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetCheermotesEndpoint extends TwitchEndpoint<GetCheermotesResponse> {
	public GetCheermotesEndpoint() {
		super(GetCheermotesResponse.class, "GetCheermotes", "/bits/cheermotes", new HttpMethods[]{ HttpMethods.GET });
	}
}
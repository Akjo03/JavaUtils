package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetGlobalEmotesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetGlobalEmotesEndpoint extends TwitchEndpoint<GetGlobalEmotesResponse> {
	public GetGlobalEmotesEndpoint() {
		super(GetGlobalEmotesResponse.class, "GetGlobalEmotes", "/chat/emotes/global", new HttpMethods[]{ HttpMethods.GET });
	}
}
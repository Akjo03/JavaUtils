package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChannelEmotesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChannelEmotesEndpoint extends TwitchEndpoint<GetChannelEmotesResponse> {
	public GetChannelEmotesEndpoint() {
		super(GetChannelEmotesResponse.class, "GetChannelEmotes", "/chat/emotes", new HttpMethods[]{ HttpMethods.GET });
	}
}
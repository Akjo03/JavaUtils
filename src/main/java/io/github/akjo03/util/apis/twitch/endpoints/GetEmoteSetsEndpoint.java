package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetEmoteSetsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetEmoteSetsEndpoint extends TwitchEndpoint<GetEmoteSetsResponse> {
	public GetEmoteSetsEndpoint() {
		super(GetEmoteSetsResponse.class, "GetEmoteSets", "/chat/badges", new HttpMethods[] { HttpMethods.GET });
	}
}
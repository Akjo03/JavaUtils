package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetStreamsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetStreamsEndpoint extends TwitchEndpoint<GetStreamsResponse> {
	public GetStreamsEndpoint() {
		super(GetStreamsResponse.class, "GetStreams", "/streams", new HttpMethods[] { HttpMethods.GET });
	}
}
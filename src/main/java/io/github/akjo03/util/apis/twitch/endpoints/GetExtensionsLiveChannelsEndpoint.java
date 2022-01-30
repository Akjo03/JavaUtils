package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetExtensionLiveChannelsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetExtensionsLiveChannelsEndpoint extends TwitchEndpoint<GetExtensionLiveChannelsResponse> {
	public GetExtensionsLiveChannelsEndpoint() {
		super(GetExtensionLiveChannelsResponse.class, "GetExtensionLiveChannels", "/extensions/live", new HttpMethods[] { HttpMethods.GET });
	}
}
package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChannelChatBadgesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChannelChatBadgesEndpoint extends TwitchEndpoint<GetChannelChatBadgesResponse> {
	public GetChannelChatBadgesEndpoint() {
		super(GetChannelChatBadgesResponse.class, "GetChannelChatBadges", "/chat/badges", new HttpMethods[]{ HttpMethods.GET });
	}
}
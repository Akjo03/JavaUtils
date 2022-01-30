package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetGlobalChatBadgesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetGlobalChatBadgesEndpoint extends TwitchEndpoint<GetGlobalChatBadgesResponse> {
	public GetGlobalChatBadgesEndpoint() {
		super(GetGlobalChatBadgesResponse.class, "GetGlobalChatBadges", "/chat/badges/global", new HttpMethods[] { HttpMethods.GET });
	}
}
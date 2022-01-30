package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChatSettingsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChatSettingsEndpoint extends TwitchEndpoint<GetChatSettingsResponse> {
	public GetChatSettingsEndpoint() {
		super(GetChatSettingsResponse.class, "GetChatSettings", "/chat/settings", new HttpMethods[] { HttpMethods.GET });
	}
}
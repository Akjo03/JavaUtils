package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChannelTeamsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChannelTeamsEndpoint extends TwitchEndpoint<GetChannelTeamsResponse> {
	public GetChannelTeamsEndpoint() {
		super(GetChannelTeamsResponse.class, "GetChannelTeams", "/teams/channel", new HttpMethods[] { HttpMethods.GET });
	}
}
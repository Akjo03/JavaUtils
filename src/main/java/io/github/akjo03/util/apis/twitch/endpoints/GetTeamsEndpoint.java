package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetTeamsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetTeamsEndpoint extends TwitchEndpoint<GetTeamsResponse> {
	public GetTeamsEndpoint() {
		super(GetTeamsResponse.class, "GetTeams", "/teams", new HttpMethods[] { HttpMethods.GET });
	}
}
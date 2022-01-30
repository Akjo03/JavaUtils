package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetUserFollowsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetUserFollowsEndpoint extends TwitchEndpoint<GetUserFollowsResponse> {
	public GetUserFollowsEndpoint() {
		super(GetUserFollowsResponse.class, "GetUserFollows", "/users/follows", new HttpMethods[] { HttpMethods.GET });
	}
}
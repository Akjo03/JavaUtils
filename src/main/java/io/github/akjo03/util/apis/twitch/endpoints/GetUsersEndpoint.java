package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetUsersResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetUsersEndpoint extends TwitchEndpoint<GetUsersResponse> {
	public GetUsersEndpoint() {
		super(GetUsersResponse.class, "GetUsers", "/users", new HttpMethods[] { HttpMethods.GET });
	}
}
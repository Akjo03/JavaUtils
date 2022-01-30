package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetReleasedExtensionsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetReleasedExtensionsEndpoint extends TwitchEndpoint<GetReleasedExtensionsResponse> {
	public GetReleasedExtensionsEndpoint() {
		super(GetReleasedExtensionsResponse.class, "GetReleasedExtensions", "/extensions/released", new HttpMethods[] { HttpMethods.GET });
	}
}
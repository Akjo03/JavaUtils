package io.github.akjo03.util.apis.twitch.data.util;

import io.github.akjo03.util.apis.twitch.data.api.GetStreamTagsResponse;
import io.github.akjo03.util.apis.twitch.endpoints.TwitchEndpoint;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetStreamTagsEndpoint extends TwitchEndpoint<GetStreamTagsResponse> {
	public GetStreamTagsEndpoint() {
		super(GetStreamTagsResponse.class, "GetStreamTags", "/streams/tags", new HttpMethods[] { HttpMethods.GET });
	}
}
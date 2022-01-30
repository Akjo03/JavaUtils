package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetAllStreamTagsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetAllStreamTagsEndpoint extends TwitchEndpoint<GetAllStreamTagsResponse> {
	public GetAllStreamTagsEndpoint() {
		super(GetAllStreamTagsResponse.class, "GetAllStreamTags", "/tags/streams", new HttpMethods[]{ HttpMethods.GET });
	}
}
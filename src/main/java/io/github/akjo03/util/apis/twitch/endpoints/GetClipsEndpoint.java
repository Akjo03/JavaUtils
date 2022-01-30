package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetClipsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetClipsEndpoint extends TwitchEndpoint<GetClipsResponse> {
	public GetClipsEndpoint() {
		super(GetClipsResponse.class, "GetClips", "/clips", new HttpMethods[] { HttpMethods.GET });
	}
}
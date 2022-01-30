package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetVideosResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetVideosEndpoint extends TwitchEndpoint<GetVideosResponse> {
	public GetVideosEndpoint() {
		super(GetVideosResponse.class, "GetVideos", "/videos", new HttpMethods[] { HttpMethods.GET });
	}
}
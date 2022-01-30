package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChannelInformationResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChannelInformationEndpoint extends TwitchEndpoint<GetChannelInformationResponse> {
	public GetChannelInformationEndpoint() {
		super(GetChannelInformationResponse.class, "GetChannelInformation", "/channels", new HttpMethods[]{ HttpMethods.GET });
	}
}
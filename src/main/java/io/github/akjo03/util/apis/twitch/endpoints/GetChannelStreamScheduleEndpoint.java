package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetChannelStreamScheduleResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetChannelStreamScheduleEndpoint extends TwitchEndpoint<GetChannelStreamScheduleResponse> {
	public GetChannelStreamScheduleEndpoint() {
		super(GetChannelStreamScheduleResponse.class, "GetChannelStreamSchedule", "/schedule", new HttpMethods[] { HttpMethods.GET });
	}
}
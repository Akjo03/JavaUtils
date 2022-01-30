package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.ScheduledStream;
import io.github.akjo03.util.apis.twitch.data.util.StreamVacation;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChannelStreamScheduleResponse extends TwitchApiResponse<GetChannelStreamScheduleResponse> {
	private final List<ScheduledStream> scheduledStreams;
	private final boolean isRecurring;
	private final String broadcasterID;
	private final String broadcasterName;
	private final String broadcasterLogin;
	private final StreamVacation vacationInfo;

	public GetChannelStreamScheduleResponse(
			@JsonProperty("segments")
			ScheduledStream[] scheduledStreams,
			@JsonProperty("is_recurring")
			boolean isRecurring,
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("broadcaster_login")
			String broadcasterLogin,
			@JsonProperty("vacation")
			StreamVacation vacationInfo
	) {
		this.scheduledStreams = scheduledStreams != null ? List.of(scheduledStreams) : List.of();
		this.isRecurring = isRecurring;
		this.broadcasterID = broadcasterID;
		this.broadcasterName = broadcasterName;
		this.broadcasterLogin = broadcasterLogin;
		this.vacationInfo = vacationInfo;
	}

	@Override
	public String toString() {
		return "GetChannelStreamScheduleResponse{" + "scheduledStreams=" + scheduledStreams + ", isRecurring=" + isRecurring + ", broadcasterID='" + broadcasterID + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", broadcasterLogin='" + broadcasterLogin + '\'' + ", vacationInfo=" + vacationInfo + '}';
	}
}
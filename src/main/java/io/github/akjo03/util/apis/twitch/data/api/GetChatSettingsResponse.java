package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChatSettingsResponse extends TwitchApiResponse<GetChatSettingsResponse> {
	private final String broadcasterID;
	private final boolean emoteMode;
	private final boolean followerMode;
	private final int followerModeDuration;
	private final String moderatorID;
	private final boolean nonModeratorChatDelay;
	private final int nonModeratorChatDelayDuration;
	private final boolean slowMode;
	private final int slowModeWaitTime;
	private final boolean subscriberMode;
	private final boolean uniqueChatMode;

	public GetChatSettingsResponse(
			@JsonProperty("id")
			String broadcasterID,
			@JsonProperty("emote_mode")
			boolean emoteMode,
			@JsonProperty("follower_mode")
			boolean followerMode,
			@JsonProperty("follower_mode_duration")
			int followerModeDuration,
			@JsonProperty("moderator_id")
			String moderatorID,
			@JsonProperty("non_moderator_chat_delay")
			boolean nonModeratorChatDelay,
			@JsonProperty("non_moderator_chat_delay_duration")
			int nonModeratorChatDelayDuration,
			@JsonProperty("slow_mode")
			boolean slowMode,
			@JsonProperty("slow_mode_wait_time")
			int slowModeWaitTime,
			@JsonProperty("subscriber_mode")
			boolean subscriberMode,
			@JsonProperty("unique_chat_mode")
			boolean uniqueChatMode
	) {
		this.broadcasterID = broadcasterID;
		this.emoteMode = emoteMode;
		this.followerMode = followerMode;
		this.followerModeDuration = followerModeDuration;
		this.moderatorID = moderatorID;
		this.nonModeratorChatDelay = nonModeratorChatDelay;
		this.nonModeratorChatDelayDuration = nonModeratorChatDelayDuration;
		this.slowMode = slowMode;
		this.slowModeWaitTime = slowModeWaitTime;
		this.subscriberMode = subscriberMode;
		this.uniqueChatMode = uniqueChatMode;
	}

	@Override
	public String toString() {
		return "GetChatSettingsResponse{" + "broadcasterID='" + broadcasterID + '\'' + ", emoteMode=" + emoteMode + ", followerMode=" + followerMode + ", followerModeDuration=" + followerModeDuration + ", moderatorID='" + moderatorID + '\'' + ", nonModeratorChatDelay=" + nonModeratorChatDelay + ", nonModeratorChatDelayDuration=" + nonModeratorChatDelayDuration + ", slowMode=" + slowMode + ", slowModeWaitTime=" + slowModeWaitTime + ", subscriberMode=" + subscriberMode + ", uniqueChatMode=" + uniqueChatMode + '}';
	}
}
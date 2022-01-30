package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.ChatBadgeVersion;
import lombok.Getter;

import java.util.List;

@Getter
public class GetChannelChatBadgesResponse extends TwitchApiResponse<GetChannelChatBadgesResponse> {
	private final String setID;
	private final List<ChatBadgeVersion> versions;

	public GetChannelChatBadgesResponse(
			@JsonProperty("set_id")
			String setID,
			@JsonProperty("versions")
			ChatBadgeVersion[] versions
	) {
		this.setID = setID;
		this.versions = versions != null ? List.of(versions) : List.of();
	}

	@Override
	public String toString() {
		return "GetChannelChatBadgesResponse{" + "setID='" + setID + '\'' + ", versions=" + versions + '}';
	}
}
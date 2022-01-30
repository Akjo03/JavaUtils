package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetExtensionLiveChannelsResponse extends TwitchApiResponse<GetExtensionLiveChannelsResponse> {
	private final String title;
	private final String broadcasterID;
	private final String broadcasterName;
	private final String gameName;
	private final String gameID;

	public GetExtensionLiveChannelsResponse(
			@JsonProperty("title")
			String title,
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("game_name")
			String gameName,
			@JsonProperty("game_id")
			String gameID
	) {
		this.title = title;
		this.broadcasterID = broadcasterID;
		this.broadcasterName = broadcasterName;
		this.gameName = gameName;
		this.gameID = gameID;
	}

	@Override
	public String toString() {
		return "GetExtensionLiveChannelsResponse{" + "title='" + title + '\'' + ", broadcasterID='" + broadcasterID + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", gameName='" + gameName + '\'' + ", gameID='" + gameID + '\'' + '}';
	}
}
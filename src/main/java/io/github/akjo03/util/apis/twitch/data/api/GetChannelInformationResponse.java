package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChannelInformationResponse extends TwitchApiResponse<GetChannelInformationResponse> {
	private final String broadcasterID;
	private final String broadcasterLogin;
	private final String broadcasterName;
	private final String gameName;
	private final String gameID;
	private final String broadcasterLanguage;
	private final String streamTitle;
	private final int streamDelay;

	public GetChannelInformationResponse(
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_login")
			String broadcasterLogin,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("game_name")
			String gameName,
			@JsonProperty("game_id")
			String gameID,
			@JsonProperty("broadcaster_language")
			String broadcasterLanguage,
			@JsonProperty("title")
			String streamTitle,
			@JsonProperty("delay")
			int streamDelay
	) {
		this.broadcasterID = broadcasterID;
		this.broadcasterLogin = broadcasterLogin;
		this.broadcasterName = broadcasterName;
		this.gameName = gameName;
		this.gameID = gameID;
		this.broadcasterLanguage = broadcasterLanguage;
		this.streamTitle = streamTitle;
		this.streamDelay = streamDelay;
	}

	@Override
	public String toString() {
		return "GetChannelInformationResponse{" + "broadcasterID='" + broadcasterID + '\'' + ", broadcasterLogin='" + broadcasterLogin + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", gameName='" + gameName + '\'' + ", gameID='" + gameID + '\'' + ", broadcasterLanguage='" + broadcasterLanguage + '\'' + ", streamTitle='" + streamTitle + '\'' + ", streamDelay=" + streamDelay + '}';
	}
}
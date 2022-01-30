package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.net.URI;
import java.time.Instant;
import java.util.Arrays;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchChannelsResponse extends TwitchApiResponse<SearchChannelsResponse> {
	private final String broadcasterLanguage;
	private final String broadcasterLogin;
	private final String displayName;
	private final String gameID;
	private final String gameName;
	private final String channelID;
	private final boolean isLive;
	private final String[] tagIDs;
	private final URI thumbnailURL;
	private final String streamTitle;
	private final Instant startedAt;

	public SearchChannelsResponse(
			String broadcasterLanguage,
			String broadcasterLogin,
			String displayName,
			String gameID,
			String gameName,
			String channelID,
			boolean isLive,
			String[] tagIDs,
			String thumbnailURL,
			String streamTitle,
			String startedAt
	) {
		this.broadcasterLanguage = broadcasterLanguage;
		this.broadcasterLogin = broadcasterLogin;
		this.displayName = displayName;
		this.gameID = gameID;
		this.gameName = gameName;
		this.channelID = channelID;
		this.isLive = isLive;
		this.tagIDs = tagIDs;
		this.thumbnailURL = URI.create(thumbnailURL.replace("{width}", "1920").replace("{height}", "1080"));
		this.streamTitle = streamTitle;
		this.startedAt = Instant.parse(startedAt);
	}

	@Override
	public String toString() {
		return "SearchChannelsResponse{" + "broadcasterLanguage='" + broadcasterLanguage + '\'' + ", broadcasterLogin='" + broadcasterLogin + '\'' + ", displayName='" + displayName + '\'' + ", gameID='" + gameID + '\'' + ", gameName='" + gameName + '\'' + ", channelID='" + channelID + '\'' + ", isLive=" + isLive + ", tagIDs=" + Arrays.toString(tagIDs) + ", thumbnailURL=" + thumbnailURL + ", streamTitle='" + streamTitle + '\'' + ", startedAt=" + startedAt + '}';
	}
}

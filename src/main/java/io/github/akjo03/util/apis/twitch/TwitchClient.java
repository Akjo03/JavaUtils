package io.github.akjo03.util.apis.twitch;

import io.github.akjo03.util.apis.twitch.data.api.TwitchApiResponse;
import io.github.akjo03.util.apis.twitch.data.auth.OAuthToken;
import io.github.akjo03.util.apis.twitch.data.util.GetStreamTagsEndpoint;
import io.github.akjo03.util.apis.twitch.endpoints.*;
import io.github.akjo03.util.builder.Buildable;
import lombok.Getter;
import org.apache.commons.collections4.MultiValuedMap;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Currently only supports App OAuth Authentication and endpoints that use the GET method.
 */
@Getter
@SuppressWarnings("unused")
public class TwitchClient implements Buildable {
	@NotNull private final String clientID;
	@NotNull private final OAuthToken authToken;

	@NotNull private final Map<String, String> userAccessHeaders;

	public static final class Endpoints {
		@NotNull public static final GetCheermotesEndpoint GET_CHEERMOTES = new GetCheermotesEndpoint();
		@NotNull public static final GetExtensionTransactionsEndpoint GET_EXTENSION_TRANSACTIONS = new GetExtensionTransactionsEndpoint();
		@NotNull public static final GetChannelInformationEndpoint GET_CHANNEL_INFORMATION = new GetChannelInformationEndpoint();
		@NotNull public static final GetChannelEmotesEndpoint GET_CHANNEL_EMOTES = new GetChannelEmotesEndpoint();
		@NotNull public static final GetGlobalEmotesEndpoint GET_GLOBAL_EMOTES = new GetGlobalEmotesEndpoint();
		@NotNull public static final GetEmoteSetsEndpoint GET_EMOTE_SETS = new GetEmoteSetsEndpoint();
		@NotNull public static final GetChannelChatBadgesEndpoint GET_CHANNEL_CHAT_BADGES = new GetChannelChatBadgesEndpoint();
		@NotNull public static final GetGlobalChatBadgesEndpoint GET_GLOBAL_CHAT_BADGES = new GetGlobalChatBadgesEndpoint();
		@NotNull public static final GetChatSettingsEndpoint GET_CHAT_SETTINGS = new GetChatSettingsEndpoint();
		@NotNull public static final GetClipsEndpoint GET_CLIPS = new GetClipsEndpoint();
		@NotNull public static final GetExtensionsLiveChannelsEndpoint GET_EXTENSION_LIVE_CHANNELS = new GetExtensionsLiveChannelsEndpoint();
		@NotNull public static final GetReleasedExtensionsEndpoint GET_RELEASED_EXTENSIONS = new GetReleasedExtensionsEndpoint();
		@NotNull public static final GetExtensionBitsProductsEndpoint GET_EXTENSION_BITS_PRODUCTS = new GetExtensionBitsProductsEndpoint();
		@NotNull public static final GetTopGamesEndpoint GET_TOP_GAMES = new GetTopGamesEndpoint();
		@NotNull public static final GetGamesEndpoint GET_GAMES = new GetGamesEndpoint();
		@NotNull public static final GetChannelStreamScheduleEndpoint GET_CHANNEL_STREAM_SCHEDULE = new GetChannelStreamScheduleEndpoint();
		@NotNull public static final SearchCategoriesEndpoint SEARCH_CATEGORIES = new SearchCategoriesEndpoint();
		@NotNull public static final GetStreamsEndpoint GET_STREAMS = new GetStreamsEndpoint();
		@NotNull public static final GetAllStreamTagsEndpoint GET_ALL_STREAM_TAGS = new GetAllStreamTagsEndpoint();
		@NotNull public static final GetStreamTagsEndpoint GET_STREAM_TAGS = new GetStreamTagsEndpoint();
		@NotNull public static final GetChannelTeamsEndpoint GET_CHANNEL_TEAMS = new GetChannelTeamsEndpoint();
		@NotNull public static final GetTeamsEndpoint GET_TEAMS = new GetTeamsEndpoint();
		@NotNull public static final GetUsersEndpoint GET_USERS = new GetUsersEndpoint();
		@NotNull public static final GetUserFollowsEndpoint GET_USER_FOLLOWS = new GetUserFollowsEndpoint();
		@NotNull public static final GetVideosEndpoint GET_VIDEOS = new GetVideosEndpoint();
	}

	TwitchClient(@NotNull String clientID, @NotNull OAuthToken authToken) {
		this.clientID = clientID;
		this.authToken = authToken;

		this.userAccessHeaders = Map.of(
				"Client-ID", clientID,
				"Authorization", "Bearer " + authToken.getAccessToken()
		);
	}

	public <R extends TwitchApiResponse<R>> List<R> getAllData(@NotNull TwitchEndpoint<R> endpoint, @NotNull MultiValuedMap<String, String> queryParams) {
		return endpoint.getAllData(userAccessHeaders, queryParams, Integer.MAX_VALUE);
	}

	public <R extends TwitchApiResponse<R>> List<R> getFirstData(@NotNull TwitchEndpoint<R> endpoint, @NotNull MultiValuedMap<String, String> queryParams, int limit) {
		return endpoint.getAllData(userAccessHeaders, queryParams, limit);
	}

	public <R extends TwitchApiResponse<R>> R getDataByIndex(@NotNull TwitchEndpoint<R> endpoint, @NotNull MultiValuedMap<String, String> queryParams, int index) {
		return endpoint.getDataByIndex(userAccessHeaders, queryParams, index);
	}
}
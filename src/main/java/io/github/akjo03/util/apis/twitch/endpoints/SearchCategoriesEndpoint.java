package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.SearchCategoriesResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class SearchCategoriesEndpoint extends TwitchEndpoint<SearchCategoriesResponse> {
	public SearchCategoriesEndpoint() {
		super(SearchCategoriesResponse.class, "SearchCategories", "/search/categories", new HttpMethods[] { HttpMethods.GET });
	}
}
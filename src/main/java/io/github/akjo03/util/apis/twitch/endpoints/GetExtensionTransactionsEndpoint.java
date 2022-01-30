package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetExtensionTransactionsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetExtensionTransactionsEndpoint extends TwitchEndpoint<GetExtensionTransactionsResponse> {
	public GetExtensionTransactionsEndpoint() {
		super(GetExtensionTransactionsResponse.class, "GetExtensionTransactions", "/extensions/transactions", new HttpMethods[]{ HttpMethods.GET });
	}
}
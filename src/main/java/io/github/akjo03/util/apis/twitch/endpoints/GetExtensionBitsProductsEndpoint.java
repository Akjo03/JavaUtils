package io.github.akjo03.util.apis.twitch.endpoints;

import io.github.akjo03.util.apis.twitch.data.api.GetExtensionBitsProductsResponse;
import io.github.akjo03.util.net.requests.HttpMethods;

public class GetExtensionBitsProductsEndpoint extends TwitchEndpoint<GetExtensionBitsProductsResponse> {
	public GetExtensionBitsProductsEndpoint() {
		super(GetExtensionBitsProductsResponse.class, "GetExtensionBitsProducts", "/bits/extensions", new HttpMethods[] { HttpMethods.GET });
	}
}
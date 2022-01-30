package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.ExtensionBitsProductCost;
import lombok.Getter;

import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetExtensionBitsProductsResponse extends TwitchApiResponse<GetExtensionBitsProductsResponse> {
	private final String sku;
	private final ExtensionBitsProductCost cost;
	private final boolean inDevelopment;
	private final String displayName;
	private final Instant expiration;
	private final boolean isBroadcast;

	public GetExtensionBitsProductsResponse(
			@JsonProperty("sku")
			String sku,
			@JsonProperty("cost")
			ExtensionBitsProductCost cost,
			@JsonProperty("in_development")
			boolean inDevelopment,
			@JsonProperty("display_name")
			String displayName,
			@JsonProperty("expiration")
			String expiration,
			@JsonProperty("is_broadcast")
			boolean isBroadcast
	) {
		this.sku = sku;
		this.cost = cost;
		this.inDevelopment = inDevelopment;
		this.displayName = displayName;
		this.expiration = Instant.parse(expiration);
		this.isBroadcast = isBroadcast;
	}

	@Override
	public String toString() {
		return "GetExtensionBitsProductsResponse{" + "sku='" + sku + '\'' + ", cost=" + cost + ", inDevelopment=" + inDevelopment + ", displayName='" + displayName + '\'' + ", expiration=" + expiration + ", isBroadcast=" + isBroadcast + '}';
	}
}
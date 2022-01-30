package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionTransactionProductData implements JsonParsable {
	private final String domain;
	private final String sku;
	private final ExtensionTransactionProductCost cost;
	private final boolean inDevelopment;
	private final String displayName;
	private final String expiration;
	private final boolean broadcast;

	public ExtensionTransactionProductData(
			@JsonProperty("domain")
			String domain,
			@JsonProperty("sku")
			String sku,
			@JsonProperty("cost")
			ExtensionTransactionProductCost cost,
			@JsonProperty("inDevelopment")
			boolean inDevelopment,
			@JsonProperty("displayName")
			String displayName,
			@JsonProperty("expiration")
			String expiration,
			@JsonProperty("broadcast")
			boolean broadcast
	) {
		this.domain = domain;
		this.sku = sku;
		this.cost = cost;
		this.inDevelopment = inDevelopment;
		this.displayName = displayName;
		this.expiration = expiration;
		this.broadcast = broadcast;
	}

	@Override
	public String toString() {
		return "ExtensionTransactionProductData{" + "domain='" + domain + '\'' + ", sku='" + sku + '\'' + ", cost=" + cost + ", inDevelopment=" + inDevelopment + ", displayName='" + displayName + '\'' + ", expiration='" + expiration + '\'' + ", broadcast=" + broadcast + '}';
	}
}

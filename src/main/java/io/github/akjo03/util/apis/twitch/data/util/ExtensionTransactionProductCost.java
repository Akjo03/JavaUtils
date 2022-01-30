package io.github.akjo03.util.apis.twitch.data.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings("unused")
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionTransactionProductCost implements JsonParsable {
	private final int amount;
	private final ExtensionTransactionProductCostType type;

	public ExtensionTransactionProductCost(
			@JsonProperty("amount")
			int amount,
			@JsonProperty("type")
			String type
	) {
		this.amount = amount;
		this.type = ExtensionTransactionProductCostType.fromString(type);
	}

	@Override
	public String toString() {
		return "ExtensionTransactionProductCost{" + "amount=" + amount + ", type='" + type + '\'' + '}';
	}
}
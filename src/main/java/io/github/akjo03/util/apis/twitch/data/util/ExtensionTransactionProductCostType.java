package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum ExtensionTransactionProductCostType {
	BITS;

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
	public static ExtensionTransactionProductCostType fromString(String costType) {
		return switch (costType) {
			case "bits" -> BITS;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "ExtensionTransactionProductCostType." + name();
	}
}
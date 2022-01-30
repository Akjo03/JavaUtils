package io.github.akjo03.util.apis.twitch.data.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum ExtemsionTransactionProductType {
	BITS_IN_EXTENSIONS;

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
	public static ExtemsionTransactionProductType fromString(String productType) {
		return switch (productType) {
			case "bits_in_extensions" -> BITS_IN_EXTENSIONS;
			default -> null;
		};
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "ExtemsionTransactionProductType." + name();
	}
}
package io.github.akjo03.util.apis.twitch.data.util;

public enum ExtensionBitsProductCostType {
	BITS;

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
	public static ExtensionBitsProductCostType fromString(String costType) {
		return switch (costType) {
			case "bits" -> BITS;
			default -> null;
		};
	}
}
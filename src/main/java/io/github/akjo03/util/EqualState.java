package io.github.akjo03.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum EqualState {
	ABOVE, BELOW, EQUAL;

	public static @NotNull EqualState getEqualState(double a, double b) {
		if (a > b) {
			return ABOVE;
		} else if (a < b) {
			return BELOW;
		} else {
			return EQUAL;
		}
	}

	@Contract(pure = true)
	@Override
	public @NotNull String toString() {
		return "EqualState." + name();
	}
}
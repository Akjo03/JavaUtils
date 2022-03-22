package io.github.akjo03.util.math;

import java.math.BigDecimal;
import java.math.MathContext;

public final class AdditionalBigDecimalMath {
	private AdditionalBigDecimalMath() {
		throw new IllegalStateException("AdditionalBigDecimalMath cannot be instantiated!");
	}

	public static BigDecimal toRadians(BigDecimal degrees, MathContext mathContext) {
		return degrees.multiply(MathConstants.PI.divide(new BigDecimal("180"), mathContext), mathContext);
	}

	public static BigDecimal toDegrees(BigDecimal radians, MathContext mathContext) {
		return radians.multiply(new BigDecimal("180").divide(MathConstants.PI, mathContext), mathContext);
	}
}
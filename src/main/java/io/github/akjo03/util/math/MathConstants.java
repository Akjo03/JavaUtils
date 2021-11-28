package io.github.akjo03.util.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class MathConstants {
	private MathConstants() {}

	public static final BigDecimal PI = new BigDecimal("3.14159265358979323846264338327950", new MathContext(34, RoundingMode.HALF_UP));
}
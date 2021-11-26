package io.github.akjo03.util.math.unit.units.length;

import io.github.akjo03.util.math.unit.base.BaseQuantity;

import java.math.BigDecimal;

public class Length extends BaseQuantity<LengthUnit> {
	public Length(BigDecimal value, LengthUnit unit) {
		super(value, unit);
	}
}
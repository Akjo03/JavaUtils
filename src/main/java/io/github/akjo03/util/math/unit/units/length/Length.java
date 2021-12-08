package io.github.akjo03.util.math.unit.units.length;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.base.BaseQuantity;

import java.math.BigDecimal;

public class Length extends BaseQuantity<LengthUnit> implements Comparable<Quantity<LengthUnit>> {
	public Length(BigDecimal value, LengthUnit unit) {
		super(value, unit);
	}
}
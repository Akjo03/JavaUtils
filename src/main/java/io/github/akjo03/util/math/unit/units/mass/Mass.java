package io.github.akjo03.util.math.unit.units.mass;

import io.github.akjo03.util.math.unit.base.BaseQuantity;

import java.math.BigDecimal;

public class Mass extends BaseQuantity<MassUnit> {
	public Mass(BigDecimal value, MassUnit unit) {
		super(value, unit);
	}
}
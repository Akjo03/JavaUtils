package io.github.akjo03.util.math.unit.units.time;

import io.github.akjo03.util.math.unit.base.BaseQuantity;

import java.math.BigDecimal;

public class Time extends BaseQuantity<TimeUnit> {
	public Time(BigDecimal value, TimeUnit unit) {
		super(value, unit);
	}
}
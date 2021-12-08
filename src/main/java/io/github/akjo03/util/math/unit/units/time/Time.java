package io.github.akjo03.util.math.unit.units.time;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.base.BaseQuantity;

import java.math.BigDecimal;

public class Time extends BaseQuantity<TimeUnit> implements Comparable<Quantity<TimeUnit>> {
	public Time(BigDecimal value, TimeUnit unit) {
		super(value, unit);
	}
}
package io.github.akjo03.util.math.unit.units.speed;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.derived.DerivedQuantity;

import java.math.BigDecimal;

public class Speed extends DerivedQuantity<SpeedUnit> implements Comparable<Quantity<SpeedUnit>> {
	public Speed(BigDecimal value, SpeedUnit unit) {
		super(value, unit);
	}
}

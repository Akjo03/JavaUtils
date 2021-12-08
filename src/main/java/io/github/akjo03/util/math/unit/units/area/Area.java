package io.github.akjo03.util.math.unit.units.area;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.derived.DerivedQuantity;

import java.math.BigDecimal;

public class Area extends DerivedQuantity<AreaUnit> implements Comparable<Quantity<AreaUnit>> {
	public Area(BigDecimal value, AreaUnit unit) {
		super(value, unit);
	}
}
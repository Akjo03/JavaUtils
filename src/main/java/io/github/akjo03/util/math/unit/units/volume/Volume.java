package io.github.akjo03.util.math.unit.units.volume;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.derived.DerivedQuantity;

import java.math.BigDecimal;

public class Volume extends DerivedQuantity<VolumeUnit> implements Comparable<Quantity<VolumeUnit>> {
	public Volume(BigDecimal value, VolumeUnit unit) {
		super(value, unit);
	}
}
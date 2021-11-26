package io.github.akjo03.util.math.unit.units.volume;

import io.github.akjo03.util.math.unit.derived.DerivedQuantity;

import java.math.BigDecimal;

public class Volume extends DerivedQuantity<VolumeUnit> {
	public Volume(BigDecimal value, VolumeUnit unit) {
		super(value, unit);
	}
}
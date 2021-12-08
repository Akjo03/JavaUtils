package io.github.akjo03.util.math.unit.units.area;

import io.github.akjo03.util.math.unit.derived.DerivedQuantityRange;
import org.jetbrains.annotations.NotNull;

public class AreaRange extends DerivedQuantityRange<AreaUnit> {
	public AreaRange(@NotNull Area min, Area max) {
		super(min, max);
	}

	@Override
	public @NotNull Area getMin() {
		return (Area) super.getMin();
	}

	@Override
	public @NotNull Area getMax() {
		return (Area) super.getMax();
	}
}
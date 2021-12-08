package io.github.akjo03.util.math.unit.units.volume;

import io.github.akjo03.util.math.unit.derived.DerivedQuantityRange;
import org.jetbrains.annotations.NotNull;

public class VolumeRange extends DerivedQuantityRange<VolumeUnit> {
	public VolumeRange(@NotNull Volume min, @NotNull Volume max) {
		super(min, max);
	}

	@Override
	public @NotNull Volume getMin() {
		return (Volume) super.getMin();
	}

	@Override
	public @NotNull Volume getMax() {
		return (Volume) super.getMax();
	}
}
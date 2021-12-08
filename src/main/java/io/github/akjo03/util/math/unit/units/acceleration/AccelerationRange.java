package io.github.akjo03.util.math.unit.units.acceleration;

import io.github.akjo03.util.math.unit.derived.DerivedQuantityRange;
import org.jetbrains.annotations.NotNull;

public class AccelerationRange extends DerivedQuantityRange<AccelerationUnit> {
	public AccelerationRange(@NotNull Acceleration min, @NotNull Acceleration max) {
		super(min, max);
	}

	@Override
	public @NotNull Acceleration getMin() {
		return (Acceleration) super.getMin();
	}

	@Override
	public @NotNull Acceleration getMax() {
		return (Acceleration) super.getMax();
	}
}
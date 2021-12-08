package io.github.akjo03.util.math.unit.units.length;

import io.github.akjo03.util.math.unit.base.BaseQuantityRange;
import org.jetbrains.annotations.NotNull;

public class LengthRange extends BaseQuantityRange<LengthUnit> {
	public LengthRange(@NotNull Length min, @NotNull Length max) {
		super(min, max);
	}

	@Override
	public @NotNull Length getMin() {
		return (Length) super.getMin();
	}

	@Override
	public @NotNull Length getMax() {
		return (Length) super.getMax();
	}
}
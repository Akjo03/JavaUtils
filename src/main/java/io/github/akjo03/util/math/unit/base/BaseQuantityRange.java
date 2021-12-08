package io.github.akjo03.util.math.unit.base;

import io.github.akjo03.util.math.unit.QuantityRange;
import org.jetbrains.annotations.NotNull;

public abstract class BaseQuantityRange<T extends BaseUnit<T>> extends QuantityRange<T> {
	protected BaseQuantityRange(@NotNull BaseQuantity<T> min, @NotNull BaseQuantity<T> max) {
		super(min, max);
	}

	@Override
	public @NotNull BaseQuantity<T> getMin() {
		return (BaseQuantity<T>) super.getMin();
	}

	@Override
	public @NotNull BaseQuantity<T> getMax() {
		return (BaseQuantity<T>) super.getMax();
	}
}
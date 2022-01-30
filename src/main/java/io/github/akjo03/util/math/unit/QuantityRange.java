package io.github.akjo03.util.math.unit;

import io.github.akjo03.util.math.Range;
import org.jetbrains.annotations.NotNull;

public abstract class QuantityRange<T extends Unit<T>> extends Range<Quantity<T>> {
	protected QuantityRange(@NotNull Quantity<T> min, @NotNull Quantity<T> max) {
		super(min, max);
	}

	@SuppressWarnings("EmptyMethod")
	@Override
	public @NotNull Quantity<T> getMin() {
		return super.getMin();
	}

	@SuppressWarnings("EmptyMethod")
	@Override
	public @NotNull Quantity<T> getMax() {
		return super.getMax();
	}
}
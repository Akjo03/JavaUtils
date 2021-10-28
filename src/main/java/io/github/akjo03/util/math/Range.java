package io.github.akjo03.util.math;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Range<T extends Number & Comparable<T>> {
	protected final T low;
	protected final T high;

	public Range(@NotNull("Cannot create Range with null value!") T low,
	             @NotNull("Cannot create Range with null value!") T high) throws IllegalArgumentException {
		this.low = getActualLow(low, high);
		this.high = getActualHigh(low, high);
	}

	public boolean contains(@NotNull("Cannot check if range contains null!") T number) {
		boolean lowerCheck = number.compareTo(low) < 0;
		boolean higherCheck = number.compareTo(high) > 0;

		return !lowerCheck && !higherCheck;
	}

	private T getActualLow(T low, T high) {
		return low.compareTo(high) > 0 ? high : low;
	}

	private T getActualHigh(T low, T high) {
		return low.compareTo(high) < 0 ? high : low;
	}

	@Override
	public String toString() {
		return "Range{" + "low=" + low + ", high=" + high + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Range<?> other = (Range<?>) o;
		return low == other.low && high == other.high;
	}

	@Override
	public int hashCode() {
		return Objects.hash(low, high);
	}
}
package io.github.akjo03.util.math;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Defines a range between two {@link Number Numbers}. Both numbers need to be {@link Comparable}.
 * @param <T> The type of the numbers.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-18
 * @version 1.0.0
 */
@Getter
public class Range<T extends Number & Comparable<T>> {
	/**
	 * The minimum value of this range
	 */
	@NotNull protected final T min;
	/**
	 * The maximum value of this range
	 */
	@NotNull protected final T max;

	/**
	 * Creates a new Range with the specified minimum and maximum number.
	 * @param min The minimum number of the range.
	 * @param max The maximum number of the range.
	 * @implNote Both numbers need to be {@link Comparable}.
	 * @implSpec The actual minimum and maximum number will be calculated.
	 */
	public Range(@NotNull T min, @NotNull T max) {
		this.min = calculateMin(min, max);
		this.max = calculateMax(min, max);
	}

	/**
	 * Checks if the specified number is inside this range.
	 * @param number The number to check.
	 * @return {@code true} if the number is inside this range, {@code false} otherwise.
	 */
	public boolean contains(@NotNull T number) {
		boolean lowerCheck = number.compareTo(min) <= -1;
		boolean higherCheck = number.compareTo(max) >= 1;

		return !lowerCheck && !higherCheck;
	}

	/**
	 * Calculates the minimum number of the range.
	 * @param min The minimum number of the range.
	 * @param max The maximum number of the range.
	 * @return The actual minimum number of the range.
	 */
	private @NotNull T calculateMin(@NotNull T min, @NotNull T max) {
		return min.compareTo(max) <= -1 ? min : max;
	}

	/**
     * Calculates the maximum number of the range.
     * @param min The minimum number of the range.
     * @param max The maximum number of the range.
     * @return The actual maximum number of the range.
     */
	private @NotNull T calculateMax(@NotNull T min, @NotNull T max) {
		return max.compareTo(min) >= 1 ? max : min;
	}

	/**
	 * @return A string representation of this range.
	 */
	@Override
	public String toString() {
		return "Range{" + "min=" + min + ", max=" + max + '}';
	}

	/**
	 * Compares the given object with this range to see if they're equal.
	 * @param o The object to compare this Range to.
	 * @return {@code true} if the given object is a Range and both ranges are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Range<?> range = (Range<?>) o;
		return Objects.equals(min, range.min) && Objects.equals(max, range.max);
	}

	/**
	 * @return The hash code of this range.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(min, max);
	}
}
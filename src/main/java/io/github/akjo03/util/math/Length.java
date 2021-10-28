package io.github.akjo03.util.math;

import io.github.akjo03.util.math.units.IUnitContainer;
import io.github.akjo03.util.math.units.LengthUnit;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * A length with a LengthUnit. Can be interpreted as a distance.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 0.1.0
 */
@SuppressWarnings("unused")
public class Length extends Number implements Comparable<Length>, IUnitContainer<LengthUnit> {
	protected BigDecimal value;
	protected LengthUnit unit;

	public Length(@NotNull("Value of a Length cannot be null!") BigDecimal value,
	              @NotNull("Unit of a Length cannot be null!") LengthUnit unit) {
		this.value = value;
		this.unit = unit;
	}

	public Length(int value,
	              @NotNull("Unit of a Length cannot be null!") LengthUnit unit) {
		this.value = BigDecimal.valueOf(value);
		this.unit = unit;
	}

	public Length(long value,
	              @NotNull("Unit of a Length cannot be null!") LengthUnit unit) {
		this.value = BigDecimal.valueOf(value);
		this.unit = unit;
	}

	public Length(float value,
	              @NotNull("Unit of a Length cannot be null!") LengthUnit unit) {
		this.value = BigDecimal.valueOf(value);
		this.unit = unit;
	}

	public Length(double value,
	              @NotNull("Unit of a Length cannot be null!") LengthUnit unit) {
		this.value = BigDecimal.valueOf(value);
		this.unit = unit;
	}

	@Override
	public int compareTo(@NotNull Length other) {
		// TODO compareTo
		return 0;
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public Length convert(@NotNull LengthUnit newUnit) {
		this.value = value.divide(newUnit.getDivisor().divide(unit.getDivisor(), 10, RoundingMode.HALF_UP), 10, RoundingMode.HALF_UP);
		this.unit = newUnit;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	@Override
	public String toString() {
		return "Length{" + "value=" + value + ", unit=" + unit + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Length length = (Length) o;
		return Objects.equals(value, length.value) && unit == length.unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, unit);
	}
}
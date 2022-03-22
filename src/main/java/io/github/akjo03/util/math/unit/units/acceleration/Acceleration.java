package io.github.akjo03.util.math.unit.units.acceleration;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.derived.DerivedQuantity;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Acceleration extends DerivedQuantity<AccelerationUnit> implements Comparable<Quantity<AccelerationUnit>> {
	public Acceleration(@NotNull BigDecimal value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(double value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(float value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(long value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(int value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}

	@Override
	public Acceleration convertTo(AccelerationUnit unit) {
		return (Acceleration) super.convertTo(unit);
	}

	@Override
	public int compareTo(@NotNull Quantity<AccelerationUnit> other) {
		return compareToScaled((Acceleration) other, 20);
	}

	public int compareToScaled(@NotNull Acceleration other, int scale) {
		return super.compareToScaled(other, scale);
	}

	public Acceleration add(@NotNull Acceleration quantity) {
		return (Acceleration) super.add(quantity);
	}

	public Acceleration add(@NotNull BigDecimal value) {
		return (Acceleration) super.add(value);
	}

	public Acceleration subtract(@NotNull Acceleration quantity) {
		return (Acceleration) super.subtract(quantity);
	}

	public Acceleration subtract(@NotNull BigDecimal value) {
		return (Acceleration) super.subtract(value);
	}

	public Acceleration multiply(@NotNull Acceleration quantity) {
		return (Acceleration) super.multiply(quantity);
	}

	public Acceleration multiply(@NotNull BigDecimal value) {
		return (Acceleration) super.multiply(value);
	}

	public Acceleration divide(@NotNull Acceleration quantity) {
		return (Acceleration) super.divide(quantity);
	}

	public Acceleration divide(@NotNull BigDecimal value) {
		return (Acceleration) super.divide(value);
	}

	public Acceleration negate() {
		return (Acceleration) super.negate();
	}

	public Acceleration abs() {
		return (Acceleration) super.abs();
	}

	public Acceleration pow(int n) {
		return (Acceleration) super.pow(n);
	}

	public Acceleration sqrt() {
		return (Acceleration) super.sqrt();
	}

	public Acceleration round(int scale) {
		return (Acceleration) super.round(scale);
	}

	public Acceleration round(int scale, RoundingMode roundingMode) {
		return (Acceleration) super.round(scale, roundingMode);
	}

	@Override
	public String toObjectString() {
		return "Acceleration{" + "value=" + getValue() + ", unit=" + getUnit() + '}';
	}
}
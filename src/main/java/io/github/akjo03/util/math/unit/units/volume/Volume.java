package io.github.akjo03.util.math.unit.units.volume;

import io.github.akjo03.util.math.unit.Quantity;
import io.github.akjo03.util.math.unit.derived.DerivedQuantity;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Volume extends DerivedQuantity<VolumeUnit> implements Comparable<Quantity<VolumeUnit>> {
	public Volume(BigDecimal value, @NotNull VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(double value, @NotNull VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(float value, @NotNull VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(long value, @NotNull VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(int value, @NotNull VolumeUnit unit) {
		super(value, unit);
	}

	@Override
	public Volume convertTo(VolumeUnit unit) {
		return (Volume) super.convertTo(unit);
	}

	@Override
	public int compareTo(@NotNull Quantity<VolumeUnit> other) {
		return compareToScaled((Volume) other, 20);
	}

	public int compareToScaled(@NotNull Volume other, int scale) {
		return super.compareToScaled(other, scale);
	}

	public Volume add(@NotNull Volume quantity) {
		return (Volume) super.add(quantity);
	}

	public Volume add(@NotNull BigDecimal value) {
		return (Volume) super.add(value);
	}

	public Volume subtract(@NotNull Volume quantity) {
		return (Volume) super.subtract(quantity);
	}

	public Volume subtract(@NotNull BigDecimal value) {
		return (Volume) super.subtract(value);
	}

	public Volume multiply(@NotNull Volume quantity) {
		return (Volume) super.multiply(quantity);
	}

	public Volume multiply(@NotNull BigDecimal value) {
		return (Volume) super.multiply(value);
	}

	public Volume divide(@NotNull Volume quantity) {
		return (Volume) super.divide(quantity);
	}

	public Volume divide(@NotNull BigDecimal value) {
		return (Volume) super.divide(value);
	}

	public Volume negate() {
		return (Volume) super.negate();
	}

	public Volume abs() {
		return (Volume) super.abs();
	}

	public Volume pow(int n) {
		return (Volume) super.pow(n);
	}

	public Volume sqrt() {
		return (Volume) super.sqrt();
	}

	public Volume round(int scale) {
		return (Volume) super.round(scale);
	}

	public Volume round(int scale, RoundingMode roundingMode) {
		return (Volume) super.round(scale, roundingMode);
	}

	@Override
	public String toObjectString() {
		return "Volume{" + "value=" + getValue() + ", unit=" + getUnit() + '}';
	}
}
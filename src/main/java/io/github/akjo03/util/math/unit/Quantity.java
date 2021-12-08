package io.github.akjo03.util.math.unit;

import io.github.akjo03.util.math.array.StringArr2;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;

/**
 * A quantity is a number with a unit.
 * @param <T> The type of unit for this quantity.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-21
 * @version 0.1.0
 */
@SuppressWarnings("unused")
public abstract class Quantity<T extends Unit<T>> extends Number implements Comparable<Quantity<T>> {
	/**
	 * The value of this quantity.
	 */
	@Getter
	@NotNull protected transient BigDecimal value;
	/**
	 * The unit of this quantity.
	 */
	@Getter
	@NotNull protected transient T unit;

	/**
	 * Creates a new quantity with the given value and unit.
	 * @param value The value of the quantity.
	 * @param unit The unit of the quantity.
	 */
	protected Quantity(@NotNull BigDecimal value, @NotNull T unit) {
		this.value = value;
		this.unit = unit;
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

	/**
	 * Converts this quantity to the given unit.
	 * @param unit The unit to convert to.
	 * @return This quantity back converted to the given unit.
	 */
	public Quantity<T> convertTo(T unit) {
		BigDecimal conversionFactor = this.unit.getConversionFactor(unit);
		this.value = this.value.multiply(conversionFactor);
		this.unit = unit;
		return this;
	}

	/**
	 * Compares this quantity to the given unit with the maximum scale of 20. Scale is the number of decimal places to use when comparing.
	 * <br/><br/>
	 * The comparison rounds half up to the given scale. This means that the comparison will be true if the difference between the two values is less than half to 20 decimal places.
	 * <br/><br/>
	 * For example, if the scale is 2, then the comparison will be true if the difference between the two values is less than 0.00000000000000000005.
	 * <br/><br/>
	 * This method is equivalent to calling {@link #compareToScaled(Quantity, int)} with a scale of 20. If you want to compare with less precision (which is recommended), use {@link #compareToScaled(Quantity, int)} instead.
	 * @param o The unit to compare to.
	 * @return The result of the comparison.
	 */
	@Override
	public int compareTo(@NotNull Quantity<T> o) {
		return compareToScaled(o, 20);
	}

	/**
	 * Compares this quantity to the given unit, using the given scale. Scale is the number of decimal places to use when comparing. The maximum scale is 20, because the conversion factor is limited to 20 decimal places.
	 * <br/><br/>
	 * The comparison rounds half up to the given scale. This means that the comparison will be true if the difference between the two values is less than half to the given scale
	 * <br/><br/>
	 * For example, if the scale is 2, then the comparison will be true if the difference between the two values is less than 0.05.
	 * @param o The unit to compare to.
	 * @param scale The scale to use when comparing.
	 * @return The result of the comparison as defined by {@link BigDecimal#compareTo(BigDecimal)}.
	 */
	public int compareToScaled(@NotNull Quantity<T> o, int scale) {
		BigDecimal thisScaled = this.value.setScale(scale, RoundingMode.HALF_UP);
		BigDecimal otherScaled = o.convertTo(this.unit).getValue().setScale(scale, RoundingMode.HALF_UP);
		return thisScaled.compareTo(otherScaled);
	}

	/**
	 * Adds the given quantity to this quantity.
	 * @param quantity The quantity to add.
	 * @return This quantity with the given quantity added.
	 */
	public Quantity<T> add(@NotNull Quantity<T> quantity) {
		this.value = this.value.add(quantity.convertTo(this.unit).getValue());
		return this;
	}

	/**
	 * Adds the given value to this quantity.
	 * @param value The value to add.
	 * @return This quantity with the given value added.
	 */
	public Quantity<T> add(@NotNull BigDecimal value) {
		this.value = this.value.add(value);
		return this;
	}

	/**
	 * Subtracts the given quantity from this quantity.
	 * @param quantity The quantity to subtract.
	 * @return This quantity with the given quantity subtracted.
	 */
	public Quantity<T> subtract(@NotNull Quantity<T> quantity) {
		this.value = this.value.subtract(quantity.convertTo(this.unit).getValue());
		return this;
	}

	/**
	 * Subtracts the given value from this quantity.
	 * @param value The value to subtract.
	 * @return This quantity with the given value subtracted.
	 */
	public Quantity<T> subtract(@NotNull BigDecimal value) {
		this.value = this.value.subtract(value);
		return this;
	}

	/**
	 * Multiplies this quantity by the given quantity.
	 * @param quantity The quantity to multiply by.
	 * @return This quantity with the given quantity multiplied by.
	 */
	public Quantity<T> multiply(@NotNull Quantity<T> quantity) {
		this.value = this.value.multiply(quantity.convertTo(this.unit).getValue());
		return this;
	}

	/**
	 * Multiplies this quantity by the given value.
	 * @param value The value to multiply by.
	 * @return This quantity with the given value multiplied by.
	 */
	public Quantity<T> multiply(@NotNull BigDecimal value) {
		this.value = this.value.multiply(value);
		return this;
	}

	/**
	 * Divides this quantity by the given quantity.
	 * @param quantity The quantity to divide by.
	 * @return This quantity with the given quantity divided by.
	 */
	public Quantity<T> divide(@NotNull Quantity<T> quantity) {
		this.value = this.value.divide(quantity.convertTo(this.unit).getValue(), 20, RoundingMode.HALF_UP);
		return this;
	}

	/**
	 * Divides this quantity by the given value.
	 * @param value The value to divide by.
	 * @return This quantity with the given value divided by.
	 */
	public Quantity<T> divide(@NotNull BigDecimal value) {
		this.value = this.value.divide(value, 20, RoundingMode.HALF_UP);
		return this;
	}

	/**
	 * Negates this quantity.
	 * @return This quantity with the value negated.
	 */
	public Quantity<T> negate() {
		this.value = this.value.negate();
		return this;
	}

	/**
	 * @return The absolute value of this quantity.
	 */
	public Quantity<T> abs() {
		this.value = this.value.abs();
		return this;
	}

	/**
	 * Raises this quantity to the given power.
	 * @param n The power to raise to.
	 * @return This quantity with the value raised to the given power.
	 */
	public Quantity<T> pow(int n) {
		this.value = this.value.pow(n);
		return this;
	}

	/**
	 * Takes the square root of this quantity.
	 * @return This quantity with the square root of the value.
	 */
	public Quantity<T> sqrt() {
		this.value = this.value.sqrt(new MathContext(50, RoundingMode.HALF_UP));
		return this;
	}

	/**
	 * Rounds this quantity to the given number of decimal places.
	 * @param scale The number of decimal places to round to.
	 * @return This quantity with the value rounded to the given number of decimal places.
	 */
	public Quantity<T> round(int scale) {
		this.value = this.value.setScale(scale, RoundingMode.HALF_UP);
		return this;
	}

	/**
	 * Rounds this quantity to the given number of decimal places.
	 * @param scale The number of decimal places to round to.
	 * @param roundingMode The rounding mode to use.
	 * @return This quantity with the value rounded to the given number of decimal places.
	 */
	public Quantity<T> round(int scale, RoundingMode roundingMode) {
		this.value = this.value.setScale(scale, roundingMode);
		return this;
	}

	/**
	 * @return A string representation of this unit.
	 */
	@Override
	public String toString() {
		return toStringLocalized(Locale.getDefault());
	}

	/**
	 * @param locale The locale to use when creating the string.
	 * @return A localized string representation of this unit.
	 */
	public String toStringLocalized(Locale locale) {
		StringArr2 name = this.unit.getLocalizedName(locale);

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(20);
		df.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
		if (this.value.compareTo(BigDecimal.ONE) > 0) {
			return df.format(this.value) + " " + name.getSecond();
		} else {
			return df.format(this.value) + " " + name.getFirst();
		}
	}

	/**
	 * @param locale The locale to use when creating the string.
	 * @return A localized string representation of this unit.
	 */
	public String toStringLocalizedWithAbbreviation(Locale locale) {
		String abbreviation = this.unit.getLocalizedAbbreviation(locale);

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(20);
		df.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
		return df.format(this.value) + " " + abbreviation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Quantity<?> quantity = (Quantity<?>) o;
		return value.equals(quantity.value) && unit.equals(quantity.unit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, unit);
	}
}
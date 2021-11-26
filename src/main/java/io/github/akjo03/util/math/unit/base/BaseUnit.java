package io.github.akjo03.util.math.unit.base;

import io.github.akjo03.util.math.unit.Unit;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Defines a base unit as in the SI system.
 * @param <T> The type of base unit.
 */
@SuppressWarnings("unused")
public interface BaseUnit<T extends BaseUnit<T>> extends Unit<T> {
	/**
	 * Gets the conversion factor from this unit to the given unit.
	 * @param unit The unit to convert to.
	 * @return The conversion factor.
	 */
	@Override
	default @NotNull BigDecimal getConversionFactor(@NotNull T unit) {
		return this.getDivisor().divide(unit.getDivisor(), 20, RoundingMode.HALF_UP).stripTrailingZeros();
	}

	/**
	 * @return The factor to convert from the base unit to this unit.
	 */
	BigDecimal getDivisor();

	/**
	 * @return The base unit of this type of unit.
	 */
	T getBaseUnit();
}
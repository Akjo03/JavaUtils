package io.github.akjo03.util.math.unit.base;

import io.github.akjo03.util.math.unit.Quantity;

import java.math.BigDecimal;

/**
 * A base quantity is a number with a base unit.
 * @param <T> The type of base unit for this base quantity.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-21
 * @version 0.1.0
 */
public abstract class BaseQuantity<T extends BaseUnit<T>> extends Quantity<T> implements Comparable<Quantity<T>> {
	/**
	 * Creates a new base quantity with the given value and unit.
	 * @param value The value of the base quantity.
	 * @param unit The base unit of the base quantity.
	 */
	protected BaseQuantity(BigDecimal value, T unit) {
		super(value, unit);
	}
}
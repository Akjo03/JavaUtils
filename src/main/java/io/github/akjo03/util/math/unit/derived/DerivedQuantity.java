package io.github.akjo03.util.math.unit.derived;

import io.github.akjo03.util.math.unit.Quantity;

import java.math.BigDecimal;

public abstract class DerivedQuantity<T extends DerivedUnit<T>> extends Quantity<T> implements Comparable<Quantity<T>> {
	protected DerivedQuantity(BigDecimal value, T unit) {
		super(value, unit);
	}
}
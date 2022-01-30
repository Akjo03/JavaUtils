package io.github.akjo03.util.math.unit.derived.dimension;

import lombok.Getter;

/**
 * Defines the operators to be used in a unit dimension.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-25
 * @version 1.0.0
 */
public enum UnitDimensionOperator {
	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), POWER("^");

	@Getter
	private final String symbol;

	UnitDimensionOperator(String symbol) {
		this.symbol = symbol;
	}
}
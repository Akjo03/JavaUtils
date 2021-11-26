package io.github.akjo03.util.math.unit.derived.dimension;

import io.github.akjo03.util.math.unit.Unit;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * TODO Add documentation for class UnitDimensionContainer
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-25
 * @version 0.1.0
 */
public class UnitDimensionContainer {
	@Getter
	private final Unit<?> unit;
	@Getter
	private final BigDecimal value;

	private UnitDimensionOperator operator;

	public UnitDimensionContainer(Unit<?> unit) {
		this.value = null;
		this.unit = unit;
	}

	public UnitDimensionContainer(BigDecimal value) {
		this.value = value;
		this.unit = null;
	}

	UnitDimensionOperator getOperator() {
		return operator;
	}
	void setOperator(UnitDimensionOperator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return toStringLocalized(Locale.getDefault());
	}

	public @NotNull String toStringLocalized(Locale locale) {
		String symbol = "";
		if (unit != null) {
			symbol = unit.getLocalizedAbbreviation(locale);
		} else if (value != null) {
			symbol = value.toString();
		}
		return symbol + (operator != null ? operator.getSymbol() : "");
	}
}
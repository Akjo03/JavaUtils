package io.github.akjo03.util.math.unit.units.acceleration;

import io.github.akjo03.util.math.unit.Quantity;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Acceleration extends Quantity<AccelerationUnit> {
	public Acceleration(@NotNull BigDecimal value, @NotNull AccelerationUnit unit) {
		super(value, unit);
	}
}
package io.github.akjo03.util.math.units;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface IUnitContainer<T extends Unit> {
	IUnitContainer<T> convert(@NotNull("Cannot convert unit of UnitContainer to null!") T newUnit);
}
package io.github.akjo03.util.math.unit.units.acceleration;

import io.github.akjo03.util.array.StringArr2;
import io.github.akjo03.util.lang.Language;
import io.github.akjo03.util.math.unit.UnitSystem;
import io.github.akjo03.util.math.unit.derived.DerivedUnit;
import io.github.akjo03.util.math.unit.derived.dimension.UnitDimension;
import io.github.akjo03.util.math.unit.units.length.LengthUnit;
import io.github.akjo03.util.math.unit.units.time.TimeUnit;
import lombok.Getter;
import org.apache.commons.lang3.LocaleUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Map;

@SuppressWarnings("unused")
public enum AccelerationUnit implements DerivedUnit<AccelerationUnit> {
	METERS_PER_SECOND_SQUARED(new UnitDimension(LengthUnit.METRE).divide(TimeUnit.SECOND).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kilometer pro Quadratsekunde", "Kilometer pro Quadratsekunde")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("kilometers per second squared", "kilometers per second squared")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("kilometres per second squared", "kilometres per second squared"))
			),
			new StringArr2("kilometres per second squared", "kilometres per second squared"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "km/s²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "km/s²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "km/s²")
			),
			"km/s²",
			UnitSystem.METRIC
	);

	@Getter
	private final Map<Locale, StringArr2> localizedNames;
	@Getter
	private final StringArr2 defaultName;
	@Getter
	private final Map<Locale, String> localizedAbbreviations;
	@Getter
	private final String defaultAbbreviation;
	@Getter
	private final UnitSystem unitSystem;
	@Getter
	private final UnitDimension dimension;

	/**
	 * Defines a new unit of speed.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	AccelerationUnit(UnitDimension dimension, Map<Locale, StringArr2> localizedNames, StringArr2 defaultName, String defaultAbbreviation, UnitSystem unitSystem) {
		this.dimension = dimension;
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = generateLocalizedAbbreviations();
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
	}

	/**
	 * Defines a new unit of speed.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	AccelerationUnit(UnitDimension dimension, Map<Locale, StringArr2> localizedNames, StringArr2 defaultName, Map<Locale, String> localizedAbbreviations, String defaultAbbreviation, UnitSystem unitSystem) {
		this.dimension = dimension;
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = localizedAbbreviations;
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
	}

	@Override
	public @NotNull String getID() {
		return this.name();
	}

	public static @Nullable AccelerationUnit getUnit(@NotNull String unitStr) {
		for (AccelerationUnit unit : values()) {
			if (unit.toString().equals(unitStr)) {
				return unit;
			}
		}
		return null;
	}

	@Override
	public @NotNull String toString() {
		return this.getClass().getSimpleName() + "." + this.name();
	}
}
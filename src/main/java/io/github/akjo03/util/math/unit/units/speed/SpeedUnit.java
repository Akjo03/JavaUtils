package io.github.akjo03.util.math.unit.units.speed;

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

/**
 * Defines common units of speed.
 * @see <a href="https://en.wikipedia.org/wiki/Speed">Speed - Wikipedia</a>
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-21
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public enum SpeedUnit implements DerivedUnit<SpeedUnit> {
	METRES_PER_SECOND(new UnitDimension(LengthUnit.METRE).divide(TimeUnit.SECOND),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Meter pro Sekunde", "Meter pro Sekunde")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("meter per second", "meters per second")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("metre per second", "metres per second"))
			),
			new StringArr2("metre per second", "metres per second"),
			"m/s",
			UnitSystem.METRIC
	),
	KILOMETRES_PER_HOUR(new UnitDimension(LengthUnit.KILOMETRE).divide(TimeUnit.HOUR),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kilometer pro Stunde", "Kilometer pro Stunde")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("kilometer per hour", "kilometers per hour")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("kilometre per hour", "kilometres per hour"))
			),
			new StringArr2("kilometre per hour", "kilometres per hour"),
			"km/h",
			UnitSystem.METRIC
	),
	MILES_PER_HOUR(new UnitDimension(LengthUnit.MILE).divide(TimeUnit.HOUR),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Meilen pro Stunde", "Meilen pro Stunde")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("miles per hour", "miles per hour")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("mile per hour", "miles per hour"))
			),
			new StringArr2("mile per hour", "miles per hour"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mph"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mph"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "mph")
			),
			"mph",
			UnitSystem.IMPERIAL
	),
	KNOT(new UnitDimension(LengthUnit.NAUTICAL_MILE).divide(TimeUnit.HOUR),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Knoten", "Knoten")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("knot", "knots")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("knot", "knots"))
			),
			new StringArr2("knot", "knots"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "kn"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "kn"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "kn")
			),
			"kn",
			UnitSystem.IMPERIAL
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
	SpeedUnit(UnitDimension dimension, Map<Locale, StringArr2> localizedNames, StringArr2 defaultName, String defaultAbbreviation, UnitSystem unitSystem) {
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
	SpeedUnit(UnitDimension dimension, Map<Locale, StringArr2> localizedNames, StringArr2 defaultName, Map<Locale, String> localizedAbbreviations, String defaultAbbreviation, UnitSystem unitSystem) {
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

	public static @Nullable SpeedUnit getUnit(@NotNull String unitStr) {
		for (SpeedUnit unit : values()) {
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
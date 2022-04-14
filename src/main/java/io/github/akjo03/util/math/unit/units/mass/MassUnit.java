package io.github.akjo03.util.math.unit.units.mass;

import io.github.akjo03.util.array.StringArr2;
import io.github.akjo03.util.lang.Language;
import io.github.akjo03.util.math.unit.UnitSystem;
import io.github.akjo03.util.math.unit.base.BaseUnit;
import lombok.Getter;
import org.apache.commons.lang3.LocaleUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("unused")
public enum MassUnit implements BaseUnit<MassUnit> {
	KILOGRAM(new BigDecimal("1.000000000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kilogramm", "Kilogramm")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("kilogram", "kilograms")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("kilogram", "kilograms"))
			),
			new StringArr2("kilogram", "kilograms"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "kg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "kg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "kg")
			),
			"kg",
			UnitSystem.METRIC
	),
	GRAM(new BigDecimal("0.001000000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Gramm", "Gramm")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("gram", "grams")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("gram", "grams"))
			),
			new StringArr2("gram", "grams"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "g"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "g"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "g")
			),
			"g",
			UnitSystem.METRIC
	),
	MILLIGRAM(new BigDecimal("0.000001000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Milligramm", "Milligramm")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("milligram", "milligrams")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("milligram", "milligrams"))
			),
			new StringArr2("milligram", "milligrams"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "mg")
			),
			"mg",
			UnitSystem.METRIC
	),
	MICROGRAM(new BigDecimal("0.000000001000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Microgramm", "Microgramm")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("microgram", "micrograms")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("microgram", "micrograms"))
			),
			new StringArr2("microgram", "micrograms"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "µg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "µg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "µg")
			),
			"µg",
			UnitSystem.METRIC
	),
	POUND(new BigDecimal("0.453592370000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Pfund", "Pfund")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("pound", "pounds")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("pound", "pounds"))
			),
			new StringArr2("pound", "pounds"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "lb"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "lb"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "lb")
			),
			"lb",
			UnitSystem.IMPERIAL
	),
	OUNCE(new BigDecimal("0.028349523125"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Unze", "Unzen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("ounce", "ounces")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("ounce", "ounces"))
			),
			new StringArr2("ounce", "ounces"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "oz"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "oz"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "oz")
			),
			"oz",
			UnitSystem.IMPERIAL
	),
	CARAT(new BigDecimal("0.000200000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Karat", "Karat")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("carat", "carat")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("carat", "carat"))
			),
			new StringArr2("ounce", "ounces"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "kt"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "ct"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "ct")
			),
			"ct",
			UnitSystem.UNDEFINED
	),
	METRIC_TON(new BigDecimal("1000.000000000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Metrische Tonne", "Metrische Tonnen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("metric ton", "metric tons")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("metric ton", "metric tons"))
			),
			new StringArr2("metric ton", "metric tons"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "t"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "t"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "t")
			),
			"ct",
			UnitSystem.METRIC
	),
	LONG_TON(new BigDecimal("1016.046908800000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Britische Tonne", "Britische Tonnen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("long ton", "long tons")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("long ton", "long tons"))
			),
			new StringArr2("long ton", "long tons"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "tn. l."),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "tn. l."),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "tn. l.")
			),
			"tn. l.",
			UnitSystem.IMPERIAL
	),
	SHORT_TON(new BigDecimal("907.184740000000"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Amerikanische Tonne", "Amerikanische Tonnen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("short ton", "short tons")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("short ton", "short tons"))
			),
			new StringArr2("short ton", "short tons"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "tn. sh."),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "tn. sh."),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "tn. sh.")
			),
			"tn. sh.",
			UnitSystem.IMPERIAL
	);

	@Getter
	@NotNull private final BigDecimal divisor;

	@Getter
	@NotNull private final Map<Locale, StringArr2> localizedNames;

	@Getter
	@NotNull private final StringArr2 defaultName;

	@Getter
	@NotNull private final Map<Locale, String> localizedAbbreviations;

	@Getter
	@NotNull private final String defaultAbbreviation;

	@Getter
	@NotNull private final UnitSystem unitSystem;

	/**
	 * Defines a new unit of length.
	 *
	 * @param divisor The factor to convert from the base unit to this unit.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param localizedAbbreviations A list of translations for the abbreviation of this unit. The locale is the key and the value is the abbreviation.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	MassUnit(@NotNull BigDecimal divisor, @NotNull Map<Locale, StringArr2> localizedNames, @NotNull StringArr2 defaultName, @NotNull Map<Locale, String> localizedAbbreviations, @NotNull String defaultAbbreviation, @NotNull UnitSystem unitSystem) {
		this.divisor = divisor;
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = localizedAbbreviations;
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
	}

	@Override
	public MassUnit getBaseUnit() {
		return KILOGRAM;
	}

	@Override
	public @NotNull String getID() {
		return this.name();
	}

	public static @Nullable MassUnit getUnit(@NotNull String unitStr) {
		for (MassUnit unit : values()) {
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
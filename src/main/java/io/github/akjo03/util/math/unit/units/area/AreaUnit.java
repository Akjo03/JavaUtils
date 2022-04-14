package io.github.akjo03.util.math.unit.units.area;

import io.github.akjo03.util.array.StringArr2;
import io.github.akjo03.util.lang.Language;
import io.github.akjo03.util.math.unit.UnitSystem;
import io.github.akjo03.util.math.unit.derived.DerivedUnit;
import io.github.akjo03.util.math.unit.derived.dimension.UnitDimension;
import io.github.akjo03.util.math.unit.units.length.LengthUnit;
import lombok.Getter;
import org.apache.commons.lang3.LocaleUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("unused")
public enum AreaUnit implements DerivedUnit<AreaUnit> {
	SQUARE_METRE(new UnitDimension(LengthUnit.METRE).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratmeter", "Quadratmeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square meter", "square meters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square metre", "square metres"))
			),
			new StringArr2("square metre", "square metres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "m²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "m²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "m²")
			),
			"m²",
			UnitSystem.METRIC
	),
	SQUARE_CENTIMETRE(new UnitDimension(LengthUnit.CENTIMETRE).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratzentimeter", "Quadratzentimeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square centimetre", "square centimetres")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square centimetre", "square centimetres"))
			),
			new StringArr2("square centimetre", "square centimetres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "cm²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "cm²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "cm²")
			),
			"cm²",
			UnitSystem.METRIC
	),
	SQUARE_MILLIMETRE(new UnitDimension(LengthUnit.MILLIMETRE).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratmillimeter", "Quadratmillimeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square millimetre", "square millimetres")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square millimetre", "square millimetres"))
			),
			new StringArr2("square millimetre", "square millimetres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mm²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mm²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "mm²")
			),
			"mm²",
			UnitSystem.METRIC
	),
	SQUARE_KILOMETRE(new UnitDimension(LengthUnit.KILOMETRE).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratkilometer", "Quadratkilometer")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square kilometre", "square kilometres")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square kilometre", "square kilometres"))
			),
			new StringArr2("square kilometre", "square kilometres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "km²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "km²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "km²")
			),
			"km²",
			UnitSystem.METRIC
	),
	SQUARE_INCH(new UnitDimension(LengthUnit.INCH).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratzoll", "Quadratzoll")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square inch", "square inches")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square inch", "square inches"))
			),
			new StringArr2("square inch", "square inches"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "in²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "in²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "in²")
			),
			"in²",
			UnitSystem.IMPERIAL
	),
	SQUARE_FOOT(new UnitDimension(LengthUnit.FOOT).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratfuß", "Quadratfuß")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square foot", "square feet")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square foot", "square feet"))
			),
			new StringArr2("square foot", "square feet"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "ft²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "ft²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "ft²")
			),
			"ft²",
			UnitSystem.IMPERIAL
	),
	SQUARE_YARD(new UnitDimension(LengthUnit.YARD).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratyard", "Quadratyard")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square yard", "square yards")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square yard", "square yards"))
			),
			new StringArr2("square foot", "square foot"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "yd²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "yd²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "yd²")
			),
			"yd²",
			UnitSystem.IMPERIAL
	),
	SQUARE_MILE(new UnitDimension(LengthUnit.MILE).power(2),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Quadratmeile", "Quadratmeile")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("square mile", "square miles")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("square mile", "square miles"))
			),
			new StringArr2("square mile", "square mile"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mi²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mi²"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "mi²")
			),
			"mi²",
			UnitSystem.IMPERIAL
	),
	HECTARE(new UnitDimension(AreaUnit.SQUARE_METRE).multiply(new BigDecimal("10000")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Hektar", "Hektare")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("hectare", "hectares")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("hectare", "hectares"))
			),
			new StringArr2("square foot", "square foot"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "ha"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "ha"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "ha")
			),
			"ha",
			UnitSystem.UNDEFINED
	),
	ACRE(new UnitDimension(AreaUnit.SQUARE_FOOT).multiply(new BigDecimal("43560")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Morgen", "Morgen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("acre", "acres")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("acre", "acres"))
			),
			new StringArr2("acre", "acres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "Mg"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "ac"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "ac")
			),
			"ac",
			UnitSystem.IMPERIAL
	);

	@Getter
	@NotNull private final Map<Locale, StringArr2> localizedNames;

	@Getter
	@NotNull private final StringArr2 defaultName;

	@Getter
	@NotNull private final java.util.Map<Locale, String> localizedAbbreviations;

	@Getter
	@NotNull private final String defaultAbbreviation;

	@Getter
	@NotNull private final UnitSystem unitSystem;

	@Getter
	@NotNull private final UnitDimension dimension;

	/**
	 * Defines a new unit of area.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	AreaUnit(@NotNull UnitDimension dimension, @NotNull Map<Locale, StringArr2> localizedNames, @NotNull StringArr2 defaultName, @NotNull String defaultAbbreviation, @NotNull UnitSystem unitSystem) {
		this.dimension = dimension;
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = generateLocalizedAbbreviations();
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
	}

	/**
	 * Defines a new unit of area.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	AreaUnit(@NotNull UnitDimension dimension, @NotNull Map<Locale, StringArr2> localizedNames, @NotNull StringArr2 defaultName, @NotNull Map<Locale, String> localizedAbbreviations, @NotNull String defaultAbbreviation, @NotNull UnitSystem unitSystem) {
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

	public static @Nullable AreaUnit getUnit(@NotNull String unitStr) {
		for (AreaUnit unit : values()) {
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
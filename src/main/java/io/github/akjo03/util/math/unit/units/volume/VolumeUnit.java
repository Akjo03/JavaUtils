package io.github.akjo03.util.math.unit.units.volume;

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
public enum VolumeUnit implements DerivedUnit<VolumeUnit> {
	CUBIC_KILOMETRE(new UnitDimension(LengthUnit.KILOMETRE).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikkilometer", "Kubikkilometer")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic kilometer", "cubic kilometers")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("cubic kilometre", "cubic kilometres"))
			),
			new StringArr2("cubic kilometre", "cubic kilometres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "km³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "km³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "km³")
			),
			"m³",
			UnitSystem.METRIC
	),
	CUBIC_METRE(new UnitDimension(LengthUnit.METRE).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikmeter", "Kubikmeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic meter", "cubic meters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("cubic metre", "cubic metres"))
			),
			new StringArr2("cubic metre", "cubic metres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "m³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "m³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "m³")
			),
			"m³",
			UnitSystem.METRIC
	),
	CUBIC_DECIMETRE(new UnitDimension(LengthUnit.DECIMETRE).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikdezimeter", "Kubikdezimeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic decimeter", "cubic decimeters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("cubic decimetre", "cubic decimetres"))
			),
			new StringArr2("cubic decimetre", "cubic decimetres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "dm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "dm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "dm³")
			),
			"dm³",
			UnitSystem.METRIC
	),
	CUBIC_CENTIMETRE(new UnitDimension(LengthUnit.CENTIMETRE).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikzentimeter", "Kubikzentimeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic centimeter", "cubic centimeters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("cubic centimetre", "cubic centimetres"))
			),
			new StringArr2("cubic centimetre", "cubic centimetres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "cm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "cm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "cm³")
			),
			"cm³",
			UnitSystem.METRIC
	),
	CUBIC_MILLIMETRE(new UnitDimension(LengthUnit.MILLIMETRE).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikmillimeter", "Kubikmillimeter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic millimeter", "cubic millimeters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , new StringArr2("cubic millimetre", "cubic millimetres"))
			),
			new StringArr2("cubic millimetre", "cubic millimetres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mm³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()) , "mm³")
			),
			"mm³",
			UnitSystem.METRIC
	),
	CUBIC_INCH(new UnitDimension(LengthUnit.INCH).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikzoll", "Kubikzoll")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic inch", "cubic inches")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("cubic inch", "cubic inches"))
			),
			new StringArr2("cubic inch", "cubic inches"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "in³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "in³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "in³")
			),
			"in³",
			UnitSystem.IMPERIAL
	),
	CUBIC_FOOT(new UnitDimension(LengthUnit.FOOT).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikfuß", "Kubikfuß")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic foot", "cubic feet")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("cubic foot", "cubic feet"))
			),
			new StringArr2("cubic foot", "cubic feet"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "ft³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "ft³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "ft³")
			),
			"ft³",
			UnitSystem.IMPERIAL
	),
	CUBIC_YARD(new UnitDimension(LengthUnit.YARD).power(3),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Kubikyard", "Kubikyard")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("cubic yard", "cubic yards")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("cubic yard", "cubic yards"))
			),
			new StringArr2("cubic yard", "cubic yards"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "yd³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "yd³"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "yd³")
			),
			"yd³",
			UnitSystem.IMPERIAL
	),
	LITRE(new UnitDimension(LengthUnit.METRE).multiply(new BigDecimal("0.001")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Liter", "Liter")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("liter", "liters")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("litre", "litres"))
			),
			new StringArr2("litre", "litres"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "l"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "l"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "l")
			),
			"l",
			UnitSystem.UNDEFINED
	),
	IMPERIAL_GALLON(new UnitDimension(VolumeUnit.LITRE).multiply(new BigDecimal("4.54609")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Imperiale Gallone", "Imperiale Gallonen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("imperial gallon", "imperial gallons")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("imperial gallon", "imperial gallons"))
			),
			new StringArr2("imperial gallon", "imperial gallons"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "imp gal"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "imp gal"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "imp gal")
			),
			"imp gal",
			UnitSystem.IMPERIAL
	),
	US_GALLON(new UnitDimension(VolumeUnit.CUBIC_INCH).multiply(new BigDecimal("231")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("US-Gallone", "US-Gallonen")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("US gallon", "US gallons")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("US gallon", "US gallons"))
			),
			new StringArr2("US gallon", "US gallons"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "US gal"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "US gal"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "US gal")
			),
			"US gal",
			UnitSystem.UNDEFINED
	),
	BARREL(new UnitDimension(VolumeUnit.US_GALLON).multiply(new BigDecimal("42")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Barrel", "Barrel")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("barrel", "barrels")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("barrel", "barrels"))
			),
			new StringArr2("barrel", "barrels"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "bl"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "bl"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "bl")
			),
			"bl",
			UnitSystem.UNDEFINED
	),
	IMPERIAL_PINT(new UnitDimension(VolumeUnit.LITRE).multiply(new BigDecimal("0.5683")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Imperiale Pinte", "Imperiale Pinten")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("imperial pint", "imperial pints")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("imperial pint", "imperial pints"))
			),
			new StringArr2("imperial pint", "imperial pints"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "imp pt"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "imp pt"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "imp pt")
			),
			"imp pt",
			UnitSystem.IMPERIAL
	),
	US_PINT(new UnitDimension(VolumeUnit.LITRE).multiply(new BigDecimal("0.4732")),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("US-Pinte", "US-Pinten")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("US pint", "US pints")),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("US pint", "US pints"))
			),
			new StringArr2("US pint", "US pints"),
			Map.ofEntries(
					Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "US pt"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "US pt"),
					Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "US pt")
			),
			"US pt",
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

	VolumeUnit(@NotNull final UnitDimension dimension, @NotNull final Map<Locale, StringArr2> localizedNames, @NotNull final StringArr2 defaultName,  @NotNull final String defaultAbbreviation, @NotNull final UnitSystem unitSystem) {
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = generateLocalizedAbbreviations();
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
		this.dimension = dimension;
	}

	VolumeUnit(@NotNull final UnitDimension dimension, @NotNull final Map<Locale, StringArr2> localizedNames, @NotNull final StringArr2 defaultName, @NotNull final Map<Locale, String> localizedAbbreviations, @NotNull final String defaultAbbreviation, @NotNull final UnitSystem unitSystem) {
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = localizedAbbreviations;
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
		this.dimension = dimension;
	}

	@Override
	public @NotNull String getID() {
		return this.name();
	}

	public static @Nullable VolumeUnit getUnit(@NotNull String unitStr) {
		for (VolumeUnit unit : values()) {
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
package io.github.akjo03.util.math.unit.units.time;

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

/**
 * Defines common units of time.
 * @see <a href="https://en.wikipedia.org/wiki/Unit_of_time">Unit of time - Wikiedia</a>
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-21
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public enum TimeUnit implements BaseUnit<TimeUnit> {
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Second">Second - Wikipedia</a>
	 */
	SECOND(new BigDecimal("1"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Sekunde", "Sekunden")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("second", "seconds")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("second", "seconds"))
	), new StringArr2("second", "seconds"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "s"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "s"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "s")
	), "s", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Minute">Minute - Wikipedia</a>
	 */
	MINUTE(new BigDecimal("60"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Minute", "Minuten")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("minute", "minutes")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("minute", "minutes"))
	), new StringArr2("minute", "minutes"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "min"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "min"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "min")
	), "min", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Hour">Hour - Wikipedia</a>
	 */
	HOUR(new BigDecimal("3600"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Stunde", "Stunden")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("hour", "hours")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("hour", "hours"))
	), new StringArr2("hour", "hours"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "h"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "h"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "h")
	), "h", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Day">Day - Wikipedia</a>
	 */
	DAY(new BigDecimal("86400"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Tag", "Tage")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("day", "days")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("day", "days"))
	), new StringArr2("day", "days"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "d"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "d"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "d")
	), "d", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Week">Week - Wikipedia</a>
	 */
	WEEK(new BigDecimal("604800"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Woche", "Wochen")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("week", "weeks")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("week", "weeks"))
	), new StringArr2("week", "weeks"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "Wo."),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "wk"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "wk")
	), "wk", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Month">Month - Wikipedia</a>
	 */
	MONTH(new BigDecimal("2592000"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Monat", "Monate")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("month", "months")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("month", "months"))
	), new StringArr2("month", "months"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "mo"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "mo"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "mo")
	), "mo", UnitSystem.METRIC),
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Year">Year - Wikipedia</a>
	 */
	YEAR(new BigDecimal("31536000"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), new StringArr2("Jahr", "Jahre")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), new StringArr2("year", "years")),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), new StringArr2("year", "years"))
	), new StringArr2("year", "years"), Map.ofEntries(
			Map.entry(LocaleUtils.toLocale(Language.GERMAN_DE.get()), "a"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_US.get()), "yr"),
			Map.entry(LocaleUtils.toLocale(Language.ENGLISH_UK.get()), "yr")
	), "yr", UnitSystem.METRIC);

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
	 * Defines a new unit of time.
	 * @param divisor The factor to convert from the base unit to this unit.
	 * @param localizedNames A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 * @param defaultName Default name of this unit.
	 * @param localizedAbbreviations A list of translations for the abbreviation of this unit. The locale is the key and the value is the abbreviation.
	 * @param defaultAbbreviation Default abbreviation for this unit.
	 * @param unitSystem The unit system this unit belongs to.
	 */
	TimeUnit(@NotNull BigDecimal divisor, @NotNull Map<Locale, StringArr2> localizedNames, @NotNull StringArr2 defaultName, @NotNull Map<Locale, String> localizedAbbreviations, @NotNull String defaultAbbreviation, @NotNull UnitSystem unitSystem) {
		this.divisor = divisor;
		this.localizedNames = localizedNames;
		this.defaultName = defaultName;
		this.localizedAbbreviations = localizedAbbreviations;
		this.defaultAbbreviation = defaultAbbreviation;
		this.unitSystem = unitSystem;
	}

	@Override
	public TimeUnit getBaseUnit() {
		return SECOND;
	}

	@Override
	public @NotNull String getID() {
		return this.name();
	}

	public static @Nullable TimeUnit getUnit(@NotNull String unitStr) {
		for (TimeUnit unit : values()) {
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
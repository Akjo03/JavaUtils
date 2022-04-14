package io.github.akjo03.util.math.unit;

import io.github.akjo03.util.array.StringArr2;
import io.github.akjo03.util.math.unit.base.BaseUnit;
import io.github.akjo03.util.math.unit.derived.DerivedUnit;
import org.apache.commons.lang3.LocaleUtils;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/**
 * Defines a unit of measurement. Two interfaces extend this interface: {@link BaseUnit} and {@link DerivedUnit}.
 * @param <T> The type of unit.
 */
@SuppressWarnings("unused")
public interface Unit<T extends Unit<T>> {
	@NotNull String getID();

	/**
	 * Gets the conversion factor from this unit to the given unit.
	 * @param unit The unit to convert to.
	 * @return The conversion factor.
	 */
	@NotNull BigDecimal getConversionFactor(@NotNull T unit);

	/**
	 * @return A list of translations for the name this unit. The locale is the key and the value is an array of two strings. The first string is the singular form of the unit and the second string is the plural form.
	 */
	@NotNull Map<Locale, StringArr2> getLocalizedNames();

	/**
	 * @return The default name of this unit.
	 */
	@NotNull StringArr2 getDefaultName();

	/**
	 * @return A list of translations for the abbreviation of this unit. The locale is the key and the value is the abbreviation.
	 */
	@NotNull Map<Locale, String> getLocalizedAbbreviations();

	/**
	 * @return The default abbreviation for this unit.
	 */
	@NotNull String getDefaultAbbreviation();

	/**
	 * @param locale The locale to get the name for.
	 * @return The name of this unit in the given locale.
	 */
	default @NotNull StringArr2 getLocalizedName(Locale locale) {
		StringArr2 name = getLocalizedNames().get(LocaleUtils.toLocale(locale));
		if (name == null) {
			name = Objects.requireNonNull(
					getLocalizedNames()
							.entrySet()
							.stream()
							.filter(nameP -> nameP.getKey().getLanguage().startsWith(locale.getLanguage()))
							.findFirst().orElse(null)
			).getValue();
		}
		if (name == null) {
			name = getDefaultName();
		}
		return name;
	}

	/**
	 * @param locale The locale to get the abbreviation for.
	 * @return The abbreviation of this unit in the given locale.
	 */
	default @NotNull String getLocalizedAbbreviation(Locale locale) {
		String abbreviation = getLocalizedAbbreviations().get(LocaleUtils.toLocale(locale));
		if (abbreviation == null) {
			abbreviation = Objects.requireNonNull(
					getLocalizedAbbreviations()
							.entrySet()
							.stream()
							.filter(abbreviationP -> abbreviationP.getKey().getLanguage().startsWith(locale.getLanguage()))
							.findFirst().orElse(null)
			).getValue();
		}
		if (abbreviation == null) {
			abbreviation = getDefaultAbbreviation();
		}
		return abbreviation;
	}

	/**
	 * @return The unit system this unit belongs to.
	 */
	@NotNull UnitSystem getUnitSystem();
}
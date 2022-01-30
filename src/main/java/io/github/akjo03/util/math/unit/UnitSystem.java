package io.github.akjo03.util.math.unit;

/**
 * Defines common unit systems.
 *
 * @see <a href="https://en.wikipedia.org/wiki/System_of_measurement">System of measurement - Wikipedia</a>
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-21
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public enum UnitSystem {
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Metric_system">Metric system - Wikipedia</a>
	 */
	METRIC,
	/**
	 * @see <a href="https://en.wikipedia.org/wiki/Imperial_system">Imperial system - Wikipedia</a>
	 */
	IMPERIAL,
	/**
	 * Use this if you don't know what unit system the unit belongs to or if it's undefined.
	 */
	UNDEFINED,
	/**
	 * Use this if the unit system isn't defined in this enum.
	 */
	OTHER
}
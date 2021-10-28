package io.github.akjo03.util;

import io.github.akjo03.logging.Logger;
import io.github.akjo03.logging.LoggerManager;
import io.github.akjo03.logging.LoggingLevel;
import io.github.akjo03.util.math.Range;

/**
 * Utility class for checking arguments
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 0.1.0
 */
@SuppressWarnings("unused")
public final class ArgumentChecks {
	private static final Logger LOGGER = LoggerManager.getLogger(ArgumentChecks.class);

	private ArgumentChecks() {
		UnsupportedOperationException uoe = new UnsupportedOperationException("Cannot instantiate utility class ArgumentChecks!");
		LOGGER.log("The class ArgumentChecks cannot be instantiated!", LoggingLevel.ERROR, uoe);
		throw uoe;
	}

	public static <T> T requireArgumentNotNull(T arg, String message) {
		if (arg == null) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be not null!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	public static <T extends Number & Comparable<T>> T requireArgumentInRange(T arg, T min, T max, String message) {
		if (!new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be in range (" + min + ", " + max + ")!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	public static <T extends Number & Comparable<T>> T requireArgumentNotInRange(T arg, T min, T max, String message) {
		if (new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to NOT be in range (" + min + ", " + max + ")!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	public static <T> T requireArgumentEquals(T arg, Object obj, String message) {
		if (!arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be equal to " + obj + "!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	public static <T> T requireArgumentNotEquals(T arg, Object obj, String message) {
		if (arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to not be equal to " + obj + "!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}
}
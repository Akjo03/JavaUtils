package io.github.akjo03.util;

import io.github.akjo03.util.logging.Logger;
import io.github.akjo03.util.logging.LoggerManager;
import io.github.akjo03.util.logging.LoggingLevel;
import io.github.akjo03.util.math.Range;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Utility class for checking arguments
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 1.0.0
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public final class ArgumentChecks {
	private static final Logger LOGGER = LoggerManager.getLogger(ArgumentChecks.class);

	/**
	 * <strong>This should never be used!</strong>
	 * @implNote This is a utility class and should not be instantiated!
	 */
	private ArgumentChecks() {
		UnsupportedOperationException uoe = new UnsupportedOperationException("Cannot instantiate utility class ArgumentChecks!");
		LOGGER.log("The class ArgumentChecks cannot be instantiated!", LoggingLevel.ERROR, uoe);
		throw uoe;
	}

	/**
	 * Requires the argument to be not null. If it is null, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not null
	 * @param message The message of the IllegalArgumentException if the argument is null
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	public static <T> T requireArgumentNotNull(@Nullable T arg, String message) {
		if (arg == null) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be not null!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be not null. If it is null, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not null
	 * @param message The message of the IllegalArgumentException if the argument is null
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	public static <T> T requireArgumentNotNull(@Nullable T arg, String message, boolean log) {
		if (arg == null) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be not null!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument (has to be a {@link Number} and be {@link Comparable}) to be inside the specified range. If the argument outside the range, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be inside the range
	 * @param min The minimum value of the range
	 * @param max The maximum value of the range
	 * @param message The message of the IllegalArgumentException if the argument is outside the range
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 * @see Range
	 */
	public static <T extends Number & Comparable<T>> T requireArgumentInRange(T arg, T min, T max, String message) {
		if (!new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be in range (" + min + ", " + max + ")!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument (has to be a {@link Number} and be {@link Comparable}) to be inside the specified range. If the argument outside the range, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be inside the range
	 * @param min The minimum value of the range
	 * @param max The maximum value of the range
	 * @param message The message of the IllegalArgumentException if the argument is outside the range
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 * @see Range
	 */
	public static <T extends Number & Comparable<T>> T requireArgumentInRange(T arg, T min, T max, String message, boolean log) {
		if (!new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be in range (" + min + ", " + max + ")!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be a {@link Number}, be {@link Comparable} and has to be inside the given range. If the argument is inside the range, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be outside the range
	 * @param min The minimum value of the range
	 * @param max The maximum value of the range
	 * @param message The message of the IllegalArgumentException if the argument is inside the range
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	public static <T extends Number & Comparable<T>> T requireArgumentNotInRange(T arg, T min, T max, String message) {
		if (new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to NOT be in range (" + min + ", " + max + ")!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be a {@link Number}, be {@link Comparable} and be inside the given range. If the argument is inside the range, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be outside the range
	 * @param min The minimum value of the range
	 * @param max The maximum value of the range
	 * @param message The message of the IllegalArgumentException if the argument is inside the range
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	public static <T extends Number & Comparable<T>> T requireArgumentNotInRange(T arg, T min, T max, String message, boolean log) {
		if (new Range<>(min, max).contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to NOT be in range (" + min + ", " + max + ")!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be equals to the specified object. If the argument is not equals to the specified object, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be equals to the specified object
	 * @param obj The object that the argument has to be equal to
	 * @param message The message of the IllegalArgumentException if the argument is not equals to the specified object
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _ -> param1")
	public static <T> @NotNull T requireArgumentEquals(@NotNull T arg, Object obj, String message) {
		if (!arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be equal to " + obj + "!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be equals to the specified object. If the argument is not equals to the specified object, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be equals to the specified object
	 * @param obj The object that the argument has to be equal to
	 * @param message The message of the IllegalArgumentException if the argument is not equals to the specified object
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _, _ -> param1")
	public static <T> @NotNull T requireArgumentEquals(@NotNull T arg, Object obj, String message, boolean log) {
		if (!arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be equal to " + obj + "!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be not equals to the specified object. If the argument is equals to the specified object, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not equals to the specified object
	 * @param obj The object that the argument has to be not equal to
	 * @param message The message of the IllegalArgumentException if the argument is equals to the specified object
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _ -> param1")
	public static <T> @NotNull T requireArgumentNotEquals(@NotNull T arg, Object obj, String message) {
		if (arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to not be equal to " + obj + "!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be not equals to the specified object. If the argument is equals to the specified object, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not equals to the specified object
	 * @param obj The object that the argument has to be not equal to
	 * @param message The message of the IllegalArgumentException if the argument is equals to the specified object
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _, _ -> param1")
	public static <T> @NotNull T requireArgumentNotEquals(@NotNull T arg, Object obj, String message, boolean log) {
		if (arg.equals(obj)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to not be equal to " + obj + "!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be inside of the given {@link Collection}. If the argument is not inside of the given {@link Collection}, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be inside of the given {@link Collection}
	 * @param list The {@link Collection} that the argument has to be inside of
	 * @param message The message of the IllegalArgumentException if the argument is not inside of the given {@link Collection}
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _ -> param1")
	public static <T> @NotNull T requireArgumentInCollection(@NotNull T arg, @NotNull Collection<?> list, String message) {
		if (!list.contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be in list!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be inside of the given {@link Collection}. If the argument is not inside of the given {@link Collection}, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be inside of the given {@link Collection}
	 * @param list The {@link Collection} that the argument has to be inside of
	 * @param message The message of the IllegalArgumentException if the argument is not inside of the given {@link Collection}
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _, _ -> param1")
	public static <T> @NotNull T requireArgumentInCollection(@NotNull T arg, @NotNull Collection<?> list, String message, boolean log) {
		if (!list.contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to be in list!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be not inside of the given {@link Collection}. If the argument is inside of the given {@link Collection}, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not inside of the given {@link Collection}
	 * @param list The {@link Collection} that the argument has to be not inside of
	 * @param message The message of the IllegalArgumentException if the argument is inside of the given {@link Collection}
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _ -> param1")
	public static <T> @NotNull T requireArgumentNotInCollection(@NotNull T arg, @NotNull Collection<?> list, String message) {
		if (list.contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to NOT be in list!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
		return arg;
	}

	/**
	 * Requires the argument to be not inside of the given {@link Collection}. If the argument is inside of the given {@link Collection}, an {@link IllegalArgumentException} with the specified message is thrown. The type is inferred from the argument.
	 * @param arg The argument that has to be not inside of the given {@link Collection}
	 * @param list The {@link Collection} that the argument has to be not inside of
	 * @param message The message of the IllegalArgumentException if the argument is inside of the given {@link Collection}
	 * @param <T> The inferred type of the argument
	 * @return The argument back
	 */
	@Contract("_, _, _, _ -> param1")
	public static <T> @NotNull T requireArgumentNotInCollection(@NotNull T arg, @NotNull Collection<?> list, String message, boolean log) {
		if (list.contains(arg)) {
			IllegalArgumentException iae = new IllegalArgumentException("Argument required to NOT be in list!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
		return arg;
	}

	public static void requireTrue(boolean condition, String message) {
		if (!condition) {
			IllegalArgumentException iae = new IllegalArgumentException("Condition required to be true!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
	}

	public static void requireTrue(boolean condition, String message, boolean log) {
		if (!condition) {
			IllegalArgumentException iae = new IllegalArgumentException("Condition required to be true!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
	}

	public static void requireFalse(boolean condition, String message) {
		if (condition) {
			IllegalArgumentException iae = new IllegalArgumentException("Condition required to be false!");
			LOGGER.log(message, LoggingLevel.ERROR, iae);
			throw iae;
		}
	}

	public static void requireFalse(boolean condition, String message, boolean log) {
		if (condition) {
			IllegalArgumentException iae = new IllegalArgumentException("Condition required to be false!");
			if (log) {
				LOGGER.log(message, LoggingLevel.ERROR, iae);
			}
			throw iae;
		}
	}
}
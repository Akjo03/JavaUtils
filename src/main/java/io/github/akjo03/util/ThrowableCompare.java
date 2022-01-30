package io.github.akjo03.util;

import org.jetbrains.annotations.NotNull;

/**
 * Utility class for comparing Throwables.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-18
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public final class ThrowableCompare {
	/**
	 * <strong>This should never be used!</strong>
	 *
	 * @implNote This is a utility class and should not be instantiated!
	 */
	private ThrowableCompare() {
		throw new UnsupportedOperationException("ThrowableCompare is a utility class!");
	}

	/**
     * Compares two Throwables. If the Throwables have the same message, the cause of each Throwable is the same (recursively), and the stack traces are the same (if stackTrace boolean is true), then they are equal.
     *
     * @param t1 The first Throwable to compare.
     * @param t2 The second Throwable to compare.
	 * @param stackTrace Whether to compare the stack traces.
     * @return Whether the Throwables are equal.
     */
	public static boolean compareThrowable(Throwable t1, Throwable t2, boolean stackTrace) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}
		boolean stackTraceCompare = true;
		if (stackTrace) {
			stackTraceCompare = compareStackTrace(t1.getStackTrace(), t2.getStackTrace());
		}
		return t1.getClass() == t2.getClass() && t1.getMessage().equals(t2.getMessage()) && compareThrowable(t1.getCause(), t2.getCause(), stackTrace) && stackTraceCompare;
	}

	/**
	 * Compares two stack traces.
	 *
	 * @param ste1 The first stack trace to compare.
	 * @param ste2 The second stack trace to compare.
	 * @return Whether the stack traces are equal.
	 */
	private static boolean compareStackTrace(StackTraceElement @NotNull [] ste1, StackTraceElement @NotNull [] ste2) {
		if (ste1.length != ste2.length) { return false; }
		boolean equal = false;
		for (int i = 0; i < ste1.length; i++) {
			StackTraceElement element1 = ste1[i];
			StackTraceElement element2 = ste2[i];

			equal = element1.getClassName().equals(element2.getClassName());
		}
		return equal;
	}
}
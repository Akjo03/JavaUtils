package io.github.akjo03.util.throwables;

@SuppressWarnings("unused")
public final class ThrowableCompare {
	/**
	 * <strong>This should never be executed!</strong>
	 */
	private ThrowableCompare() {
		throw new UnsupportedOperationException("ThrowableCompare is a utility class!");
	}

	public static boolean compareThrowable(Throwable t1, Throwable t2) {
		if (t1 == null) { return false; }
		return t1.equals(t2) || (t1.getClass() == t2.getClass() && t1.getMessage().equals(t2.getMessage()) && compareStackTrace(t1.getStackTrace(), t2.getStackTrace()) && compareThrowable(t1.getCause(), t2.getCause()));
	}

	public static boolean compareStackTrace(StackTraceElement[] ste1, StackTraceElement[] ste2) {
		return true;
	}
}
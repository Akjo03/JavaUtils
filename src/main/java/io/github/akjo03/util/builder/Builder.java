package io.github.akjo03.util.builder;

/**
 * Builds a {@link Buildable Buildable}
 *
 * @param <T> The type of {@link Buildable Buildable} that this Builder builds.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public interface Builder<T extends Buildable> {
	/**
	 * Builds an instance of the {@link Buildable Buildable}
	 * @return The built {@link Buildable Buildable}
	 */
	T build();
}
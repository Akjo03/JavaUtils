package io.github.akjo03.util.builder;

/**
 * Builds a {@link Buildable}
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 0.1.0
 *
 * @param <T>
 */
@SuppressWarnings("unused")
public interface Builder<T extends Buildable> {
	T build();
}
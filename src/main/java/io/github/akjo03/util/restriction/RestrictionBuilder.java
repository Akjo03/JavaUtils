package io.github.akjo03.util.restriction;

import io.github.akjo03.util.builder.Builder;

/**
 * Defines a builder for {@link Restriction Restrictions}.
 *
 * @implNote A RestrictionBuilder is a {@link Builder} for a {@link Restriction}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-12-09
 * @version 1.0.0
 *
 * @param <T> The type of restriction to build.
 */
public interface RestrictionBuilder<T extends Restriction<T>> extends Builder<T> {}
package io.github.akjo03.util.restriction;

import io.github.akjo03.util.builder.Buildable;

/**
 * Defines a restriction that can be applied to a {@link Restrictable}.
 *
 * @implNote A Restriction is always {@link Buildable} and needs a corresponding {@link RestrictionBuilder}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-12-09
 * @version 1.0.0
 *
 * @param <T> The type of restriction.
 */
public interface Restriction<T extends Restriction<T>> extends Buildable {}
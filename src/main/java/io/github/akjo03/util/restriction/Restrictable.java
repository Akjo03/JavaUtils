package io.github.akjo03.util.restriction;

import io.github.akjo03.util.builder.Buildable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * If a class implements this interface, it can be restricted by any number of {@link Restriction Restrictions}.
 *
 * @implNote A Restrictable is always {@link Buildable} and needs a corresponding {@link RestrictableBuilder}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-12-09
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public interface Restrictable extends Buildable {
	/**
	 * @return The list of {@link Restriction Restrictions} that are currently applied to this {@link Restrictable}.
	 */
	@NotNull List<Restriction<?>> getRestrictions();

	/**
	 * Gets all {@link Restriction Restrictions} of the given type.
	 *
	 * @param clazz The class of the type of {@link Restriction Restrictions} to get.
	 * @param <T> The type of {@link Restriction Restrictions} to get.
	 * @return A list of all {@link Restriction Restrictions} of the given type that are currently applied to this {@link Restrictable}.
	 *
	 * @implNote This method has default implementation and is not intended to be overridden.
	 */
	default <T extends Restriction<T>> @NotNull List<T> getRestrictions(@NotNull Class<T> clazz) {
		return getRestrictions().stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList());
	}

	/**
	 * Checks if this {@link Restrictable} is restricted by the given {@link Restriction Restriction} type.
	 *
	 * @param clazz The class of the type of {@link Restriction} to check.
	 * @param <T> The type of {@link Restriction} to check.
	 * @return Whether this {@link Restrictable} is restricted by the given {@link Restriction Restriction} type.
	 *
	 * @implNote This method has default implementation and is not intended to be overridden.
	 */
	default <T extends Restriction<T>> boolean isRestrictedBy(@NotNull Class<T> clazz) {
		return getRestrictions(clazz).size() > 0;
	}
}
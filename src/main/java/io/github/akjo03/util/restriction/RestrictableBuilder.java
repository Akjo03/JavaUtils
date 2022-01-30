package io.github.akjo03.util.restriction;

import io.github.akjo03.util.ArgumentChecks;
import io.github.akjo03.util.builder.Builder;
import io.github.akjo03.util.logging.Logger;
import io.github.akjo03.util.logging.LoggerManager;
import io.github.akjo03.util.logging.LoggingLevel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a builder for {@link Restrictable Restrictables}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-12-09
 * @version 1.0.0
 *
 * @param <T> The type of {@link Restrictable} to build.
 */
@SuppressWarnings("unused")
public abstract class RestrictableBuilder<T extends Restrictable> implements Builder<T> {
	private static final Logger LOGGER = LoggerManager.getLogger(RestrictableBuilder.class);

	/**
	 * List of types of {@link Restriction Restrictions} that are allowed to be added to the new {@link Restrictable}.
	 */
	@NotNull protected final List<Class<? extends Restriction<?>>> allowedRestrictions;
	/**
	 * List of restrctions that are going to restrict the new {@link Restrictable}.
	 */
	@NotNull protected final List<Restriction<?>> restrictions;

	/**
	 * Creates a new {@link RestrictableBuilder} to build a new {@link Restrictable}.
	 *
	 * @param allowedRestrictions The list of types of {@link Restriction Restrictions} that are allowed to be added to the new {@link Restrictable}.
	 */
	protected RestrictableBuilder(@NotNull final List<Class<? extends Restriction<?>>> allowedRestrictions) {
		this.allowedRestrictions = allowedRestrictions;
		this.restrictions = new ArrayList<>();
	}

	/**
	 * Adds a restriction to the new {@link Restrictable}.
	 *
	 * @param restriction The restriction to add.
	 * @return This {@link RestrictableBuilder} back to allow chaining.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public @NotNull RestrictableBuilder<T> addRestriction(@NotNull final Restriction<?> restriction) {
		ArgumentChecks.requireArgumentNotNull(restriction, "Can't add a null restriction to a Restrictable!");
		if (allowedRestrictions.contains(restriction.getClass())) {
			restrictions.add(restriction);
		} else {
			LOGGER.log("Restriction of type " + restriction.getClass().getSimpleName() + " is not allowed for " + getClass().getSimpleName() + "!", LoggingLevel.ERROR);
		}
		return this;
	}

	/**
	 * Adds multiple restrictions to the new {@link Restrictable}.
	 *
	 * @param restrictions The restrictions to add.
	 * @return This {@link RestrictableBuilder} back to allow chaining.
	 */
	public @NotNull RestrictableBuilder<T> addRestrictions(@NotNull final List<Restriction<?>> restrictions) {
		ArgumentChecks.requireArgumentNotNull(restrictions, "Can't add null restrictions to a Restrictable!");
		restrictions.forEach(this::addRestriction);
		return this;
	}

	/**
	 * @return A String representation of this {@link RestrictableBuilder}.
	 */
	@Override
	public String toString() {
		return "RestrictableBuilder{" + "allowedRestrictions=" + allowedRestrictions + ", restrictions=" + restrictions + '}';
	}
}
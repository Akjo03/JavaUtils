package io.github.akjo03.util;

import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

@SuppressWarnings("unused")
public final class EnumSetMerge {
	private EnumSetMerge() {}

	public static <T extends Enum<T>> @NotNull EnumSet<T> mergeEnumSets(EnumSet<T> a, EnumSet<T> b) {
		final EnumSet<T> union = EnumSet.copyOf(a);
		union.addAll(b);
		return union;
	}

	@SafeVarargs
	public static <T extends Enum<T>> @NotNull EnumSet<T> mergeEnumSets(EnumSet<T> @NotNull ... sets) {
		final EnumSet<T> union = EnumSet.noneOf(sets[0].iterator().next().getDeclaringClass());
		for (EnumSet<T> set : sets) {
			union.addAll(set);
		}
		return union;
	}
}
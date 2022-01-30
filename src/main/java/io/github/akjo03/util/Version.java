package io.github.akjo03.util;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Defines a version. Has major, minor, and patch versions.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-28
 * @version 1.0.0
 */
@Getter
public class Version {
	private final int major;
	private final int minor;
	private final int patch;

	/**
	 * Creates a new version.
	 *
	 * @param major The major version.
	 * @param minor The minor version.
	 * @param patch The patch version.
	 */
	public Version(int major, int minor, int patch) {
		this.major = major;
		this.minor = minor;
		this.patch = patch;
	}

	/**
	 * Creates a new version.
	 *
	 * @param version The version string.
	 */
	public Version(@NotNull String version) {
		String[] split = version.split("\\.");
		this.major = Integer.parseInt(split[0]);
		this.minor = Integer.parseInt(split[1]);
		this.patch = Integer.parseInt(split[2]);
	}

	/**
	 * @return A String representation of this version.
	 */
	public String toString() {
		return major + "." + minor + "." + patch;
	}

	/**
	 * Compares this version to the given object.
	 * @param o The object to compare to.
	 * @return True if the object is a Version and has the same major, minor, and patch version.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Version version = (Version) o;
		return major == version.major && minor == version.minor && patch == version.patch;
	}

	/**
	 * @return The hash code of this version.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(major, minor, patch);
	}
}
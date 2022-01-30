package io.github.akjo03.util;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class can be used to manage a java project directory.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-25
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public final class ProjectDirectory {
	/**
	 * <strong>This should never be used!</strong>
	 * @implNote This is a utility class and should not be instantiated!
	 */
	private ProjectDirectory() {
		throw new UnsupportedOperationException("ProjectDirectory class cannot be instantiated");
	}

	/**
	 * @return The folder where the current project is located in
	 */
	public static @NotNull Path getUsersProjectRootDirectory() {
		String envRootDir = System.getProperty("user.dir");
		Path rootDir = Paths.get(".").normalize().toAbsolutePath();
		if ( rootDir.startsWith(envRootDir) ) {
			return rootDir;
		} else {
			throw new RuntimeException("Root dir not found in user directory.");
		}
	}

	/**
	 * @return The folder "logs" inside the current project folder
	 */
	public static @NotNull Path getProjectLogDirectory() {
		return Path.of(getUsersProjectRootDirectory().toString(), "logs");
	}
}
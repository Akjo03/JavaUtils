package io.github.akjo03.util;

import java.io.IOException;

public final class ConsoleHelper {
	public static void clearScreen(){
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ignored) {}
	}
}

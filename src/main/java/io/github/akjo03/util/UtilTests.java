package io.github.akjo03.util;

import io.github.akjo03.util.logging.LogFile;
import io.github.akjo03.util.logging.Logger;
import io.github.akjo03.util.logging.LoggerManager;

import java.nio.file.Path;

public class UtilTests implements Runnable {
	private static final Logger LOGGER = LoggerManager.getLogger(UtilTests.class);
	public static final LogFile MAIN_LOG_FILE = new LogFile(Path.of(ProjectDirectory.getProjectLogDirectory().toString(), "latest.log"));

	private UtilTests() {
		MAIN_LOG_FILE.addLogger(LOGGER);
	}

    public static void main(String[] args) {
		new UtilTests().run();
	}

	@Override
	public void run() {}
}
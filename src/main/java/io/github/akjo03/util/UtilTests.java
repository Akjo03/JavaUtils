package io.github.akjo03.util;

import io.github.akjo03.util.logging.LogFile;
import io.github.akjo03.util.logging.Logger;
import io.github.akjo03.util.logging.LoggerManager;
import io.github.akjo03.util.math.AdditionalBigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
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
	public void run() {
		System.out.println(AdditionalBigDecimalMath.toRadians(new BigDecimal("7.0"), MathContext.DECIMAL64));
	}
}
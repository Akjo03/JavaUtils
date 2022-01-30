package io.github.akjo03.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("unused")
public class JsonFile<T extends JsonParsable> {
	private static final Logger LOGGER = LoggerManager.getLogger(JsonFile.class, LoggingLevel.INFO);

	@NotNull private final String name;

	@NotNull private final ObjectMapper objectMapper;
	@NotNull private final ObjectReader objectReader;
	@NotNull private final ObjectWriter objectWriter;

	@NotNull private final Path filePath;
	@Nullable private final Path defaultFilePath;

	private final Class<T> pojoClass;
	private T pojoInstance;

	public JsonFile(@NotNull String name, @NotNull Class<T> pojoClass, @NotNull Path filePath) {
		this(name, pojoClass, filePath, null);
	}

	public JsonFile(@NotNull String name, @NotNull Class<T> pojoClass, @NotNull Path filePath, @Nullable Path defaultFilePath) {
		this.name = name;
		this.pojoClass = pojoClass;
		this.filePath = filePath;
		this.defaultFilePath = defaultFilePath;

		this.objectMapper = new ObjectMapper()
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule())
				.setDefaultPrettyPrinter(new JsonPrettyPrinter())
				.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		// Create and load the file
		try {
			if (createFileIfNotExists()) {
				LOGGER.log("JsonFile '" + name + "' now exists! Loading it...", LoggingLevel.INFO);
				if (defaultFilePath != null && Files.exists(defaultFilePath)) {
					LOGGER.log("JsonFile '" + name + "' has a default file at \"" + defaultFilePath + "\". Loading it into file...", LoggingLevel.INFO);
					loadFileWithDefaultFile(defaultFilePath);
				} else {
					LOGGER.log("JsonFile '" + name + "' has no default file. Loading default values into file...", LoggingLevel.INFO);
					loadFileWithDefaultValues();
				}
				LOGGER.log("Successfully loaded JsonFile '" + name + "'!", LoggingLevel.SUCCESS);
			}
		} catch (IllegalArgumentException e) {
			LOGGER.log("Failed to construct new JsonFile '" + name + "'!", LoggingLevel.ERROR, e);
			throw new RuntimeException(e);
		}

		// Create the POJO instance from the file
		try {
			this.pojoInstance = objectMapper.readValue(filePath.toFile(), pojoClass);
		} catch (IOException e) {
			LOGGER.log("Failed to create POJO instance from JsonFile '" + name + "'!", LoggingLevel.ERROR, e);
			throw new RuntimeException(e);
		}

		// Create the ObjectReader and ObjectWriter to update the POJO instance
		this.objectReader = objectMapper.readerForUpdating(pojoInstance);
		this.objectWriter = objectMapper.writerFor(pojoClass).with(new JsonPrettyPrinter());
	}

	private boolean createFileIfNotExists() throws IllegalArgumentException {
		if (!Files.exists(filePath)) {
			LOGGER.log("JsonFile '" + name + "' does not exist yet. Creating it...", LoggingLevel.INFO);
			try {
				Files.createDirectories(filePath.getParent());
				Files.createFile(filePath);
				LOGGER.log("Successfully created JsonFile '" + name + "'!", LoggingLevel.SUCCESS);
				return true;
			} catch (IOException e) {
				IllegalArgumentException iae = new IllegalArgumentException("Failed to create JsonFile '" + name + "'!", e);
				LOGGER.log(iae);
				throw iae;
			}
		}
		return false;
	}

	private void loadFileWithDefaultValues() {
		T defaultPojoInstance = null;
		try {
			defaultPojoInstance = pojoClass.getConstructor().newInstance();
		} catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		if (defaultPojoInstance != null) {
			try {
				objectMapper.writeValue(filePath.toFile(), defaultPojoInstance);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadFileWithDefaultFile(@NotNull Path defaultFilePath) {
		try {
			objectMapper.writeValue(filePath.toFile(), objectMapper.readValue(defaultFilePath.toFile(), pojoClass));
		} catch (IOException e) {
			IllegalArgumentException iae = new IllegalArgumentException("Failed to load default file into JsonFile '" + name + "'!", e);
			LOGGER.log(iae);
			throw iae;
		}
	}

	public T getData() {
		return pojoInstance;
	}

	public void submitData(T data) {
		this.pojoInstance = data;
	}

	public void writeData() {
		try {
			objectWriter.writeValue(filePath.toFile(), pojoInstance);
		} catch (IOException e) {
			IllegalArgumentException iae = new IllegalArgumentException("Failed to write data into JsonFile '" + name + "'!", e);
			LOGGER.log(iae);
			throw iae;
		}
	}

	public void readData() {
		try {
			this.pojoInstance = objectReader.readValue(filePath.toFile(), pojoClass);
		} catch (IOException e) {
			IllegalArgumentException iae = new IllegalArgumentException("Failed to read data from JsonFile '" + name + "'!", e);
			LOGGER.log(iae);
			throw iae;
		}
	}

	public T readAndGetData() {
		readData();
		return getData();
	}

	public void submitAndWriteData(T data) {
		submitData(data);
		writeData();
	}
}
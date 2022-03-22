package io.github.akjo03.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class SerializableJsonWriter {
	private final ObjectWriter writer;
	private final JsonGenerator generator;
	private final SerializerProvider provider;

	public SerializableJsonWriter(@NotNull File file) throws IOException {
		this.writer = new ObjectMapper()
				.registerModule(new Jdk8Module())
				.registerModule(new JavaTimeModule())
				.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.enable(SerializationFeature.INDENT_OUTPUT)
				.writer(new JsonPrettyPrinter());
		this.generator = writer
				.getFactory()
				.createGenerator(new FileOutputStream(file))
				.setPrettyPrinter(new JsonPrettyPrinter());
		this.provider = new DefaultSerializerProvider.Impl();
	}

	public void write(@NotNull JsonSerializable serializable) throws IOException {
		serializable.serialize(generator, provider);
	}

	public void close() throws IOException {
		generator.close();
	}
}
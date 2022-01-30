package io.github.akjo03.util;

import io.github.akjo03.util.logging.Logger;
import io.github.akjo03.util.logging.LoggerManager;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ObjectString {
	@SuppressWarnings("FieldCanBeLocal")
	private final Logger LOGGER;

	private final Map<String, Object> attributes;
	private final Class<?> clazz;

	public ObjectString(Class<?> clazz) {
		this.attributes = new LinkedHashMap<>();
		this.clazz = clazz;
		this.LOGGER = LoggerManager.getLogger(clazz);
	}

	public ObjectString addAttribute(String name, Object attribute) {
		attributes.put(name, attribute);
		return this;
	}

	@Override
	public String toString() {
		return toString(0);
	}

	public String toString(int indent) {
		StringBuilder builder = new StringBuilder();
		builder.append("\t".repeat(indent)).append(clazz.getSimpleName()).append(": ").append("\n");
		int i = 0;
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			builder.append("\t".repeat(indent + 1)).append(entry.getKey()).append(": ");
			if (entry.getValue() instanceof String) {
				builder.append("\"").append(entry.getValue().toString()).append("\"");
			} else {
				builder.append(entry.getValue());
			}
			if (i < attributes.size() - 1) {
				builder.append("\n");
			}
			i++;
		}
		return builder.toString();
	}
}
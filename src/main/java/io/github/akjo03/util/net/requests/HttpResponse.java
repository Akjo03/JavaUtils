package io.github.akjo03.util.net.requests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

/**
 * A class that represents a response from an {@link HttpRequest}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-05
 * @version 1.0.0
 */
@SuppressWarnings({"unused", "ClassCanBeRecord"})
public class HttpResponse {
	/**
	 * The status code of this response.
	 */
	@Getter
	private final int statusCode;
	/**
	 * The headers of this response.
	 */
	@Getter
	private final Map<String, String> headers;
	/**
	 * The version of the HTTP protocol used by this response.
	 */
	@Getter
	private final HttpClient.Version version;
	/**
	 * The method used to send the request of this response.
	 */
	@Getter
	private final HttpMethods method;

	/**
	 * The raw input stream of this response.
	 */
	private final InputStream rawValue;

	protected HttpResponse(InputStream rawValue, int statusCode, Map<String, String> headers, HttpClient.Version version, HttpMethods method) {
		this.statusCode = statusCode;
		this.headers = headers;
		this.version = version;
		this.method = method;

		this.rawValue = rawValue;
	}

	//region === Response Read Methods ===

	/**
	 * @return The body of this response as a raw {@link InputStream}.
	 */
	public InputStream raw() {
		return rawValue;
	}

	/**
	 * @return The body of this response as a byte array.
	 * @throws IOException If the body cannot be read as a byte array.
	 */
	public byte[] bytes() throws IOException {
		return IOUtils.toByteArray(rawValue);
	}

	/**
	 * @return The body of this response as a {@link String}.
	 * @throws IOException If the body cannot be read as a {@link String}.
	 */
	public String text() throws IOException {
		return IOUtils.toString(rawValue, Charset.defaultCharset());
	}

	/**
	 * @return The body of this response as a {@link JsonNode}.
	 * @throws IOException If the body cannot be read as a {@link JsonNode}/isn't json data.
	 */
	public JsonNode json() throws IOException {
		return new ObjectMapper().readTree(rawValue);
	}

	/**
	 * Uses an {@link ObjectMapper} to return a {@link JsonParsable} that can be used to parse the body of this response.
	 * @param clazz The class of the {@link JsonParsable} to return.
	 * @param <T> The type of {@link JsonParsable} to return. Inferred from the {@code clazz} parameter.
	 * @return The {@link JsonParsable} that can be used to parse the body of this response.
	 * @throws IOException If the body cannot be read as a {@link JsonParsable}.
	 */
	public <T extends JsonParsable> T json(Class<T> clazz) throws IOException {
		return new ObjectMapper().readValue(rawValue, clazz);
	}

	/**
	 * Writes the body of this response to a file.
	 * @param path The path to the file where the body should be written to.
	 * @return The path back
	 * @throws IOException If the body cannot be written to the file.
	 */
	public Path file(@NotNull Path path) throws IOException {
		File file = path.toFile();
		FileUtils.copyInputStreamToFile(rawValue, file);
		return file.toPath();
	}

	//endregion

	//region === General Object Methods ===

	/**
	 * @return A {@link String} representation of this {@link HttpResponse}.
	 */
	@Override
	public String toString() {
		return "HttpResponse{" + "statusCode=" + statusCode + ", headers=" + headers + ", version=" + version + ", rawValue=" + rawValue + '}';
	}

	/**
	 * Compares the given object with this {@link HttpResponse} to see if they're equal.
	 * @param o The object to compare this {@link HttpResponse} with.
	 * @return {@code true} if the given object is equal to this response, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HttpResponse that = (HttpResponse) o;
		return statusCode == that.statusCode && Objects.equals(headers, that.headers) && version == that.version && Objects.equals(rawValue, that.rawValue);
	}

	/**
	 * @return The hash code of this {@link HttpResponse}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(statusCode, headers, version, rawValue);
	}

	//endregion
}
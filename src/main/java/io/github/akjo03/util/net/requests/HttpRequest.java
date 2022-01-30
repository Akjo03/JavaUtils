package io.github.akjo03.util.net.requests;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.akjo03.util.builder.Buildable;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Represents an HTTP request. Used to return an {@link HttpResponse} of the request by using a {@link HttpMethods HttpMethod}.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-05
 * @version 1.0.0
 */
@Getter
@SuppressWarnings({"unused", "ClassCanBeRecord"})
public class HttpRequest implements Buildable {
	/**
	 * The URI where this request is sent to.
	 */
	@NotNull private final URI uri;
	/**
	 * The headers of this request.
	 */
	@NotNull private final Map<String, String> headers;
	/**
	 * If this request should allow redirects.
	 */
	private final boolean allowRedirects;
	/**
	 * The time in milliseconds after this request times out.
	 */
	private final long timeout;

	/**
	 * Creates a new {@link HttpRequest} with the given {@link URI} and {@link Map} of headers. Should only be used by an {@link HttpRequestBuilder}
	 * @param uri The URI where this request is sent to.
	 * @param headers The headers of this request.
	 * @param allowRedirects If this request should allow redirects.
	 * @param timeout The time in milliseconds after this request times out.
	 */
	HttpRequest(@NotNull URI uri, @NotNull Map<String, String> headers, boolean allowRedirects, long timeout) {
		this.uri = uri;
		this.headers = headers;
		this.allowRedirects = allowRedirects;
		this.timeout = timeout;
	}

	//region === HTTP Methods ===

	/**
	 * Uses the GET method to send this request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#GET
	 */
	public HttpResponse get() throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.GET();
		return getHttpResponse(requestBuilder, HttpMethods.GET);
	}

	/**
	 * Uses the POST method with no body to send this request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#POST
	 */
	public HttpResponse post() throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.POST(java.net.http.HttpRequest.BodyPublishers.noBody());
		return getHttpResponse(requestBuilder, HttpMethods.POST);
	}

	/**
     * Uses the POST method with the given {@link String} as body to send this request.
     * @param body The body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#POST
     */
	public HttpResponse post(String body) throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.POST(java.net.http.HttpRequest.BodyPublishers.ofString(body, Charset.defaultCharset()));
		return getHttpResponse(requestBuilder, HttpMethods.POST);
	}

	/**
     * Uses the POST method with the given byte array as body to send this request.
     * @param body The body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#POST
     */
	public HttpResponse post(byte[] body) throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.POST(java.net.http.HttpRequest.BodyPublishers.ofByteArray(body));
		return getHttpResponse(requestBuilder, HttpMethods.POST);
	}

	/**
     * Uses the POST method with the given {@link Path} to a file as body to send this request.
     * @param file The file to read as body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#POST
     */
	public HttpResponse post(Path file) throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.POST(java.net.http.HttpRequest.BodyPublishers.ofFile(file));
		return getHttpResponse(requestBuilder, HttpMethods.POST);
	}

	/**
	 * Uses the POST method with the given {@link JsonNode} as body to send this request.
	 * @param json The json data to send as body of the request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#POST
	 */
	public HttpResponse post(@NotNull JsonNode json) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.POST(java.net.http.HttpRequest.BodyPublishers.ofString(json.toString()));
        return getHttpResponse(requestBuilder, HttpMethods.POST);
    }

	/**
     * Uses the PUT method with no body to send this request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PUT
     */
	public HttpResponse put() throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.PUT(java.net.http.HttpRequest.BodyPublishers.noBody());
        return getHttpResponse(requestBuilder, HttpMethods.PUT);
    }

	/**
     * Uses the PUT method with the given {@link String} as body to send this request.
     * @param body The body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PUT
     */
	public HttpResponse put(String body) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.PUT(java.net.http.HttpRequest.BodyPublishers.ofString(body, Charset.defaultCharset()));
        return getHttpResponse(requestBuilder, HttpMethods.PUT);
    }

	/**
     * Uses the PUT method with the given byte array as body to send this request.
     * @param body The body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PUT
     */
	public HttpResponse put(byte[] body) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.PUT(java.net.http.HttpRequest.BodyPublishers.ofByteArray(body));
        return getHttpResponse(requestBuilder, HttpMethods.PUT);
    }

	/**
	 * Uses the PUT method with the given {@link Path} to a file as body to send this request.
	 * @param file The file to read as body of the request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#PUT
	 */
	public HttpResponse put(Path file) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.PUT(java.net.http.HttpRequest.BodyPublishers.ofFile(file));
        return getHttpResponse(requestBuilder, HttpMethods.PUT);
    }

	/**
     * Uses the PUT method with the given {@link JsonNode} as body to send this request.
     * @param json The json data to send as body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PUT
     */
	public HttpResponse put(@NotNull JsonNode json) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.PUT(java.net.http.HttpRequest.BodyPublishers.ofString(json.toString()));
        return getHttpResponse(requestBuilder, HttpMethods.PUT);
    }

	/**
     * Uses the PATCH method with no body to send this request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PATCH
     */
	public HttpResponse patch() throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.method("PATCH", java.net.http.HttpRequest.BodyPublishers.noBody());
		return getHttpResponse(requestBuilder, HttpMethods.PATCH);
	}

	/**
	 * Uses the PATCH method with the given {@link String} as body to send this request.
	 * @param body The body of the request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#PATCH
	 */
	public HttpResponse patch(String body) throws IOException, InterruptedException {
		java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
		requestBuilder.method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofString(body, Charset.defaultCharset()));
		return getHttpResponse(requestBuilder, HttpMethods.PATCH);
	}

	/**
     * Uses the PATCH method with the given byte array as body to send this request.
     * @param body The body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PATCH
     */
	public HttpResponse patch(byte[] body) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofByteArray(body));
        return getHttpResponse(requestBuilder, HttpMethods.PATCH);
    }

	/**
     * Uses the PATCH method with the given {@link Path} to a file as body to send this request.
     * @param file The file to read as body of the request.
     * @return The response to this request.
     * @throws IOException If an I/O error occurs when sending the request/receiving the response.
     * @throws InterruptedException If the sending of the request is interrupted.
     * @see HttpMethods#PATCH
     */
	public HttpResponse patch(Path file) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofFile(file));
        return getHttpResponse(requestBuilder, HttpMethods.PATCH);
    }

	/**
	 * Uses the PATCH method with the given {@link JsonNode} as body to send this request.
	 * @param json The json data to send as body of the request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#PATCH
	 */
	public HttpResponse patch(@NotNull JsonNode json) throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofString(json.toString()));
        return getHttpResponse(requestBuilder, HttpMethods.PATCH);
    }

	/**
	 * Uses the DELETE method with to send this request.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 * @see HttpMethods#DELETE
	 */
	public HttpResponse delete() throws IOException, InterruptedException {
        java.net.http.HttpRequest.Builder requestBuilder = initRequestBuilder();
        requestBuilder.DELETE();
        return getHttpResponse(requestBuilder, HttpMethods.DELETE);
    }

	//endregion

	//region === Private Methods ===

	/**
	 * Uses an {@link java.net.http.HttpRequest.Builder} to build an {@link java.net.http.HttpRequest} and send it. Creates a new {@link HttpResponse} with the response of the {@link java.net.http.HttpRequest} and the {@link HttpMethods HttpMethod} used. Returnes the created {@link HttpResponse}.
	 * @param requestBuilder The {@link java.net.http.HttpRequest.Builder} to build the {@link java.net.http.HttpRequest} with.
	 * @param method The {@link HttpMethods} used to send the {@link java.net.http.HttpRequest}.
	 * @return The response to this request.
	 * @throws IOException If an I/O error occurs when sending the request/receiving the response.
	 * @throws InterruptedException If the sending of the request is interrupted.
	 */
	@NotNull
	private HttpResponse getHttpResponse(java.net.http.HttpRequest.@NotNull Builder requestBuilder, HttpMethods method) throws IOException, InterruptedException {
		java.net.http.HttpRequest request = requestBuilder.build();
		HttpClient httpClient = HttpClient.newBuilder().followRedirects(allowRedirects ? HttpClient.Redirect.ALWAYS : HttpClient.Redirect.NEVER).build();
		java.net.http.HttpResponse<InputStream> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofInputStream());

		return new HttpResponse(response.body(), response.statusCode(), headersToMap(request.headers()), response.version(), method);
	}

	/**
	 * Initialies a new {@link java.net.http.HttpRequest.Builder} with the {@link URI} of this request and sets the headers and timeout of this request.
	 * @return The initialized {@link java.net.http.HttpRequest.Builder}.
	 */
	private java.net.http.HttpRequest.@NotNull Builder initRequestBuilder() {
		java.net.http.HttpRequest.Builder requestBuilder = java.net.http.HttpRequest.newBuilder();
		requestBuilder.uri(uri);
		if (!headers.isEmpty()) {
			String[] headerStrings = headersToStringArray();
			requestBuilder.headers(headerStrings);
		}
		if (timeout != 0) {
			requestBuilder.timeout(Duration.of(timeout, ChronoUnit.MILLIS));
		}
		return requestBuilder;
	}

	/**
	 * @return The headers of this request as a {@link String} array.
	 */
	private String @NotNull [] headersToStringArray() {
		String[] headerStrings = new String[headers.size()*2];
		List<String> headerStringList = new ArrayList<>();
		headers.forEach((key, value) -> {
			headerStringList.add(key);
			headerStringList.add(value);
		});
		return headerStringList.toArray(headerStrings);
	}

	/**
	 * @param headers The {HttpHeaders} to convert to a {@link Map}.
	 * @return The specified {@link HttpHeaders} as a {@link Map}.
	 */
	private @NotNull Map<String, String> headersToMap(@NotNull HttpHeaders headers) {
		Map<String, String> resultMap = new HashMap<>();
		headers.map().forEach((key, values) -> resultMap.put(key, values.get(0)));
		return resultMap;
	}

	//endregion

	//region === General Object Methods ===

	/**
	 * @return A {@link String} representation of this request.
	 */
	@Override
	public String toString() {
		return "HttpRequest{" + "uri=" + uri + ", headers=" + headers + ", allowRedirects=" + allowRedirects + ", timeout=" + timeout + '}';
	}

	/**
	 * Compares the given object with this request to see if they're equal.
	 * @param o The object to compare this request with.
	 * @return {@code true} if the given object is equal to this request, {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HttpRequest request = (HttpRequest) o;
		return allowRedirects == request.allowRedirects && timeout == request.timeout && uri.equals(request.uri) && headers.equals(request.headers);
	}

	/**
     * @return The hash code of this request.
     */
	@Override
	public int hashCode() {
		return Objects.hash(uri, headers, allowRedirects, timeout);
	}

	//endregion
}
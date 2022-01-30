package io.github.akjo03.util.net.requests;

import io.github.akjo03.util.builder.Builder;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Builds an {@link HttpRequest}. Needs a {@link URI}.
 *
 * Headers can be added with {@link #addHeader(String, String)} or {@link #addHeaders(Map)} or be set by {@link #setHeaders(Map)}.
 *
 * Redirects can be allowed with {@link #allowRedirects(boolean)}. Redirects are not allowed by default.
 *
 * Additionally, a timeout can be set.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-05
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class HttpRequestBuilder implements Builder<HttpRequest> {
	/**
	 * The {@link URI} where this request goes to.
	 */
	@NotNull private final URI uri;
	/**
	 * The headers of this request.
	 */
	@NotNull private Map<String, String> headers;
	/**
	 * Whether redirects are allowed.
	 */
	private boolean allowRedirects = false;
	/**
     * The time in milliseconds before this request will time out.
     */
	private long timeout = 0L;

	/**
	 * Creates a new {@link HttpRequestBuilder} with the given {@link URI}.
	 * @param uri The {@link URI} where this request goes to.
	 */
	public HttpRequestBuilder(@NotNull URI uri) {
		this.uri = uri;
		this.headers = new HashMap<>();
	}

	/**
	 * Adds a single header to this request.
	 * @param key The key of this header.
	 * @param values The value(s) of this header.
	 * @return This {@link HttpRequestBuilder} to allow chaining.
	 */
	public HttpRequestBuilder addHeader(@NotNull String key, @NotNull String values) {
		this.headers.put(key, values);
		return this;
	}

	/**
	 * Adds multiple headers to this request.
	 * @param headers The headers that should be added.
	 * @return This {@link HttpRequestBuilder} to allow chaining.
	 */
	public HttpRequestBuilder addHeaders(@NotNull Map<String, String> headers) {
		this.headers.putAll(headers);
		return this;
	}

	/**
	 * Sets the headers of this request.
	 * @param headers The headers that should be set.
	 * @return This {@link HttpRequestBuilder} to allow chaining.
	 */
	public HttpRequestBuilder setHeaders(@NotNull Map<String, String> headers) {
		this.headers = headers;
		return this;
	}

	/**
	 * Sets if this request should allow redirects.
	 * @return This {@link HttpRequestBuilder} to allow chaining.
	 */
	public HttpRequestBuilder allowRedirects(boolean allowRedirects) {
		this.allowRedirects = allowRedirects;
		return this;
	}

	/**
	 * Sets the timeout of this request.
	 * @param timeout How long this request should wait before timing out.
	 * @return This {@link HttpRequestBuilder} to allow chaining.
	 */
	public HttpRequestBuilder setTimeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	/**
	 * Builds this {@link HttpRequest}.
	 * @return The built {@link HttpRequest}.
	 */
	@Override
	public HttpRequest build() {
		return new HttpRequest(uri, headers, allowRedirects, timeout);
	}

	/**
	 * @return A string representation of this HttpRequestBuilder.
	 */
	@Override
	public @NotNull String toString() {
		return "HttpRequestBuilder{" + "uri=" + uri + ", headers=" + headers + ", allowRedirects=" + allowRedirects + '}';
	}
}
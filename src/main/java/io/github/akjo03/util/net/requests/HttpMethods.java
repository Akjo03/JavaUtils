package io.github.akjo03.util.net.requests;

import org.jetbrains.annotations.NotNull;

/**
 * Specifies the HTTP methods that can be used in a request.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-18
 * @version 1.0.0
 */
public enum HttpMethods {
	/**
     * The HTTP GET method is used to retrieve information from the specified resource.
	 * @see <a href="https://tools.ietf.org/html/rfc7231#section-4.3.1">RFC 7231 Section 4.3.1</a>
     */
	GET,
	/**
	 * The HTTP POST method is used to submit an entity to the specified resource.
	 * @see <a href="https://tools.ietf.org/html/rfc7231#section-4.3.3">RFC 7231 Section 4.3.3</a>
	 */
    POST,
	/**
     * The HTTP PUT method is used to replace the specified resource with the request payload.
     * @see <a href="https://tools.ietf.org/html/rfc7231#section-4.3.4">RFC 7231 Section 4.3.4</a>
     */
    PUT,
	/**
	 * The HTTP PATCH method is used to apply partial modifications to a resource.
	 * @see <a href="https://tools.ietf.org/html/rfc5789#section-2">RFC 5789 Section 2</a>
	 */
	PATCH,
	/**
	 * The HTTP REMOVE method is used to delete the specified resource.
	 * @see <a href="https://tools.ietf.org/html/rfc7231#section-4.3.5">RFC 7231 Section 4.3.5</a>
	 */
    DELETE;

	/**
	 * @return A string representation of this HTTP method.
	 */
	@Override
	public @NotNull String toString() {
		return getClass().getSimpleName() + "." + name();
	}
}
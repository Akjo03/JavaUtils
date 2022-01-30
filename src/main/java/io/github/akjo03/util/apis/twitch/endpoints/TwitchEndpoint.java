package io.github.akjo03.util.apis.twitch.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.akjo03.util.apis.twitch.data.api.TwitchApiResponse;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.github.akjo03.util.logging.v2.LoggingLevel;
import io.github.akjo03.util.net.requests.HttpMethods;
import io.github.akjo03.util.net.requests.HttpRequest;
import io.github.akjo03.util.net.requests.HttpRequestBuilder;
import io.github.akjo03.util.net.requests.HttpResponse;
import org.apache.commons.collections4.MultiValuedMap;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class TwitchEndpoint<R extends TwitchApiResponse<R>> {
	protected final Logger LOGGER;

	protected static final String TWITCH_API_URL = "https://api.twitch.tv/helix";

	@NotNull protected final Class<R> responseClass;

	@NotNull protected final String name;
	@NotNull protected final String endpointURI;
	@NotNull protected final HttpMethods[] allowedMethods;

	protected TwitchEndpoint(@NotNull Class<R> responseClass, @NotNull String name, @NotNull String endpointPath, @NotNull HttpMethods[] allowedMethods) {
		this.LOGGER = LoggerManager.getLogger(this.getClass(), LoggingLevel.INFO);

		this.responseClass = responseClass;

		this.name = name;
		this.endpointURI = TWITCH_API_URL + endpointPath;
		this.allowedMethods = allowedMethods;
	}

	public List<R> getAllData(@NotNull Map<String, String> userAccessHeaders, @NotNull MultiValuedMap<String, String> queryParams, int maxIndex) {
		int currentIndex = 0;

		String queryString;
		if (queryParams.isEmpty()) {
			queryString = endpointURI;
		} else {
			queryString = endpointURI + "?" + queryParams.entries().stream()
					.map(e -> e.getKey() + "=" + e.getValue())
					.reduce((a, b) -> a + "&" + b)
					.orElse(endpointURI);
		}
		URI queryURI = URI.create(queryString);

		if (Arrays.stream(allowedMethods).noneMatch(m -> m == HttpMethods.GET)) {
			LOGGER.log("Endpoint " + name + " does not allow GET requests!", LoggingLevel.ERROR);
			return null;
		}

		List<R> queryResults = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		HttpRequest firstRequest = new HttpRequestBuilder(queryURI).addHeaders(userAccessHeaders).build();
		HttpResponse firstResponse;
		try {
			firstResponse = firstRequest.get();
		} catch (IOException | InterruptedException e) {
			LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR, e);
			return null;
		}
		if (firstResponse == null) {
			LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR);
			return null;
		}
		if (firstResponse.getStatusCode() != 200) {
			LOGGER.log("Request to " + name + " failed with status code " + firstResponse.getStatusCode() + "!", LoggingLevel.ERROR);
		}

		JsonNode firstData;
		try {
			firstData = firstResponse.json();
		} catch (IOException e) {
			LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR, e);
			return null;
		}
		if (firstData == null) {
			LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR);
			return null;
		}
		for (JsonNode dataObject : firstData.get("data")) {
			if (currentIndex >= maxIndex) {
				return queryResults;
			}
			try {
				queryResults.add(mapper.treeToValue(dataObject, responseClass));
				currentIndex++;
			} catch (JsonProcessingException e) {
				LOGGER.log("Failed to parse JSON data from " + name + "!", LoggingLevel.ERROR, e);
			}
		}

		String cursor;
		try {
			cursor = firstData.get("pagination").get("cursor").asText();
		} catch (NullPointerException e) {
			return queryResults;
		}
		while (cursor != null && !cursor.isEmpty()) {
			if (currentIndex >= maxIndex) {
				break;
			}
			String newQueryString;
			if (queryString.contains("?")) {
				newQueryString = queryString + "&";
			} else {
				newQueryString = queryString + "?";
			}
			newQueryString += "after=" + cursor;
			URI nextQueryURI = URI.create(newQueryString);
			HttpRequest nextRequest = new HttpRequestBuilder(nextQueryURI).addHeaders(userAccessHeaders).build();
			HttpResponse nextResponse;
			try {
				nextResponse = nextRequest.get();
			} catch (IOException | InterruptedException e) {
				LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR, e);
				continue;
			}
			if (nextResponse == null) {
				LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR);
				continue;
			}
			if (nextResponse.getStatusCode() != 200) {
				LOGGER.log("Request to " + name + " failed with status code " + nextResponse.getStatusCode() + "!", LoggingLevel.ERROR);
				continue;
			}

			JsonNode nextData;
			try {
				nextData = nextResponse.json();
			} catch (IOException e) {
				LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR, e);
				continue;
			}
			if (nextData == null) {
				LOGGER.log("Request to " + name + " failed!", LoggingLevel.ERROR);
				continue;
			}
			try {
				cursor = nextData.get("pagination").get("cursor").asText();
			} catch (NullPointerException e) {
				cursor = null;
			}
			for (JsonNode dataObject : nextData.get("data")) {
				try {
					queryResults.add(mapper.treeToValue(dataObject, responseClass));
					currentIndex++;
				} catch (JsonProcessingException e) {
					LOGGER.log("Failed to parse JSON data from " + name + "!", LoggingLevel.ERROR, e);
				}
			}
		}
		return queryResults;
	}

	public R getDataByIndex(@NotNull Map<String, String> userAccessHeaders, @NotNull MultiValuedMap<String, String> queryParams, int index) {
		List<R> allData = getAllData(userAccessHeaders, queryParams, index+1);
		if (allData == null) {
			return null;
		}
		if (index >= allData.size()) {
			return null;
		}
		return allData.get(index);
	}
}
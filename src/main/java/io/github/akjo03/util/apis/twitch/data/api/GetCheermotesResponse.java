package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.CheermoteTier;
import io.github.akjo03.util.apis.twitch.data.util.CheermoteType;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCheermotesResponse extends TwitchApiResponse<GetCheermotesResponse> {
	private final String prefix;
	private final List<CheermoteTier> tiers;
	private final CheermoteType type;
	private final int order;
	private final Instant lastUpdated;
	private final boolean isCharitable;

	public GetCheermotesResponse(
			@JsonProperty("prefix")
			String prefix,
			@JsonProperty("tiers")
			List<CheermoteTier> tiers,
			@JsonProperty("type")
			String type,
			@JsonProperty("order")
			int order,
			@JsonProperty("last_updated")
			String lastUpdated,
			@JsonProperty("is_charitable")
			boolean isCharitable
	) {
		this.prefix = prefix;
		this.tiers = tiers;
		this.type = CheermoteType.fromString(type);
		this.order = order;
		this.lastUpdated = Instant.parse(lastUpdated);
		this.isCharitable = isCharitable;
	}

	@Override
	public String toString() {
		return "GetCheermotesResponse{" + "prefix='" + prefix + '\'' + ", tiers=" + tiers + ", type='" + type + '\'' + ", order=" + order + ", lastUpdated=" + lastUpdated + ", isCharitable=" + isCharitable + '}';
	}
}
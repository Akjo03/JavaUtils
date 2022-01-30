package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStreamTagsResponse extends TwitchApiResponse<GetStreamTagsResponse> {
	private final String tagID;
	private final boolean isAuto;
	private final Map<String, String> localizedNames;
	private final Map<String, String> localizedDescriptions;

	public GetStreamTagsResponse(
			@JsonProperty("tag_id")
					String tagID,
			@JsonProperty("is_auto")
					boolean isAuto,
			@JsonProperty("localization_names")
					Map<String, String> localizedNames,
			@JsonProperty("localization_descriptions")
					Map<String, String> localizedDescriptions
	) {
		this.tagID = tagID;
		this.isAuto = isAuto;
		this.localizedNames = localizedNames;
		this.localizedDescriptions = localizedDescriptions;
	}

	@Override
	public String toString() {
		return "GetStreamTagsResponse{" + "tagID='" + tagID + '\'' + ", isAuto=" + isAuto + ", localizedNames=" + localizedNames + ", localizedDescriptions=" + localizedDescriptions + '}';
	}
}

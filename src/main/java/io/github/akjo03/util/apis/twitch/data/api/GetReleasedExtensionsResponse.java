package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.akjo03.util.apis.twitch.data.util.ReleasedExtensionIconUrls;
import io.github.akjo03.util.apis.twitch.data.util.ReleasedExtensionState;
import io.github.akjo03.util.apis.twitch.data.util.ReleasedExtensionViews;
import lombok.Getter;

import java.net.URI;
import java.util.List;
import java.util.stream.Stream;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetReleasedExtensionsResponse extends TwitchApiResponse<GetReleasedExtensionsResponse> {
	private final String authorName;
	private final boolean bitsEnabled;
	private final boolean canBeInstalled;
	private final String configLocation;
	private final String description;
	private final URI eulaTosURL;
	private final boolean hasChatSupport;
	private final URI iconURL;
	private final ReleasedExtensionIconUrls iconURLs;
	private final String id;
	private final String name;
	private final URI privacyPolicyURL;
	private final boolean requestIdentityLink;
	private final List<URI> screenshotURLs;
	private final ReleasedExtensionState state;
	private final String summary;
	private final String supportEmail;
	private final String version;
	private final String viewerSummary;
	private final ReleasedExtensionViews views;
	private final List<URI> allowlistedConfigURLs;
	private final List<URI> allowlistedPanelURLs;

	public GetReleasedExtensionsResponse(
			@JsonProperty("author_name")
			String authorName,
			@JsonProperty("bits_enabled")
			boolean bitsEnabled,
			@JsonProperty("can_install")
			boolean canBeInstalled,
			@JsonProperty("config_location")
			String configLocation,
			@JsonProperty("description")
			String description,
			@JsonProperty("eula_tos_url")
			String eulaTosURL,
			@JsonProperty("has_chat_support")
			boolean hasChatSupport,
			@JsonProperty("icon_url")
			String iconURL,
			@JsonProperty("icon_urls")
			ReleasedExtensionIconUrls iconURLs,
			@JsonProperty("id")
			String id,
			@JsonProperty("name")
			String name,
			@JsonProperty("privacy_policy_url")
			URI privacyPolicyURL,
			@JsonProperty("request_identity_link")
			boolean requestIdentityLink,
			@JsonProperty("screenshot_urls")
			String[] screenshotURLs,
			@JsonProperty("state")
			String state,
			@JsonProperty("subscriptions_support_level")
			@SuppressWarnings("unused")
			JsonNode subscriptionsSupportLevel,
			@JsonProperty("summary")
			String summary,
			@JsonProperty("support_email")
			String supportEmail,
			@JsonProperty("version")
			String version,
			@JsonProperty("viewer_summary")
			String viewerSummary,
			@JsonProperty("views")
			ReleasedExtensionViews views,
			@JsonProperty("allowlisted_config_urls")
			String[] allowlistedConfigURLs,
			@JsonProperty("allowlisted_panel_urls")
			String[] allowlistedPanelURLs
	) {
		this.authorName = authorName;
		this.bitsEnabled = bitsEnabled;
		this.canBeInstalled = canBeInstalled;
		this.configLocation = configLocation;
		this.description = description;
		this.eulaTosURL = URI.create(eulaTosURL);
		this.hasChatSupport = hasChatSupport;
		this.iconURL = URI.create(iconURL);
		this.iconURLs = iconURLs;
		this.id = id;
		this.name = name;
		this.privacyPolicyURL = privacyPolicyURL;
		this.requestIdentityLink = requestIdentityLink;
		this.screenshotURLs = Stream.of(screenshotURLs).map(URI::create).collect(java.util.stream.Collectors.toList());
		this.state = ReleasedExtensionState.fromString(state);
		this.summary = summary;
		this.supportEmail = supportEmail;
		this.version = version;
		this.viewerSummary = viewerSummary;
		this.views = views;
		this.allowlistedConfigURLs = Stream.of(allowlistedConfigURLs).map(URI::create).collect(java.util.stream.Collectors.toList());
		this.allowlistedPanelURLs = Stream.of(allowlistedPanelURLs).map(URI::create).collect(java.util.stream.Collectors.toList());
	}

	@Override
	public String toString() {
		return "GetReleasedExtensionsResponse{" + "authorName='" + authorName + '\'' + ", bitsEnabled=" + bitsEnabled + ", canBeInstalled=" + canBeInstalled + ", configLocation='" + configLocation + '\'' + ", description='" + description + '\'' + ", eulaTosURL=" + eulaTosURL + ", hasChatSupport=" + hasChatSupport + ", iconURL=" + iconURL + ", iconURLs=" + iconURLs + ", id='" + id + '\'' + ", name='" + name + '\'' + ", privacyPolicyURL=" + privacyPolicyURL + ", requestIdentityLink=" + requestIdentityLink + ", screenshotURLs=" + screenshotURLs + ", state='" + state + '\'' + ", summary='" + summary + '\'' + ", supportEmail='" + supportEmail + '\'' + ", version='" + version + '\'' + ", viewerSummary='" + viewerSummary + '\'' + ", views=" + views + ", allowlistedConfigURLs=" + allowlistedConfigURLs + ", allowlistedPanelURLs=" + allowlistedPanelURLs + '}';
	}
}
package io.github.akjo03.util.apis.twitch.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.util.apis.twitch.data.util.ExtemsionTransactionProductType;
import io.github.akjo03.util.apis.twitch.data.util.ExtensionTransactionProductData;
import lombok.Getter;

import java.time.Instant;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetExtensionTransactionsResponse extends TwitchApiResponse<GetExtensionTransactionsResponse> {
	private final String id;
	private final Instant timestamp;
	private final String broadcasterID;
	private final String broadcasterLogin;
	private final String broadcasterName;
	private final String userID;
	private final String userLogin;
	private final String userName;
	private final ExtemsionTransactionProductType productType;
	private final ExtensionTransactionProductData productData;

	public GetExtensionTransactionsResponse(
			@JsonProperty("id")
			String id,
			@JsonProperty("timestamp")
			String timestamp,
			@JsonProperty("broadcaster_id")
			String broadcasterID,
			@JsonProperty("broadcaster_login")
			String broadcasterLogin,
			@JsonProperty("broadcaster_name")
			String broadcasterName,
			@JsonProperty("user_id")
			String userID,
			@JsonProperty("user_login")
			String userLogin,
			@JsonProperty("user_name")
			String userName,
			@JsonProperty("product_type")
			String productType,
			@JsonProperty("product_data")
			ExtensionTransactionProductData productData
	) {
		this.id = id;
		this.timestamp = Instant.parse(timestamp);
		this.broadcasterID = broadcasterID;
		this.broadcasterLogin = broadcasterLogin;
		this.broadcasterName = broadcasterName;
		this.userID = userID;
		this.userLogin = userLogin;
		this.userName = userName;
		this.productType = ExtemsionTransactionProductType.fromString(productType);
		this.productData = productData;
	}

	@Override
	public String toString() {
		return "GetExtensionTransactionsResponse{" + "id='" + id + '\'' + ", timestamp=" + timestamp + ", broadcasterID='" + broadcasterID + '\'' + ", broadcasterLogin='" + broadcasterLogin + '\'' + ", broadcasterName='" + broadcasterName + '\'' + ", userID='" + userID + '\'' + ", userLogin='" + userLogin + '\'' + ", userName='" + userName + '\'' + ", productType='" + productType + '\'' + ", productData=" + productData + '}';
	}
}
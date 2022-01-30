package io.github.akjo03.util.discord.auth;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@SuppressWarnings("ClassCanBeRecord")
public class DiscordAuth {
	@NotNull private final String clientID;
	@NotNull private final String clientSecret;
	@Nullable private final String botToken;

	public DiscordAuth(
			@NotNull String clientID,
			@NotNull String clientSecret,
			@Nullable String botToken
	) {
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.botToken = botToken;
	}

	@Override
	public String toString() {
		return "DiscordAuth{" + "clientID='" + clientID + '\'' + ", clientSecret='" + clientSecret + '\'' + ", botToken='" + botToken + '\'' + '}';
	}
}
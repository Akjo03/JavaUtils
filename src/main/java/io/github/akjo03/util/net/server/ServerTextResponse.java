package io.github.akjo03.util.net.server;


import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class ServerTextResponse extends ServerResponse {
	@Getter
	@NotNull private final String response;

	public ServerTextResponse(@NotNull String response) {
		this.response = response;
	}

	@Override
	public byte[] getBytes() {
		return response.getBytes();
	}
}
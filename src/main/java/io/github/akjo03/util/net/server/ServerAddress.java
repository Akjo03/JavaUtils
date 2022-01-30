package io.github.akjo03.util.net.server;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.util.Objects;

@Getter
@SuppressWarnings("unused")
public class ServerAddress {
	@Nullable private final String host;
	private final int port;

	public ServerAddress(int port) {
		this(null, port);
	}

	public ServerAddress(@Nullable String host, int port) {
		this.host = host;
		this.port = port;
	}

	public InetSocketAddress toSocketAddress() {
		if (host == null) {
			return new InetSocketAddress(port);
		} else {
			return new InetSocketAddress(host, port);
		}
	}

	@Override
	public String toString() {
		return "ServerAddress{" + "host='" + host + '\'' + ", port=" + port + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ServerAddress that = (ServerAddress) o;
		return port == that.port && Objects.equals(host, that.host);
	}

	@Override
	public int hashCode() {
		return Objects.hash(host, port);
	}
}
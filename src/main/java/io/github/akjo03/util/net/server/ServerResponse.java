package io.github.akjo03.util.net.server;

public abstract class ServerResponse {
	@SuppressWarnings("StaticInitializerReferencesSubClass")
	public static final ServerResponse UNSUPPORTED_METHOD = new ServerTextResponse("Unsupported Method");

	public abstract byte[] getBytes();
}
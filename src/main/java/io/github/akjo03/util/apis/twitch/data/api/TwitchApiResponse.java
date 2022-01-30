package io.github.akjo03.util.apis.twitch.data.api;

import io.github.akjo03.util.json.JsonParsable;
import lombok.Getter;

@SuppressWarnings("unused")
@Getter
public abstract class TwitchApiResponse<R extends TwitchApiResponse<R>> implements JsonParsable {}
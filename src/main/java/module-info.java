module utils {
	requires java.base;

	requires com.fasterxml.jackson.annotation;
	requires lombok;
	requires org.jetbrains.annotations;
	requires org.apache.commons.lang3;
	requires com.fasterxml.jackson.core;
	requires org.apache.commons.collections4;
	requires com.fasterxml.jackson.databind;
	requires com.google.gson;
	requires jdk.httpserver;
	requires com.fasterxml.jackson.datatype.jdk8;
	requires com.fasterxml.jackson.datatype.jsr310;
	requires net.dv8tion.jda;
	requires java.net.http;
	requires org.apache.commons.io;
	requires java.desktop;

	exports io.github.akjo03.util;
	exports io.github.akjo03.util.apis.twitch;
	exports io.github.akjo03.util.apis.twitch.data.util;
	exports io.github.akjo03.util.apis.twitch.data.api;
	exports io.github.akjo03.util.apis.twitch.data.auth;
	exports io.github.akjo03.util.discord;
	exports io.github.akjo03.util.discord.auth;
	exports io.github.akjo03.util.discord.checks;
	exports io.github.akjo03.util.discord.events;
	exports io.github.akjo03.util.discord.status;
	exports io.github.akjo03.util.logging.v2;
	exports io.github.akjo03.util.net.requests;
	exports io.github.akjo03.util.net.server;
	exports io.github.akjo03.util.array;
	exports io.github.akjo03.util.audio;
	exports io.github.akjo03.util.builder;
	exports io.github.akjo03.util.error;
	exports io.github.akjo03.util.json;
	exports io.github.akjo03.util.lang;
	exports io.github.akjo03.util.math;
	exports io.github.akjo03.util.math.unit;
	exports io.github.akjo03.util.math.unit.base;
	exports io.github.akjo03.util.math.unit.units.acceleration;
	exports io.github.akjo03.util.math.unit.units.area;
	exports io.github.akjo03.util.math.unit.units.length;
	exports io.github.akjo03.util.math.unit.units.mass;
	exports io.github.akjo03.util.math.unit.units.time;
	exports io.github.akjo03.util.math.unit.units.speed;
	exports io.github.akjo03.util.math.unit.units.volume;
	exports io.github.akjo03.util.math.unit.derived;
	exports io.github.akjo03.util.math.unit.derived.dimension;
	exports io.github.akjo03.util.restriction;
	exports io.github.akjo03.util.security;
}
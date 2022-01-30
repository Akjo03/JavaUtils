package io.github.akjo03.util.discord.events;

import lombok.Getter;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.application.ApplicationCommandCreateEvent;
import net.dv8tion.jda.api.events.application.ApplicationCommandDeleteEvent;
import net.dv8tion.jda.api.events.application.ApplicationCommandUpdateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEmoteEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.SelfUpdateAvatarEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateDiscriminatorEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateMFAEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateNameEvent;
import net.dv8tion.jda.api.events.stage.StageInstanceCreateEvent;
import net.dv8tion.jda.api.events.stage.StageInstanceDeleteEvent;
import net.dv8tion.jda.api.events.stage.update.StageInstanceUpdatePrivacyLevelEvent;
import net.dv8tion.jda.api.events.stage.update.StageInstanceUpdateTopicEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public enum EventType {
	DISCONNECT("DisconnectEvent", DisconnectEvent.class),
	EXCEPTION("ExceptionEvent", ExceptionEvent.class),
	READY("ReadyEvent", ReadyEvent.class),
	RESUMED("ResumedEvent", ResumedEvent.class),
	RECONNECTED("ReconnectedEvent", ReconnectedEvent.class),
	SHUTDOWN("ShutdownEvent", ShutdownEvent.class),
	STATUS_CHANGE("StatusChangeEvent", StatusChangeEvent.class),
	HTTP_REQUEST("HttpRequestEvent", HttpRequestEvent.class),
	GATEWAY_PING("GatewayPingEvent", GatewayPingEvent.class),
	UNAVAILABLE_GUILD_JOINED("UnavailableGuildJoinedEvent", UnavailableGuildJoinedEvent.class),
	UNAVAILABLE_GUILD_LEAVE("UnavailableGuildLeaveEvent", UnavailableGuildLeaveEvent.class),
	SELF_UPDATE_AVATAR("SelfUpdateAvatarEvent", SelfUpdateAvatarEvent.class),
	SELF_UPDATE_DISCRIMINATOR("SelfUpdateDiscriminatorEvent", SelfUpdateDiscriminatorEvent.class),
	SELF_UPDATE_MFA("SelfUpdateMFAEvent", SelfUpdateMFAEvent.class),
	SELF_UPDATE_NAME("SelfUpdateNameEvent", SelfUpdateNameEvent.class),
	USER_UPDATE_ACTIVITIES("UserUpdateActivitiesEvent", UserUpdateActivitiesEvent.class),
	USER_UPDATE_ONLINE_STATUS("UserUpdateOnlineStatusEvent", UserUpdateOnlineStatusEvent.class),
	USER_UPDATE_ACTIVITY_ORDER("UserUpdateActivityOrderEvent", UserUpdateActivityOrderEvent.class),
	USER_UPDATE_AVATAR("UserUpdateAvatarEvent", UserUpdateAvatarEvent.class),
	USER_UPDATE_DISCRIMINATOR("UserUpdateDiscriminatorEvent", UserUpdateDiscriminatorEvent.class),
	USER_UPDATE_NAME("UserUpdateNameEvent", UserUpdateNameEvent.class),
	USER_UPDATE_FLAGS("UserUpdateFlagsEvent", UserUpdateFlagsEvent.class),
	USER_ACTIVITY_START("UserActivityStartEvent", UserActivityStartEvent.class),
	USER_ACTIVITY_END("UserActivityEndEvent", UserActivityEndEvent.class),
	USER_TYPING("UserTypingEvent", UserTypingEvent.class),
	MESSAGE_BULK_DELETE("MessageBulkDeleteEvent", MessageBulkDeleteEvent.class),
	MESSAGE_DELETE("MessageDeleteEvent", MessageDeleteEvent.class),
	MESSAGE_EMBED("MessageEmbedEvent", MessageEmbedEvent.class),
	MESSAGE_RECEIVED("MessageReceivedEvent", MessageReceivedEvent.class),
	MESSAGE_UPDATE("MessageUpdateEvent", MessageUpdateEvent.class),
	MESSAGE_REACTION_ADD("MessageReactionAddEvent", MessageReactionAddEvent.class),
	MESSAGE_REACTION_REMOTE("MessageReactionRemoveEvent", MessageReactionRemoveEvent.class),
	PRIVATE_MESSAGE_DELETE("PrivateMessageDeleteEvent", PrivateMessageDeleteEvent.class),
	PRIVATE_MESSAGE_EMBED("PrivateMessageEmbedEvent", PrivateMessageEmbedEvent.class),
	PRIVATE_MESSAGE_RECEIVED("PrivateMessageReceivedEvent", PrivateMessageReceivedEvent.class),
	PRIVATE_MESSAGE_UPDATE("PrivateMessageUpdateEvent", PrivateMessageUpdateEvent.class),
	PRIVATE_MESSAGE_REACTION_ADD("PrivateMessageReactionAddEvent", PrivateMessageReactionAddEvent.class),
	PRIVATE_MESSAGE_REACTION_REMOVE("PrivateMessageReactionRemoveEvent", PrivateMessageReactionRemoveEvent.class),
	GUILD_READY("GuildReadyEvent", GuildReadyEvent.class),
	GUILD_AVAILABLE("GuildAvailableEvent", GuildAvailableEvent.class),
	GUILD_UNAVAILABLE("GuildUnavailableEvent", GuildUnavailableEvent.class),
	GUILD_TIMEOUT("GuildTimeoutEvent", GuildTimeoutEvent.class),
	GUILD_JOIN("GuildJoinEvent", GuildJoinEvent.class),
	GUILD_LEAVE("GuildLeaveEvent", GuildLeaveEvent.class),
	GUILD_BAN("GuildBanEvent", GuildBanEvent.class),
	GUILD_UNBAN("GuildUnbanEvent", GuildUnbanEvent.class),
	GUILD_INVITE_CREATE("GuildInviteCreateEvent", GuildInviteCreateEvent.class),
	GUILD_INVITE_DELETE("GuildInviteDeleteEvent", GuildInviteDeleteEvent.class),
	GUILD_MESSAGE_DELETE("GuildMessageDeleteEvent", GuildMessageDeleteEvent.class),
	GUILD_MESSAGE_EMBED("GuildMessageEmbedEvent", GuildMessageEmbedEvent.class),
	GUILD_MESSAGE_RECEIVED("GuildMessageReceivedEvent", GuildMessageReceivedEvent.class),
	GUILD_MESSAGE_UPDATE("GuildMessageUpdateEvent", GuildMessageUpdateEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE_ALL("GuildMessageReactionRemoveAllEvent", GuildMessageReactionRemoveAllEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE_EMOTE("GuildMessageReactionRemoveEmoteEvent", GuildMessageReactionRemoveEmoteEvent.class),
	GUILD_MESSAGE_REACTION_ADD("GuildMessageReactionAddEvent", GuildMessageReactionAddEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE("GuildMessageReactionRemoveEvent", GuildMessageReactionRemoveEvent.class),
	GUILD_UPDATE_AFK_CHANNEL("GuildUpdateAfkChannelEvent", GuildUpdateAfkChannelEvent.class),
	GUILD_UPDATE_AFK_TIMEOUT("GuildUpdateAfkTimeoutEvent", GuildUpdateAfkTimeoutEvent.class),
	GUILD_UPDATE_RULES_CHANNEL("GuildUpdateRulesChannelEvent", GuildUpdateRulesChannelEvent.class),
	GUILD_UPDATE_EXPLICIT_CONTENT_LEVEL("GuildUpdateExplicitContentLevelEvent", GuildUpdateExplicitContentLevelEvent.class),
	GUILD_UPDATE_FEATURES("GuildUpdateFeaturesEvent", GuildUpdateFeaturesEvent.class),
	GUILD_UPDATE_ICON("GuildUpdateIconEvent", GuildUpdateIconEvent.class),
	GUILD_UPDATE_MFA_LEVEL("GuildUpdateMFALevelEvent", GuildUpdateMFALevelEvent.class),
	GUILD_UPDATE_NAME("GuildUpdateNameEvent", GuildUpdateNameEvent.class),
	GUILD_UPDATE_NOTIFICATION_LEVEL("GuildUpdateNotificationLevelEvent", GuildUpdateNotificationLevelEvent.class),
	GUILD_UPDATE_NSFW_LEVEL("GuildUpdateNSFWLevelEvent", GuildUpdateNSFWLevelEvent.class),
	GUILD_UPDATE_OWNER("GuildUpdateOwnerEvent", GuildUpdateOwnerEvent.class),
	GUILD_UPDATE_LOCALE("GuildUpdateLocaleEvent", GuildUpdateLocaleEvent.class),
	GUILD_UPDATE_SPLASH("GuildUpdateSplashEvent", GuildUpdateSplashEvent.class),
	GUILD_UPDATE_SYSTEM_CHANNEL("GuildUpdateSystemChannelEvent", GuildUpdateSystemChannelEvent.class),
	GUILD_UPDATE_BANNER("GuildUpdateBannerEvent", GuildUpdateBannerEvent.class),
	GUILD_UPDATE_BOOST_COUNT("GuildUpdateBoostCountEvent", GuildUpdateBoostCountEvent.class),
	GUILD_UPDATE_BOOST_TIER("GuildUpdateBoostTierEvent", GuildUpdateBoostTierEvent.class),
	GUILD_UPDATE_DESCRIPTION("GuildUpdateDescriptionEvent", GuildUpdateDescriptionEvent.class),
	GUILD_UPDATE_MAX_MEMBERS("GuildUpdateMaxMembersEvent", GuildUpdateMaxMembersEvent.class),
	GUILD_UPDATE_MAX_PRESENCES("GuildUpdateMaxPresencesEvent", GuildUpdateMaxPresencesEvent.class),
	GUILD_UPDATE_VANITY_CODE("GuildUpdateVanityCodeEvent", GuildUpdateVanityCodeEvent.class),
	GUILD_UPDATE_VERIFICATION_LEVEL("GuildUpdateVerificationLevelEvent", GuildUpdateVerificationLevelEvent.class),
	GUILD_UPDATE_COMMUNITY_UPDATES_CHANNEL("GuildUpdateCommunityUpdatesChannelEvent", GuildUpdateCommunityUpdatesChannelEvent.class),
	GUILD_MEMBER_JOIN("GuildMemberJoinEvent", GuildMemberJoinEvent.class),
	GUILD_MEMBER_REMOVE("GuildMemberRemoveEvent", GuildMemberRemoveEvent.class),
	GUILD_MEMBER_ROLE_ADD("GuildMemberRoleAddEvent", GuildMemberRoleAddEvent.class),
	GUILD_MEMBER_ROLE_REMOVE("GuildMemberRoleRemoveEvent", GuildMemberRoleRemoveEvent.class),
	GUILD_MEMBER_UPDATE("GuildMemberUpdateEvent", GuildMemberUpdateEvent.class),
	GUILD_MEMBER_UPDATE_NICKNAME("GuildMemberUpdateNicknameEvent", GuildMemberUpdateNicknameEvent.class),
	GUILD_VOICE_DEAFEN("GuildVoiceDeafenEvent", GuildVoiceDeafenEvent.class),
	GUILD_VOICE_GUILD_DEAFEN("GuildVoiceGuildDeafenEvent", GuildVoiceGuildDeafenEvent.class),
	GUILD_VOICE_GUILD_MUTE("GuildVoiceGuildMuteEvent", GuildVoiceGuildMuteEvent.class),
	GUILD_VOICE_MUTE("GuildVoiceMuteEvent", GuildVoiceMuteEvent.class),
	GUILD_VOICE_SELF_DEAFEN("GuildVoiceSelfDeafenEvent", GuildVoiceSelfDeafenEvent.class),
	GUILD_VOICE_SELF_MUTE("GuildVoiceSelfMuteEvent", GuildVoiceSelfMuteEvent.class),
	GUILD_VOICE_STREAM("GuildVoiceStreamEvent", GuildVoiceStreamEvent.class),
	GUILD_VOICE_SUPPRESS("GuildVoiceSuppressEvent", GuildVoiceSuppressEvent.class),
	GUILD_VOICE_JOIN("GuildVoiceJoinEvent", GuildVoiceJoinEvent.class),
	GUILD_VOICE_LEAVE("GuildVoiceLeaveEvent", GuildVoiceLeaveEvent.class),
	GUILD_VOICE_MOVE("GuildVoiceMoveEvent", GuildVoiceMoveEvent.class),
	GUILD_VOICE_VIDEO("GuildVoiceVideoEvent", GuildVoiceVideoEvent.class),
	GUILD_VOICE_REQUEST_TO_SPEAK("GuildVoiceRequestToSpeakEvent", GuildVoiceRequestToSpeakEvent.class),
	TEXT_CHANNEL_CREATE("TextChannelCreateEvent", TextChannelCreateEvent.class),
	TEXT_CHANNEL_DELETE("TextChannelDeleteEvent", TextChannelDeleteEvent.class),
	TEXT_CHANNEL_UPDATE_NAME("TextChannelUpdateNameEvent", TextChannelUpdateNameEvent.class),
	TEXT_CHANNEL_UPDATE_NEWS("TextChannelUpdateNewsEvent", TextChannelUpdateNewsEvent.class),
	TEXT_CHANNEL_UPDATE_NSFW("TextChannelUpdateNSFWEvent", TextChannelUpdateNSFWEvent.class),
	TEXT_CHANNEL_UPDATE_PARENT("TextChannelUpdateParentEvent", TextChannelUpdateParentEvent.class),
	TEXT_CHANNEL_UPDATE_POSITION("TextChannelUpdatePositionEvent", TextChannelUpdatePositionEvent.class),
	TEXT_CHANNEL_UPDATE_SLOWMODE("TextChannelUpdateSlowmodeEvent", TextChannelUpdateSlowmodeEvent.class),
	TEXT_CHANNEL_UPDATE_TOPIC("TextChannelUpdateTopicEvent", TextChannelUpdateTopicEvent.class),
	VOICE_CHANNEL_CREATE("VoiceChannelCreateEvent", VoiceChannelCreateEvent.class),
	VOICE_CHANNEL_DELETE("VoiceChannelDeleteEvent", VoiceChannelDeleteEvent.class),
	VOICE_CHANNEL_UPDATE_BITRATE("VoiceChannelUpdateBitrateEvent", VoiceChannelUpdateBitrateEvent.class),
	VOICE_CHANNEL_UPDATE_NAME("VoiceChannelUpdateNameEvent", VoiceChannelUpdateNameEvent.class),
	VOICE_CHANNEL_UPDATE_PARENT("VoiceChannelUpdateParentEvent", VoiceChannelUpdateParentEvent.class),
	VOICE_CHANNEL_UPDATE_POSITION("VoiceChannelUpdatePositionEvent", VoiceChannelUpdatePositionEvent.class),
	VOICE_CHANNEL_UPDATE_REGION("VoiceChannelUpdateRegionEvent", VoiceChannelUpdateRegionEvent.class),
	VOICE_CHANNEL_UPDATE_USER_LIMIT("VoiceChannelUpdateUserLimitEvent", VoiceChannelUpdateUserLimitEvent.class),
	STAGE_INSTANCE_CREATE("StageInstanceCreateEvent", StageInstanceCreateEvent.class),
	STAGE_INSTANCE_DELETE("StageInstanceDeleteEvent", StageInstanceDeleteEvent.class),
	STAGE_INSTANCE_UPDATE_PRIVACY_LEVEL("StageInstanceUpdatePrivacyLevelEvent", StageInstanceUpdatePrivacyLevelEvent.class),
	STAGE_INSTANCE_UPDATE_TOPIC("StageInstanceUpdateTopicEvent", StageInstanceUpdateTopicEvent.class),
	CATEGORY_CREATE("CategoryCreateEvent", CategoryCreateEvent.class),
	CATEGORY_DELETE("CategoryDeleteEvent", CategoryDeleteEvent.class),
	CATEGORY_UPDATE_NAME("CategoryUpdateNameEvent", CategoryUpdateNameEvent.class),
	CATEGORY_UPDATE_POSITION("CategoryUpdatePositionEvent", CategoryUpdatePositionEvent.class),
	STORE_CHANNEL_CREATE("StoreChannelCreateEvent", StoreChannelCreateEvent.class),
	STORE_CHANNEL_DELETE("StoreChannelDeleteEvent", StoreChannelDeleteEvent.class),
	STORE_CHANNEL_UPDATE_POSITION("StoreChannelUpdatePositionEvent", StoreChannelUpdatePositionEvent.class),
	STORE_CHANNEL_UPDATE_NAME("StoreChannelUpdateNameEvent", StoreChannelUpdateNameEvent.class),
	ROLE_CREATE("RoleCreateEvent", RoleCreateEvent.class),
	ROLE_DELETE("RoleDeleteEvent", RoleDeleteEvent.class),
	ROLE_UPDATE_COLOR("RoleUpdateColorEvent", RoleUpdateColorEvent.class),
	ROLE_UPDATE_ICON("RoleUpdateIconEvent", RoleUpdateIconEvent.class),
	ROLE_UPDATE_HOISTED("RoleUpdateHoistedEvent", RoleUpdateHoistedEvent.class),
	ROLE_UPDATE_MENTIONABLE("RoleUpdateMentionableEvent", RoleUpdateMentionableEvent.class),
	ROLE_UPDATE_NAME("RoleUpdateNameEvent", RoleUpdateNameEvent.class),
	ROLE_UPDATE_PERMISSIONS("RoleUpdatePermissionsEvent", RoleUpdatePermissionsEvent.class),
	ROLE_UPDATE_POSITION("RoleUpdatePositionEvent", RoleUpdatePositionEvent.class),
	EMOTE_ADDED("EmoteAddedEvent", EmoteAddedEvent.class),
	EMOTE_REMOVED("EmoteRemovedEvent", EmoteRemovedEvent.class),
	EMOTE_UPDATE_NAME("EmoteUpdateNameEvent", EmoteUpdateNameEvent.class),
	EMOTE_UPDATE_ROLES("EmoteUpdateRolesEvent", EmoteUpdateRolesEvent.class),
	APPLICATION_COMMAND_CREATE("ApplicationCommandCreateEvent", ApplicationCommandCreateEvent.class),
	APPLICATION_COMMAND_DELETE("ApplicationCommandDeleteEvent", ApplicationCommandDeleteEvent.class),
	APPLICATION_COMMAND_UPDATE("ApplicationCommandUpdateEvent", ApplicationCommandUpdateEvent.class),
	PERMISSION_OVERRIDE_CREATE("PermissionOverrideCreateEvent", PermissionOverrideCreateEvent.class),
	PERMISSION_OVERRIDE_DELETE("PermissionOverrideDeleteEvent", PermissionOverrideDeleteEvent.class),
	PERMISSION_OVERRIDE_UPDATE("PermissionOverrideUpdateEvent", PermissionOverrideUpdateEvent.class),
	BUTTON_CLICK("ButtonClickEvent", ButtonClickEvent.class),
	SELECTION_MENU("SelectionMenuEvent", SelectionMenuEvent.class),
	SLASH_COMMAND("SlashCommandEvent", SlashCommandEvent.class);


	@Getter
	private final String name;
	@Getter
	private final Class<? extends GenericEvent> eventClass;

	EventType(String name, Class<? extends GenericEvent> eventClass) {
		this.name = name;
		this.eventClass = eventClass;
	}

	public static EventType getByName(@NotNull String name) {
		return Arrays.stream(values())
				.filter(eventType -> eventType.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

	public static EventType getByClass(@NotNull Class<? extends GenericEvent> eventClass) {
		return Arrays.stream(values())
				.filter(eventType -> eventType.getEventClass().equals(eventClass))
				.findFirst()
				.orElse(null);
	}

	public static EventType getByEvent(@NotNull GenericEvent event) {
		return Arrays.stream(values())
				.filter(eventType -> eventType.getEventClass().equals(event.getClass()))
				.findFirst()
				.orElse(null);
	}

	public @NotNull String toString() {
		return "EventType(" + this.name + ")";
	}
}
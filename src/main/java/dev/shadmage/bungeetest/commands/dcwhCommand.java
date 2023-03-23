package dev.shadmage.bungeetest.commands;

import dev.shadmage.bungeetest.model.DiscordWebhook;
import org.mineacademy.bfo.Common;
import org.mineacademy.bfo.annotation.AutoRegister;
import org.mineacademy.bfo.command.SimpleCommand;

@AutoRegister
public final class dcwhCommand extends SimpleCommand {
	public dcwhCommand() {
		super("dcwh");
	}

	@Override
	protected void onCommand() {
		if (isPlayer()) {
			tell("Sorry that command is only available to console");
			return;
		}


		try {
			Common.log("BungeeTest >> Trying to post to Discord");
			DiscordWebhook discordWebhook = new DiscordWebhook();
			discordWebhook.newPlayers = 1;
			discordWebhook.peakPlayers = 15;
			discordWebhook.totalUniquePlayers = 50;
			discordWebhook.start();
			Common.log("BungeeTest >> Posted to discord");
		} catch (Exception ex) {
			Common.log("BungeeTest >> Unable to post to discord");
			ex.printStackTrace();
		}

	}
}


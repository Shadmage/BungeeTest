package dev.shadmage.bungeetest.commands;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.mineacademy.bfo.Common;
import org.mineacademy.bfo.command.SimpleCommand;
import org.mineacademy.bfo.remain.Remain;

public class RankupCommand extends SimpleCommand {

	protected RankupCommand() {
		super("rankup");
	}

	@Override
	protected void onCommand() {
		checkConsole(); //prevent console access - only players can run this command

		ProxiedPlayer player = getPlayer();

		try {
			Remain.sendActionBar(player, "Sorry you are unable to rankup at the moment");
		} catch (Exception ex) {
			Common.log("BungeeTest >> Player " + player.getName() + " tried to rankup but we ran into an error:");
			ex.printStackTrace();
		}

	}
}

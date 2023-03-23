package dev.shadmage.bungeetest.commands;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.mineacademy.bfo.Common;
import org.mineacademy.bfo.annotation.AutoRegister;
import org.mineacademy.bfo.command.SimpleCommand;
import org.mineacademy.bfo.model.BukkitRunnable;
import org.mineacademy.bfo.model.SimpleScoreboard;
import org.mineacademy.bfo.model.Variables;
import org.mineacademy.bfo.remain.Remain;

import java.util.List;

@AutoRegister
public final class FancyCommand extends SimpleCommand {
	protected FancyCommand() {
		super("ddbungee"); // the command that is types by a player

		setMinArguments(1);
		setUsage("<title/actionbar/tablist/scoreboard>");


	}

	@Override
	protected void onCommand() {
		checkConsole();

		String param = args[0].toLowerCase();

		ProxiedPlayer player = getPlayer();
		ProxyServer server = ProxyServer.getInstance();

		if ("title".equals(param)) {
			for (ProxiedPlayer online : Remain.getOnlinePlayers())
				Remain.sendTitle(online, "&aHello &e{player_name}", "&a&oWelcome to Dirty Dog!");
		}

		if ("actionbar".equals(param)) {
			Remain.sendActionBar(player, "&aHello &e{player_name}, &a&oWelcome to Dirty Dog!");
		}

		if ("tablist".equals(param)) {
			Remain.sendTablist(player, "&aHello &e" + player.getName(), "\n&aVisit &edirtydoggaming.co.za\n&aCurrent Server: &e{server_name}");
		}

		if ("scoreboard".equals(param)) {
			SimpleScoreboard scoreboard = new SimpleScoreboard() {
				@Override
				protected String replaceVariables(ProxiedPlayer player, String text) {
					return Variables.replace(text, player);
				}
			};
			scoreboard.setTitle("Dirty Dog Gaming");
			scoreboard.setLines("line 1", "line 2", "line 3", "line 4", "server: {server_name}");
			scoreboard.send(player);

			Common.runTimerAsync(10, new BukkitRunnable() {
				@Override
				public void run() {
					if (!player.isConnected()) {
						cancel();
						return;
					}
					scoreboard.send(player);
				}
			});

		}

	}

	@Override
	protected List<String> tabComplete() {
		return (args.length == 1) ? completeLastWord("title", "actionbar", "tablist", "scoreboard") : NO_COMPLETE;
	}
}

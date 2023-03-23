package dev.shadmage.bungeetest;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.mineacademy.bfo.Common;
import org.mineacademy.bfo.model.Variables;
import org.mineacademy.bfo.plugin.SimplePlugin;

import java.util.Objects;
import java.util.function.Function;

public class BungeeTestPlugin extends SimplePlugin {

	private static BungeeTestPlugin instance;


	@Override
	protected void onPluginStart() {
		Common.log("Shad Test Plugin has been loaded....");

		Variables.addVariable("server_name", new Function<CommandSender, String>() {
			@Override
			public String apply(CommandSender sender) {

				return sender instanceof ProxiedPlayer ? ((ProxiedPlayer) sender).getServer().getInfo().getName() : "";
			}
		});
	}

	public static BungeeTestPlugin getInstance() {
		if (instance == null) {
			try {
				instance = (BungeeTestPlugin) ProxyServer.getInstance().getPluginManager().getPlugin("BungeeTest");
			} catch (final IllegalStateException ex) {
				instance = null;
			}
		}
		Objects.requireNonNull(instance, "Cannot get a new instance! Have you reloaded?");
		return instance;
	}
}

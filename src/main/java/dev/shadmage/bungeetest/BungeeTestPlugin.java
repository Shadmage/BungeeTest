package dev.shadmage.bungeetest;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.mineacademy.bfo.Common;
import org.mineacademy.bfo.model.Variables;
import org.mineacademy.bfo.plugin.SimplePlugin;

import java.util.function.Function;

public class BungeeTestPlugin extends SimplePlugin {


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
}

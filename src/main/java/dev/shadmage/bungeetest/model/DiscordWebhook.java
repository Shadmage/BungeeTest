package dev.shadmage.bungeetest.model;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.URL;


public final class DiscordWebhook extends Thread {
	public Integer totalUniquePlayers;
	public Integer peakPlayers;
	public Integer newPlayers;


	public DiscordWebhook() {
		this.totalUniquePlayers = 0;
		this.peakPlayers = 0;
		this.newPlayers = 0;

	}


	@Override
	public synchronized void start() {
		///////////////////////////////////////////////
		String tokenWebhook = "https://discord.com/api/webhooks/1088574188899549284/Tj5w0Mi--tcG27EyQzraoEkAzsXLGSFGhHy7U0Je_o2_A_RyP83UqC1Gr_cQ34MW099M";
		String linkEmoji = "<:vote_yes:911233428010192916>";
		String votesChannelID = "1072845516368515163";
		///////////////////////////////////////////////
		String jsonBrut = "";
		jsonBrut = "{"
				+ "\"content\": null,"
				+ "\"embeds\": [{"
				+ "\"title\": \"" + "Daily Activity Update:" + "\","
				+ "\"description\": \"" + "*What's been happening on the Dirty Dog Minecraft Servers in the last 24 hours:*" + "\","
				+ "\"color\": 15258703,"
				+ "\"fields\": ["
				+ "{"
				+ "\"name\": \"Active Players\","
				+ "\"value\": \"```" + totalUniquePlayers + "```\","
				+ "\"inline\": true"
				+ "},"
				+ "{"
				+ "\"name\": \"Peak Online Players\","
				+ "\"value\": \"```" + peakPlayers + "```\","
				+ "\"inline\": true"
				+ "},"
				+ "{"
				+ "\"name\": \"New Players\","
				+ "\"value\": \"```" + newPlayers + "```\","
				+ "\"inline\": true"
				+ "},"
				+ "{"
				+ "\"name\": \"Useful links\","

				+ "\"value\": \"" + linkEmoji + " Remember you can unlock awesome rewards ingame by voting... You can use the links in <#" + votesChannelID + "> or from our [Website](https://dirtydoggaming.co.za/vote.php)"
				+ "\\n\\n" + linkEmoji + " View [Top Playtime Rankings](https://dirtydoggaming.co.za/playtime.php)"
				+ "\\n\\n" + linkEmoji + " View [Top Voting Rankings](https://dirtydoggaming.co.za/vote.php#voterankings)"
				+ "\","
				+ "\"inline\": false"
				+ "}"
				+ "]"
				+ "}"
				+ "],"
				+ "\"username\": \"Dirty Dog Gaming\","
				+ "\"avatar_url\": \"https://www.dirtydoggaming.co.za/assets/img/ddglogo.png\""
				+ "}";
		try {
			URL url = new URL(tokenWebhook);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.addRequestProperty("Content-Type", "application/json");
			con.addRequestProperty("User-Agent", "Dirty_Dog_Gaming_Minecraft_Server_");
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			OutputStream stream = con.getOutputStream();
			stream.write(jsonBrut.getBytes());
			stream.flush();
			stream.close();
			con.getInputStream().close();
			con.disconnect();
			System.out.println("Sent message to Discord Webhook");
		} catch (Exception e) {
			System.out.println("Unable to send message to Discord Webhook");
			e.printStackTrace();
		}

	}

}

package me.aberdeener.helpcommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HelpCommand extends JavaPlugin {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		//base command
		if (commandLabel.equalsIgnoreCase("help")) {

			//console sender check
			if (! (sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "[Help] Please execute from in-game!");
				return true;
			}

			//first permission check (help)
			Player p = (Player) sender;
			if (!p.hasPermission("helpcommand.use")) {
				p.sendMessage(ChatColor.DARK_RED + "Uh oh! You don't have permission!");
			} else {

				//display all commands + syntax
				if (args.length == 0) {
					sender.sendMessage(ChatColor.DARK_GREEN + "--== [Help] ==--");
					sender.sendMessage(" ");
					sender.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.RED + "/help <plugin>");
					sender.sendMessage(ChatColor.GOLD + "Available Plugins:");
					sender.sendMessage(ChatColor.DARK_GREEN + "Essentials, Factions, Staff");
					return true;
				}
				
				else if (args[0].equalsIgnoreCase("essentials")) {
						sender.sendMessage(ChatColor.DARK_GREEN + "--== [Help] ==--");
						sender.sendMessage(" ");
						sender.sendMessage(ChatColor.GOLD + "Essentials Commands:");
						sender.sendMessage(ChatColor.YELLOW + "/tpa - Teleport to another player.");

						return true;
				}
				
				else if (args[0].equalsIgnoreCase("factions")) {
						sender.sendMessage(ChatColor.DARK_GREEN + "--== [Help] ==--");
						sender.sendMessage(" ");
						sender.sendMessage(ChatColor.GOLD + "Factions Commands:");
						sender.sendMessage(ChatColor.YELLOW + "/f join - Join a Faction.");
						sender.sendMessage(ChatColor.YELLOW + "/f home - Go to your Factions home.");

						return true;
				}
				
				else if (args[0].equalsIgnoreCase("staff")) {
					if (!p.hasPermission("helpcommand.staff")) {
						p.sendMessage(ChatColor.DARK_RED + "Hey! You're not staff!");
					} else {
					sender.sendMessage(ChatColor.DARK_GREEN + "--== [Help] ==--");
					sender.sendMessage(" ");
					sender.sendMessage(ChatColor.GOLD + "Staff Commands:");
					sender.sendMessage(ChatColor.YELLOW + "/tag - Tag a player.");
					sender.sendMessage(ChatColor.YELLOW + "/warn - Warn a player.");
					return true;
			}
				}
				else p.sendMessage(ChatColor.DARK_RED + "Invalid Argument! Correct usage: " + ChatColor.RED + "/help <plugin>");
				return true;
			}
		}

		return true;
	}
}
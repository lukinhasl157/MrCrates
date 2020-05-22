package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.mrboolean.crates.Crates;
import me.mrboolean.crates.Main;

public class GiveCrates extends Crates implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		final String prefix = ChatColor.translateAlternateColorCodes('&', Main.getPlugin(Main.class).getConfig().getString("prefix"));
		
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			
			if (!player.hasPermission("MrCrates.admin")) {
				player.sendMessage(prefix + ChatColor.GRAY + " Voc� n�o tem permiss�o para executar este comando. ");
			} else if (args.length < 3) {
				player.sendMessage(prefix + ChatColor.GRAY + " Digite " + ChatColor.DARK_PURPLE + "/givecrate <player> <crate> <amount>");
			} else {
				giveCrates(args, prefix, sender);
			}
		} else if (!(sender instanceof Player)) {
			if (args.length < 3) {
				sender.sendMessage(prefix + ChatColor.GRAY + " Digite " + ChatColor.DARK_PURPLE + "/givecrate <player> <crate> <amount>");
			} else {
				giveCrates(args, prefix, sender);
			}
		}
		return false;
	}
	
	static void giveCrates(String[] args, String prefix, CommandSender sender) {
		final Player target = Bukkit.getPlayer(args[0]);
		
		if (target == null) {
			sender.sendMessage(prefix + ChatColor.GRAY + " Este jogador n�o foi encontrado.");
		} else if (!args[2].matches("^[0-9]*$") || Integer.parseInt(args[2]) > 64 || Integer.parseInt(args[2]) <= 0) {
			sender.sendMessage(prefix + ChatColor.GRAY + " A quantidade precisa ser um n�mero entre " + ChatColor.DARK_PURPLE + "1 e 64");
		} else {
			if (args[1].equalsIgnoreCase("legendary") || args[1].equalsIgnoreCase("lendaria")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "�6�lCAIXA LEND�RIA", "�fBot�o �6direito �fabre a caixa.", 
					"�fBot�o �6esquerdo �fmostra o", "�fconte�do da caixa."));
			} else if (args[1].equalsIgnoreCase("epic") || args[1].equalsIgnoreCase("epica")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "�5�lCAIXA �PICA", "�fBot�o �5direito �fabre a caixa.", 
					"�fBot�o �5esquerdo �fmostra o", "�fconte�do da caixa."));
			} else if (args[1].equalsIgnoreCase("rare") || args[1].equalsIgnoreCase("rara")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "�9�lCAIXA RARA", "�fBot�o �9direito �fabre a caixa.", 
					"�fBot�o �9esquerdo �fmostra o", "�fconte�do da caixa."));
			}
		}
	}
	
	static void giveCrate(Player player, ItemStack item) {
		if (player.getInventory().firstEmpty() == - 1) {
			player.getWorld().dropItem(player.getLocation(), item);
		} else {
			player.getInventory().addItem(item);
		}
	}
}

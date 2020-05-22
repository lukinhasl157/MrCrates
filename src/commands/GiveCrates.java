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
				player.sendMessage(prefix + ChatColor.GRAY + " Você não tem permissão para executar este comando. ");
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
			sender.sendMessage(prefix + ChatColor.GRAY + " Este jogador não foi encontrado.");
		} else if (!args[2].matches("^[0-9]*$") || Integer.parseInt(args[2]) > 64 || Integer.parseInt(args[2]) <= 0) {
			sender.sendMessage(prefix + ChatColor.GRAY + " A quantidade precisa ser um número entre " + ChatColor.DARK_PURPLE + "1 e 64");
		} else {
			if (args[1].equalsIgnoreCase("legendary") || args[1].equalsIgnoreCase("lendaria")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "§6§lCAIXA LENDÁRIA", "§fBotão §6direito §fabre a caixa.", 
					"§fBotão §6esquerdo §fmostra o", "§fconteúdo da caixa."));
			} else if (args[1].equalsIgnoreCase("epic") || args[1].equalsIgnoreCase("epica")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "§5§lCAIXA ÉPICA", "§fBotão §5direito §fabre a caixa.", 
					"§fBotão §5esquerdo §fmostra o", "§fconteúdo da caixa."));
			} else if (args[1].equalsIgnoreCase("rare") || args[1].equalsIgnoreCase("rara")) {
				giveCrate(target, createCrate((byte) Integer.parseInt(args[2]), "§9§lCAIXA RARA", "§fBotão §9direito §fabre a caixa.", 
					"§fBotão §9esquerdo §fmostra o", "§fconteúdo da caixa."));
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

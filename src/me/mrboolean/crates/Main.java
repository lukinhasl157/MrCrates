package me.mrboolean.crates;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import commands.GiveCrates;
import listeners.BlockBreak;
import listeners.BlockPlace;
import listeners.PlayerInteractCrate;

public class Main extends JavaPlugin {
	public static final Map<String, Inventory> inventories = new HashMap<String, Inventory>();
	private final ConsoleCommandSender console = Bukkit.getConsoleSender();
	private static WorldGuardPlugin wg;
	public static WorldEditPlugin we;

	public void onEnable() {
		saveDefaultConfig();
		hookWorldEdit();
		hookWorldGuard();
		getServer().getPluginManager().registerEvents(new BlockBreak(), this);
		getServer().getPluginManager().registerEvents(new PlayerInteractCrate(), this);
		getServer().getPluginManager().registerEvents(new BlockPlace(), this);
		getCommand("givecrate").setExecutor(new GiveCrates());
		console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " Plugin ativado com sucesso! Desenvolvido por MrBoolean, Discord: Lukinhas#7832");
	}
	
	public void hookWorldGuard() {
		if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard") == null) {
			console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " O plugin WorldGuard nao foi encontrado, desativando plugin...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		} else {
      wg = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
      console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " Plugin conectado com o WorldGuard");
		}
	}
	
	public void hookWorldEdit() {
		if (Bukkit.getServer().getPluginManager().getPlugin("WorldEdit") == null) {
			console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " O plugin WorldEdit nao foi encontrado, desativando plugin...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		} else {
      we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
      console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " Plugin conectado com o WorldEdit");
		}
	}
	
	public void onDisable() {
		console.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix")) + ChatColor.LIGHT_PURPLE + " Plugin desativado com sucesso! Desenvolvido por MrBoolean, Discord: Lukinhas#7832");
	}
	
	public static WorldGuardPlugin getWg() {
		return wg;
	}
}

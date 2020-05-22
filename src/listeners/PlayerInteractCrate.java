package listeners;

import java.util.List;
import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import me.mrboolean.crates.Items;
import me.mrboolean.crates.Crates;
import org.bukkit.ChatColor;

public class PlayerInteractCrate extends Crates implements Listener {
	@EventHandler
	void playerInteract(PlayerInteractEvent e) {
		final Player player = e.getPlayer();
		final ItemStack item = player.getItemInHand();
		
		if (item.getType() == Material.ENDER_CHEST && e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if (item.isSimilar(legendaryCrate)) {
				giveItem(player, Items.legendary, Color.ORANGE, ChatColor.GOLD);
			} else if (item.isSimilar(epicCrate)) {
				giveItem(player, Items.epic, Color.PURPLE, ChatColor.DARK_PURPLE);
			} else if (item.isSimilar(rareCrate)) {
				giveItem(player, Items.rare, Color.BLUE, ChatColor.AQUA);
			}
		}
	}
	
	static void giveItem(Player player, List<ItemStack> items, Color fireworkColor, ChatColor stringColor) {
		removeCrate(player);
    
		final ItemStack randomItem = items.get((byte) new Random().nextInt(items.size()));
		final String itemName = randomItem.getItemMeta().getDisplayName() == null ?
			randomItem.getType().toString() : randomItem.getItemMeta().getDisplayName();
		
		if (player.getInventory().firstEmpty() == - 1) {
			player.getWorld().dropItem(player.getLocation(), randomItem);
		} else {
			player.getInventory().addItem(randomItem);
		}
		spawnFireworks(player.getLocation(), fireworkColor);
		sendTitle(player, itemName);
	}
	
	@SuppressWarnings("deprecation")
	static void sendTitle(Player player, String itemName) {
		player.sendTitle(ChatColor.BOLD + "VOCÊ GANHOU", itemName);
	}
	
	static void removeCrate(Player player) {
		if (player.getItemInHand().getAmount() == 1) {
			player.setItemInHand(null);
		} else {
			player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
		}
	}
	
  static void spawnFireworks(Location location, Color color) {
    final Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
    final FireworkMeta fwm = fw.getFireworkMeta();
   
    fwm.setPower(1);
    fwm.addEffect(FireworkEffect.builder().withColor(color).flicker(true).build());
   
    fw.setFireworkMeta(fwm);
    fw.detonate();
   
    final Firework fw2 = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
    fw2.setFireworkMeta(fwm);
  }
}

package listeners;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import io.netty.util.internal.ThreadLocalRandom;
import me.mrboolean.crates.Crates;
import me.mrboolean.crates.Main;

public class BlockBreak extends Crates implements Listener {
	@EventHandler
	void blockBreak(BlockBreakEvent e) {
		final Block block = e.getBlock();
		final Player player = e.getPlayer();
		final List<String> worlds = Main.getPlugin(Main.class).getConfig().getStringList("mundos");
		
		if (player.getGameMode().equals(GameMode.SURVIVAL) && block.getType().toString().endsWith("ORE")) {
			if (!worlds.contains(block.getWorld().getName())) {
				if (checkBlockInSafeArea(block)) {
					return;
				} else {
					String random = "" + ThreadLocalRandom.current().nextFloat();
					if (random.contains("0.0035")) {
						giveCrate(player, "§9§lCAIXAS", "§7Você ganhou uma caixa §9§lRARA", Crates.rareCrate);
					} else if (random.contains("0.0026")) {
						giveCrate(player, "§5§lCAIXAS", "§7Você ganhou uma caixa §5§lÉPICA", Crates.epicCrate);
					} else if (random.contains("0.0017")) {
						giveCrate(player, "§6§lCAIAS", "§7Você ganhou uma caixa §6§lLENDÁRIA", Crates.legendaryCrate);
					}
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	static void giveCrate(Player player, String title, String subTitle, ItemStack crate) {
		if (player.getInventory().firstEmpty() == - 1) {
			player.getWorld().dropItem(player.getLocation(), crate);
		} else {
			player.getInventory().addItem(crate);
		}
		player.sendTitle(title, subTitle);
	}
	
	static boolean checkBlockInSafeArea(Block block) {
		for (ProtectedRegion region : Main.getWg().getRegionManager(block.getWorld()).getApplicableRegions(block.getLocation())) {
			if (region.getFlags().size() > 0 && region.getFlag(DefaultFlag.BLOCK_BREAK) == State.DENY) {
				return true;
			}
		}
		return false;
	}
}

package listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import me.mrboolean.crates.Crates;

public class BlockPlace extends Crates implements Listener {
	@EventHandler
	void blockPlace(BlockPlaceEvent e) {
		ItemStack item = e.getPlayer().getItemInHand();
		
		if (item.getType() == Material.ENDER_CHEST) {
			if (item.isSimilar(legendaryCrate) || item.isSimilar(epicCrate) || item.isSimilar(rareCrate)) {
				e.setBuild(false);
			}
		}
	}
}

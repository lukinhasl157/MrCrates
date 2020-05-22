package me.mrboolean.crates;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Crates {
	public static final ItemStack legendaryCrate = createCrate((byte) 1, "�6�lCAIXA LEND�RIA", "�fBot�o �6direito �fabre a caixa.", "�fBot�o �6esquerdo �fmostra o", "�fconte�do da caixa.");
	public static final ItemStack epicCrate = createCrate((byte) 1, "�5�lCAIXA �PICA", "�fBot�o �5direito �fabre a caixa.", "�fBot�o �5esquerdo �fmostra o", "�fconte�do da caixa.");
	public static final ItemStack rareCrate = createCrate((byte) 1, "�9�lCAIXA RARA", "�fBot�o �9direito �fabre a caixa.", "�fBot�o �9esquerdo �fmostra o", "�fconte�do da caixa.");
			
	public static ItemStack createCrate(byte amount, String name, String... lores) {
		final ItemStack item = new ItemStack(Material.ENDER_CHEST, amount);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(Arrays.asList(lores));
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		return item;
	}
}

package me.mrboolean.crates;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Crates {
	public static final ItemStack legendaryCrate = createCrate((byte) 1, "§6§lCAIXA LENDÁRIA", "§fBotão §6direito §fabre a caixa.", "§fBotão §6esquerdo §fmostra o", "§fconteúdo da caixa.");
	public static final ItemStack epicCrate = createCrate((byte) 1, "§5§lCAIXA ÉPICA", "§fBotão §5direito §fabre a caixa.", "§fBotão §5esquerdo §fmostra o", "§fconteúdo da caixa.");
	public static final ItemStack rareCrate = createCrate((byte) 1, "§9§lCAIXA RARA", "§fBotão §9direito §fabre a caixa.", "§fBotão §9esquerdo §fmostra o", "§fconteúdo da caixa.");
			
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

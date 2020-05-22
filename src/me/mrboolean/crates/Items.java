package me.mrboolean.crates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Items {
	public static final List<ItemStack> legendary = Arrays.asList(
		createItemWithEnchantment(55, "§6§lESPADA LENDÁRIA", Material.DIAMOND_SWORD, 
			Enchantment.DAMAGE_ALL, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS), 
		createItemWithEnchantment(55, "§6§lMACHADO LENDÁRIO", Material.DIAMOND_AXE,
			Enchantment.DAMAGE_ALL, Enchantment.DIG_SPEED, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS),
		createItemWithEnchantment(55, "§6§lPICARETA LENDÁRIA", Material.DIAMOND_PICKAXE, 
			Enchantment.DURABILITY, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.DIG_SPEED),
		createItemWithEnchantment(55, "§6§lARMADURA LENDÁRIA", Material.DIAMOND_HELMET, 
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(55, "§6§lARMADURA LENDÁRIA", Material.DIAMOND_CHESTPLATE,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(55, "§6§lARMADURA LENDÁRIA", Material.DIAMOND_LEGGINGS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(55, "§6§lARMADURA LENDÁRIA", Material.DIAMOND_BOOTS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY),
		createItem("§6§lMAÇÃS DOURADAS", Material.GOLDEN_APPLE, (byte) 64),
		createItem("§6§lBLOCOS DE DIAMANTE", Material.DIAMOND_BLOCK, (byte) 64),
		createItem("§6§lBLOCOS DE OURO", Material.GOLD_BLOCK, (byte) 64),
		createItem("§6§lBLOCOS DE FERRO", Material.IRON_BLOCK, (byte) 64),
		createItem("§6§lBLOCOS DE ESMERALDA", Material.EMERALD_BLOCK, (byte) 64),
		createItem("§6§lBLOCOS DE SLIME", Material.SLIME_BLOCK, (byte) 64),
		createPotion("§6§lPOÇÃO LENDÁRIA", "§5Força III §f(2 minutos)", "§9Velocidade III §f(2 minutos)")
	);
	
	public static final List<ItemStack> epic = Arrays.asList(
		createItemWithEnchantment(50, "§5§lESPADA ÉPICA", Material.DIAMOND_SWORD, 
			Enchantment.DAMAGE_ALL, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS), 
		createItemWithEnchantment(50, "§5§lMACHADO ÉPICO", Material.DIAMOND_AXE,
			Enchantment.DAMAGE_ALL, Enchantment.DIG_SPEED, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS),
		createItemWithEnchantment(50, "§5§lPICARETA ÉPICA", Material.DIAMOND_PICKAXE, 
			Enchantment.DURABILITY, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.DIG_SPEED),
		createItemWithEnchantment(50, "§5§lARMADURA ÉPICA", Material.DIAMOND_HELMET, 
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(50, "§5§lARMADURA ÉPICA", Material.DIAMOND_CHESTPLATE,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(50, "§5§lARMADURA ÉPICA", Material.DIAMOND_LEGGINGS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(50, "§5§lARMADURA ÉPICA", Material.DIAMOND_BOOTS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY),
		createItem("§5§lMAÇÃS DOURADAS", Material.GOLDEN_APPLE, (byte) 64),
		createItem("§5§lBLOCOS DE DIAMANTE", Material.DIAMOND_BLOCK, (byte) 64),
		createItem("§5§lBLOCOS DE OURO", Material.GOLD_BLOCK, (byte) 64),
		createItem("§5§lBLOCOS DE FERRO", Material.IRON_BLOCK, (byte) 64),
		createItem("§5§lBLOCOS DE ESMERALDA", Material.EMERALD_BLOCK, (byte) 64),
		createItem("§5§lBLOCOS DE SLIME", Material.SLIME_BLOCK, (byte) 64)
	);
	
	public static final List<ItemStack> rare = Arrays.asList(
		createItemWithEnchantment(45, "§9§lESPADA RARA", Material.DIAMOND_SWORD, 
			Enchantment.DAMAGE_ALL, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS), 
		createItemWithEnchantment(45, "§9§lMACHADO RARA", Material.DIAMOND_AXE,
			Enchantment.DAMAGE_ALL, Enchantment.DIG_SPEED, Enchantment.DURABILITY, Enchantment.LOOT_BONUS_MOBS),
		createItemWithEnchantment(45, "§9§lPICARETA RARA", Material.DIAMOND_PICKAXE, 
			Enchantment.DURABILITY, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.DIG_SPEED),
		createItemWithEnchantment(45, "§9§lARMADURA RARA", Material.DIAMOND_HELMET, 
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(45, "§9§lARMADURA RARA", Material.DIAMOND_CHESTPLATE,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(45, "§9§lARMADURA RARA", Material.DIAMOND_LEGGINGS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY), 
		createItemWithEnchantment(45, "§9§lARMADURA RARA", Material.DIAMOND_BOOTS,
			Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY),
		createItem("§9§lMAÇÃS DOURADAS", Material.GOLDEN_APPLE, (byte) 64),
		createItem("§9§lBLOCOS DE DIAMANTE", Material.DIAMOND_BLOCK, (byte) 64),
		createItem("§9§lBLOCOS DE OURO", Material.GOLD_BLOCK, (byte) 64),
		createItem("§9§lBLOCOS DE FERRO", Material.IRON_BLOCK, (byte) 64),
		createItem("§9§lBLOCOS DE ESMERALDA", Material.EMERALD_BLOCK, (byte) 64),
		createItem("§9§lBLOCOS DE SLIME", Material.SLIME_BLOCK, (byte) 64)
	);
	
	static ItemStack createItem(String name, Material material, byte amount) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	static ItemStack createPotion(String name, String... lores) {
		ItemStack potion = new ItemStack(Material.POTION, 32);
		PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
		
		PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180 * 20, 2);
		PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 180 * 20, 2);
		potionMeta.addCustomEffect(strength, true);
		potionMeta.addCustomEffect(speed, true);
		potionMeta.setLore(Arrays.asList(lores));
		potionMeta.setDisplayName(name);
		potion.setItemMeta(potionMeta);
		return potion;
	}
	
	static ItemStack createItemWithEnchantment(Integer lvl, String name, Material material, Enchantment... enchants) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
		for (byte i = 0; i < enchants.length; i++) {
			enchantments.put(enchants[i], lvl);
		}
		
		item.addUnsafeEnchantments(enchantments);
		return item;
	}
}

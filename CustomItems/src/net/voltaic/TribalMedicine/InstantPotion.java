package net.voltaic.TribalMedicine;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class InstantPotion {
	
	public ItemStack item = new ItemStack(Material.POTION);
	private ItemMeta meta = item.getItemMeta();
	private int doses = 3;
	private PotionEffect effect;
	
	public void giveItems(Player player, String type) {
		
		createPotion(type);
		player.getInventory().addItem(item);
	}
	
	//private Plugin plugin = TribalMain.getPlugin(TribalMain.class);
	
	public void createPotion(String type) {
		meta.setDisplayName("Elixir of " + type);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Tribal Medicine - Elixer of " + type);
		lore.add(ChatColor.WHITE + "Doses: " + doses);
		lore.add(ChatColor.WHITE + "Effect: " + type);
		meta.setLore(lore);
		
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
	}
	
	public ItemStack returnPotion(String type) {
		createPotion(type);
		return item;
	}
	
}

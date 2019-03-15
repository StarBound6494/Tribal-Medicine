package net.voltaic.TribalMedicine;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CraftingLeather implements Listener { 
	
	public ItemStack item = new ItemStack(Material.LEATHER);
	private ItemMeta meta = item.getItemMeta();
	
	private Plugin plugin = TribalMain.getPlugin(TribalMain.class);
	
	public void giveItems(Player player) {
		
		createLeather();
		player.getInventory().addItem(item);
	}
	
	public void craftingLeather(NamespacedKey key) {
		
		createLeather();		
		ShapedRecipe cl = new ShapedRecipe(key, item);
		
		cl.shape("#%#","&@&","#%#");
		cl.setIngredient('#', Material.LEATHER);
		cl.setIngredient('%', Material.PAPER);
		cl.setIngredient('&', Material.CHEST);
		cl.setIngredient('@', Material.CRAFTING_TABLE);
		
		plugin.getServer().addRecipe(cl);
		
	}
	
	public void createLeather() {
		
		meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Crafting Leather");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Tribal Medicine - Crafting Leather");
		lore.add(ChatColor.WHITE + "Allows the user to craft Items on the fly");
		lore.add(ChatColor.WHITE + "at the expense of a few cows.");
		
		meta.setLore(lore);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.setItemMeta(meta);
		
	}
	
	public ItemStack returnLeather() {
		
		createLeather();
		return item;
	}
}

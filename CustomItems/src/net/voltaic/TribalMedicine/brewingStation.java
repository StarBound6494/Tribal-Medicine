package net.voltaic.TribalMedicine;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class brewingStation implements Listener{
	
	private Plugin plugin = TribalMain.getPlugin(TribalMain.class);
	public Inventory i = plugin.getServer().createInventory(null, 9,  ChatColor.DARK_GREEN + "Brewing Station");
	
	public void newInv(Player player) {
		int healthint = (int) player.getHealth();
		int foodint = player.getFoodLevel();
		
		ItemStack empty = new ItemStack(Material.GRAY_STAINED_GLASS);
		ItemMeta emptyMeta = empty.getItemMeta();
		emptyMeta.setDisplayName("'");
		empty.setItemMeta(emptyMeta);
		
		ItemStack health = new ItemStack(Material.ROSE_RED);
		ItemMeta hmeta = health.getItemMeta();
		hmeta.setDisplayName(ChatColor.RED + "Health");
		health.setItemMeta(hmeta);
		ItemStack food = new ItemStack(Material.APPLE);
		ItemMeta fmeta = food.getItemMeta();
		fmeta.setDisplayName(ChatColor.RED + "Food");
		food.setItemMeta(hmeta);
		
		i.setItem(0, empty);
		i.setItem(1, empty);
		i.setItem(2, empty);
		i.setItem(3,  health);
		i.setItem(4, empty);
		i.setItem(5,  food);
		i.setItem(6, empty);
		i.setItem(7, empty);
		i.setItem(8, empty);
		i.setItem(9, empty);
		
		player.openInventory(i);
	}

	public void openStation(Player sender) {
		newInv(sender);
		sender.openInventory(i);
		
	}
	
}

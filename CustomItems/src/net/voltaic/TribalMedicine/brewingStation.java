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
	int invsize = 27; //Size of the chest. mulp of 9
	public Inventory inv = plugin.getServer().createInventory(null, invsize,  ChatColor.DARK_GREEN + "Brewing Station");
	
	public void newInv(Player player) {
		
		ItemStack empty = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta emptyMeta = empty.getItemMeta();
		emptyMeta.setDisplayName(ChatColor.RED + "Disabled Slot");
		empty.setItemMeta(emptyMeta);
		
		ItemStack health = new ItemStack(Material.ROSE_RED);
		ItemMeta hmeta = health.getItemMeta();
		hmeta.setDisplayName(ChatColor.RED + "Health");
		health.setItemMeta(hmeta);
		
		ItemStack food = new ItemStack(Material.APPLE);
		ItemMeta fmeta = food.getItemMeta();
		fmeta.setDisplayName(ChatColor.RED + "Food");
		food.setItemMeta(fmeta);
		
		for(int i = 0; i < invsize; i++)
			inv.setItem(i, empty);
		
		//player.openInventory(i);
	}

	public void openStation(Player sender) {
		newInv(sender);
		sender.openInventory(inv);
		
	}
	
}

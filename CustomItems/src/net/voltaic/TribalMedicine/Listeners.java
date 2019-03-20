package net.voltaic.TribalMedicine;

import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {

	/*
	 * @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true) public
	 * void method1(BlockPlaceEvent event) {
	 * System.out.println("Something Happened!"); }
	 */
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = false)
	public void checkCraftingLeather(PlayerInteractEvent event) {
		
		if(event.getItem() != null) {
			ItemMeta meta = event.getItem().getItemMeta();
			if(meta.getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Portable Crafting Leather"))
				if(meta.getLore().get(0).equals(ChatColor.GREEN + "Tribal Medicine - Crafting Leather"))
					event.getPlayer().openWorkbench(null, true);
			if(meta.getDisplayName().contains(ChatColor.GREEN + "Tribal Medicine - Elixer of ")) {
				ArrayList<String> lore = (ArrayList<String>) meta.getLore();
				
			}
		}
	}
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true)
	public void checkForBrewStation(BlockPlaceEvent event) {
		
		if(event.canBuild())
			if(event.getBlockPlaced().getType() == Material.CAULDRON)
				if(event.getBlockAgainst().getType() == Material.MAGMA_BLOCK) {
					event.getPlayer().sendMessage(ChatColor.GREEN  + "You created a Brewing Station!");
				}
				
	}
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();
		
		if(open == null)
			return;
		if(open.getName().equals(ChatColor.DARK_GREEN + "Brewing Station")) {
			event.setCancelled(true);
			if(item.equals(null) || !item.hasItemMeta())
				return;
		}
		if(item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Health")) {
			player.closeInventory();
			brewingStation ci = new brewingStation();
			ci.newInv(player);
			player.setHealth(20);
		}
	}

}
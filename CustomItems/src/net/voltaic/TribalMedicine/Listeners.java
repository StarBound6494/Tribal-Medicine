package net.voltaic.TribalMedicine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {

	/*
	 * @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true) public
	 * void method1(BlockPlaceEvent event) {
	 * System.out.println("Something Happened!"); }
	 */

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void checkCraftingLeather(PlayerInteractEvent event) {

		if (event.getItem() != null) {
			ItemMeta meta = event.getItem().getItemMeta();
			if (meta.getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Portable Crafting Leather"))
				if (meta.getLore().get(0).equals(ChatColor.GREEN + "Tribal Medicine - Crafting Leather"))
					event.getPlayer().openWorkbench(null, true);
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST,ignoreCancelled=true)
	public void onItemConsume(PlayerItemConsumeEvent event) {
	    final ItemStack item = event.getItem();
	    if (item == null || item.getType() == Material.AIR) 
	    	return;
	    
	    List<String> lore = item.getItemMeta().getLore();
		if (lore.get(0).equalsIgnoreCase(ChatColor.GREEN + "Tribal Medicine - Elixir")) 
			event.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void checkInstantPotion(PlayerInteractEvent event) {

		if (event.getItem() != null) {
			List<String> lore = event.getItem().getItemMeta().getLore();
			if (lore.get(0).equalsIgnoreCase(ChatColor.GREEN + "Tribal Medicine - Elixir")) {
				InstantPotion p = new InstantPotion();
				p.applyEffect(event.getItem(), event.getPlayer());
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void checkStationCreation(BlockPlaceEvent event) {

		if (event.canBuild())
			if (event.getBlockPlaced().getType() == Material.CAULDRON)
				if (event.getBlockAgainst().getType() == Material.MAGMA_BLOCK) {
					event.getPlayer().sendMessage(ChatColor.GREEN + "You created a Brewing Station!");
				}
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void checkOpenStation(PlayerInteractEvent event) {
		if (event.isBlockInHand())
			return;
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;
		if (event.getHand() != EquipmentSlot.HAND)
			return;

		final Location location = event.getClickedBlock().getLocation();

		if (location.getBlock().getType() == Material.CAULDRON)
			if (location.add(0, -1, 0).getBlock().getType() == Material.MAGMA_BLOCK) {
				System.out.println("Brewing station was clicked!!");
				brewingStation s = new brewingStation();
				Player sender = event.getPlayer();
				s.openStation(sender);
			}
	}

	/*
	 * @EventHandler public void InvenClick(InventoryClickEvent event) { Player
	 * player = (Player) event.getWhoClicked();
	 * 
	 * Inventory open = event.getClickedInventory(); ItemStack item =
	 * event.getCurrentItem();
	 * 
	 * if (open == null) return; if (open.getName().equals(ChatColor.DARK_GREEN +
	 * "Brewing Station")) { event.setCancelled(true); if (item.equals(null) ||
	 * !item.hasItemMeta()) return; } if
	 * (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Health")) {
	 * player.closeInventory(); brewingStation ci = new brewingStation();
	 * ci.openStation(player); player.setHealth(20); } if
	 * (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "Health")) {
	 * player.closeInventory(); brewingStation ci = new brewingStation();
	 * ci.openStation(player); player.setFoodLevel(20); }
	 */
}

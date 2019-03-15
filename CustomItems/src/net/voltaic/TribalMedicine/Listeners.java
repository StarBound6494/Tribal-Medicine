package net.voltaic.TribalMedicine;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

	/*
	 * @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true) public
	 * void method1(BlockPlaceEvent event) {
	 * System.out.println("Something Happened!"); }
	 */
	
	@EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = false)
	public void checkCraftingLeather(PlayerInteractEvent event) {
		
		ItemStack held = event.getItem();
		ItemStack cl = new CraftingLeather().returnLeather();
		
		if(held != null) 
			if(held.equals(cl)) 
				event.getPlayer().openWorkbench(null, true);
	}

}
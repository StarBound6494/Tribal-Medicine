package net.voltaic.TribalMedicine;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {

	/*
	 * @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled = true) public
	 * void method1(BlockPlaceEvent event) {
	 * System.out.println("Something Happened!"); }
	 */

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void checkWeakDeathCharm(InventoryCloseEvent event) {
		for (ItemStack is : event.getInventory()) {
			if (is != null || is.hasItemMeta() == false)
				if (is.getType() == Material.TOTEM_OF_UNDYING) {
					ItemMeta im = is.getItemMeta();
					if (im.getDisplayName().equals("Weak Death Charm")) {
						AttributeModifier healthMod = new AttributeModifier("Max_Health", 6.0, AttributeModifier.getOperation(ADD_NUMBER) );
						List<String> lore = im.getLore();
						if (lore.equals("Enhancement: Level 3")) {
							event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(healthMod);
						}

					}
				}

		}
	}

}
package net.voltaic.TribalMedicine;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PotionRecipies {
	
	private ItemStack reagent = new ItemStack(Material.BLAZE_POWDER);
	private ItemStack cat = new ItemStack(Material.DIAMOND);
	private ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE);
	private ItemStack base = new ItemStack(Material.WHEAT);
	private ItemStack filler = new ItemStack(Material.POTATO);
	private ItemStack ing0;
	private ItemStack ing1;
	private ItemStack ing2;
	private ItemStack ing3;
	
	public void checkRecipies(Inventory i) {
		ItemStack[] inv = i.getContents();
		// -D-B-IIII-
		// 0123456789
		if(inv[1] == reagent)
			if(inv[3] == cat)
				if(inv[5] == ing0 && inv[6] == ing1 && inv[7] ==ing2)
					;
	}
	
	public void createRecipies(){
		
	}

}

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
	
	private String name = "";
	
	public void checkRecipies(Inventory i) {
		ItemStack[] inv = i.getContents();
		// -D-B-IIII-
		// 0123456789
		if(inv[1] == reagent)
			if(inv[3] == cat)
				if(inv[5] == ing0 && inv[6] == ing1 && inv[7] ==ing2)
					;
	}
	
	public static ItemStack[][] createRecipies(int numRecs){
		ItemStack[][] recipies = null;
		
		for(int i = 0; i < numRecs; i++) {
			recipies[0][i] = null;
		}
		
		return recipies;
	}
	
	private String assignName(int i) {
		String[] names = {"Temporary Health", "Darkness", "the Depths", "Distortment", "Warding", "Quickened Swiming", "Fast Acting", "Fire Resistance",
				"Farie Fire", "Inflict Wounds", "Healing", "Constitution", "Famine", "Heavy Strikes", "the Wraith", "Long Jumping", "Levitation", "Good Chances", "Darkvision", "Poison", "Regeneration",
				"Feasting", "Slowness", "Stunning", "Feather Falling", "Long Striding", "Unluck", "Gills", "Enfeeblement", "Decay"};
		
		return names[i];
	}

}

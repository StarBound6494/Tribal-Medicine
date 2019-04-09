package net.voltaic.TribalMedicine;

import java.util.ArrayList;
import java.util.List;

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
	public ItemStack bottle = new ItemStack(Material.GLASS_BOTTLE);
	private ItemStack air = new ItemStack(Material.AIR);
	private ItemMeta meta = item.getItemMeta();
	private String type;
	private String tier = "1";
	private String doses = "3";
	private PotionEffect effect;

	public void giveItems(Player player, String type) {
		createPotion(type);
		player.getInventory().addItem(item);
	}
	
	public void updateItem(Player player) {
		player.getInventory().addItem(item);
	}

	public void createPotion(String n) {
		type = n;
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD +"Elixir of " + type);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Tribal Medicine - Elixir");
		lore.add(ChatColor.WHITE + "Doses: " + doses);
		lore.add(ChatColor.WHITE + "Effect: " + type);
		lore.add(ChatColor.WHITE + "Tier: " + tier);
		meta.setLore(lore);

		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
	}
	
	public void applyEffect(ItemStack p, Player sender) {
		item = p;
		meta = item.getItemMeta();
		List<String> lore = meta.getLore();
		doses = lore.get(1).substring(9);
		
		type = lore.get(2).substring(10);
		System.out.println(type);
		
		Effects converter = new Effects();
		PotionEffect effect = converter.convertEffects(type, Integer.valueOf(tier));
		sender.addPotionEffect(effect);
		
		if(sender.getInventory().getItemInMainHand() == returnPotion(type))
			if(doses.equalsIgnoreCase("1")) {
				sender.getInventory().setItemInMainHand(bottle);
			}
			else {
				int temp = Integer.parseInt(doses);
				temp--;
				doses = String.valueOf(temp);
				
				lore.set(1, String.valueOf(doses));
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				sender.getInventory().setItemInMainHand(bottle);;
				sender.getInventory().setItemInMainHand(returnPotion(type));
			}
		else if(sender.getInventory().getItemInOffHand() == returnPotion(type))
			if(doses.equalsIgnoreCase("1")) {
				sender.getInventory().setItemInOffHand(bottle);
			}
			else {
				int temp = Integer.parseInt(doses);
				temp--;
				doses = String.valueOf(temp);
				
				lore.set(1, String.valueOf(doses));
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				sender.getInventory().setItemInOffHand(bottle);;
				sender.getInventory().setItemInOffHand(returnPotion(type));
			}
	}
	
	public ItemStack returnPotion(String type) {
		createPotion(type);
		return item;
	}

}

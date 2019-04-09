package net.voltaic.TribalMedicine;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Effects {
	
	public PotionEffect convertEffects(String s,int t) {
		
		int[] res = tier(t);
		PotionEffect effect = new PotionEffect(PotionEffectType.getByName(s.toUpperCase()), res[0], res[1]);
		
		return effect;
	}
	
	private int[] tier(int t) {
		int[] res = {0,0};
		if(t == 3) {
			res[0] = 180;
			res[1] = 3;
		}
		else if(t == 2) {
			res[0] = 60;
			res[1] = 2;
		}
		else if(t == 1) {
			res[0] = 30;
			res[1] = 10;
		}
			
			return res;
	}
	
	public String convertType(String n) {
		
		String[] names = {"Temporary Health", "Darkness", "the Depths", "Distortment", "Warding", "Quickened Swiming", "Fast Acting", "Fire Resistance",
				"Farie Fire", "Inflict Wounds", "Healing", "Constitution", "Famine", "Heavy Strikes", "the Wraith", "Long Jumping", "Levitation", "Good Chances", "Darkvision", "Poison", "Regeneration",
				"Feasting", "Slowness", "Stunning", "Feather Falling", "Long Striding", "Unluck", "Gills", "Enfeeblement", "Decay"};
		String[] types = {"Absorption", "Blindness", "Conduit_Power", "Confusion", "Damage_Resistance", "Dolphins_Grace", "Fast_Digging", "Fire_Resistance",
					"Glowing", "Harm", "Heal", "Health_Boost", "Hunger", "Increase_Damage", "Invisibility", "Jump", "Levitation", "Luck", "Night_Vision", "Poison", "Reeneration",
					"Saturation", "Slow", "Slow_Digging", "Slow_Falling", "Speed", "Unluck", "Water_Breathing", "Weakness", "Wither"};
		
		for(int i = 0; i < names.length; i++) {
			if(names[i].equalsIgnoreCase(n))
			return types[i];
		}
		
		return "Healing";
	}
}
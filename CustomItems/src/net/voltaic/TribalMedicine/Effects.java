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
}
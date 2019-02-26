package net.voltaic.TribalMedicine;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TribalMain extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		System.out.println("Enabled Tribal Medicine");
	}
	
	public void onDisable() {
		System.out.println("Inizibrew Disabled");
	}
	
	//Commands
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("tm")) {
			
		}
		
		return true;
	}
}

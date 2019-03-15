package net.voltaic.TribalMedicine;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TribalMain extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		PluginCommand command = getCommand("tm");
		command.setTabCompleter(new ImplementsTabCompleter());
		
		CraftingLeather items = new CraftingLeather();
		NamespacedKey key = new NamespacedKey(this, "fuckyou");
		items.craftingLeather(key);
		
		System.out.println("Tribal Medicine Enabled.");
	}
	
	public void onDisable() {
		System.out.println("Inizibrew Disabled");
	}
	
	//Commands
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("tm")) {
			if(args[0].equalsIgnoreCase("info"))
				sender.sendMessage("The Tribal Medicine Plugin created for the Inizicraft server adds"+
						" custom recipies and mechanics centered around progressive crafting and player advancment");
			else if(args[0].equalsIgnoreCase("giveLeather")) {
				CraftingLeather cr = new CraftingLeather();
				cr.giveItems((Player)sender);
			}
		}
		
		return true;
	}
}

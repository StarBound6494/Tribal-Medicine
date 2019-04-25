package net.voltaic.TribalMedicine;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class TribalMain extends JavaPlugin{
	
	public ItemStack[][] potRecipies;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(), this);
		
		PluginCommand command = getCommand("tm");
		command.setTabCompleter(new ImplementsTabCompleter());
		
		CraftingLeather items = new CraftingLeather();
		NamespacedKey key = new NamespacedKey(this, "fuckoff");
		items.craftingLeather(key);
		
		int numRecipies = 30; //The number of recipies registered with the plugin. 
		//potRecipies = PotionRecipies.createRecipies(numRecipies);
		
		System.out.println("Tribal Medicine Enabled.");
	}
	
	@Override
	public void onDisable() {
		System.out.println("Tribal Medicine Disabled");
	}
	
	//Commands
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("tm")) {
			if(args[0].equalsIgnoreCase("info"))
				sender.sendMessage("The Tribal Medicine Plugin created for the Inizicraft server adds"+
						" custom recipies and mechanics centered around progressive crafting and player advancment");
			//admin commands
			else if(sender.hasPermission("tribal.admin"))
					if(args[0].equalsIgnoreCase("giveLeather")) {
						CraftingLeather cr = new CraftingLeather();
						cr.giveItems((Player)sender);
					}
					else if(args[0].equalsIgnoreCase("giveelixir")) {
						InstantPotion ip = new InstantPotion();
						ip.giveItems((Player)sender, args[1]);
					}
					else if(args[0].equalsIgnoreCase("openStation")) {
						brewingStation station = new brewingStation();
						station.openStation((Player) sender);
					}
		}
		
		return true;
	}
}

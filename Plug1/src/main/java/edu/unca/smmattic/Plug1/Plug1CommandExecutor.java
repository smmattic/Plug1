package edu.unca.smmattic.Plug1;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class Plug1CommandExecutor implements CommandExecutor {
	private final Plug1 plugin;

	/*
	 * This command executor needs to know about its plugin from which it came
	 * from
	 */
	public Plug1CommandExecutor(Plug1 plugin) {
		this.plugin = plugin;
	}

	/*
	 * On command set the sample message
	 */
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		String[] split1 = args;
	    String commandName = command.getName().toLowerCase();
	        if (sender instanceof Player) {
	            Player player = (Player) sender;
	            if (!plugin.getPermission(player, "Plug1.take")) {
		        	   player.sendMessage(ChatColor.RED + "No help for you!");
		          return true; 
		          }
	            if (commandName.equals("dying")) {
	            	if (split1.length == 0) {

	                	player.getInventory().addItem(new ItemStack(Material.BED, 1));
	                	player.getInventory().addItem(new ItemStack(Material.BREAD, 3));
	                	player.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));
	                	player.getInventory().addItem(new ItemStack(Material.TORCH, 3));
	                	player.sendMessage(ChatColor.RED + "Oh no, you're dying! Take these items!");
	                	//is here better? seems to be	
	                	return true;
	            		}
	            	}


	        }
	        //throws an error here
	        //return true;
	        
		if (args.length == 0) {
			return false;
		} else if (!(sender instanceof Player)) {
			return false;
			// the cake will appear on the ground but not
			// necessarily where the player is looking
		} else if (args[0].equalsIgnoreCase("cake")) {
			Player fred = (Player) sender;
			Location loc = fred.getLocation();
			World w = loc.getWorld();
			loc.setX(loc.getX() + 1);
			Block b = w.getBlockAt(loc);
			b.setTypeId(92);
			return true;
			// the stored message now always begins with
			// the word "message"--do you know how to easily
			// fix that problem?
		} else if (args[0].equalsIgnoreCase("message")
				&& sender.hasPermission("Plug1.message")) {
			this.plugin.getConfig().set("Plug1.message", Joiner.on(' ').join(args));
			return true;
		} else {
			return false;
		} 
	}
}

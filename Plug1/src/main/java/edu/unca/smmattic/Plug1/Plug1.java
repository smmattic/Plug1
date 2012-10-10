package edu.unca.smmattic.Plug1;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
//import java.util.logging.Logger;
//import org.bukkit.event.Event;
// import org . bukkit . event . Priority was removed
//import org.bukkit.plugin.Plugin;
//import org.bukkit.plugin.PluginDescriptionFile;
//import org.bukkit.plugin.PluginManager;
//import com.nijiko.permissions.PermissionHandler;
//import com.nijikokun.bukkit.Permissions.Permissions;



/*
 * This is the main class of the sample plug-in
 */
public class Plug1 extends JavaPlugin {
    /*
     * This is called when your plug-in is enabled
     */
    //@Override
	
    public void onEnable() {
        //save the configuration file
        saveDefaultConfig();
        
        // Create the SampleListener
        new Plug1Listener(this);
        
        // set the command executor for sample
        this.getCommand("Plug1").setExecutor(new Plug1CommandExecutor(this));
        
        
        //this next command throws an error
        //setupPermissions();
        //config.load();
        
        	
        	getCommand("dying").setExecutor(new Plug1Listener(this));
        	//PluginDescriptionFile pdffile = this.getDescription();
        	//System.out.println( pdffile.getName() + " version " + pdffile.getVersion() + " is enabled.");
    }
    
    /** private void setupPermissions() {
    	Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");
    	
    	if (Plug1.permissions == null) {
    		if (test != null) {
    			Plug1.permissions = ((Permissions)test).getHandler();
    		} else {
    			log.info("Permission system not found");
    			
    		}
    	}
    }
    
    public boolean getPermission(Player player, String permission){
    	if (permissions == null) return true;
    	return permissions.has(player, permission);
    }
    
    /*
     * This is called when your plug-in shuts down
     */
    @Override
    public void onDisable() {
    	System.out.println("Oh, so you don't want my help. That's cool. Don't die.");
    }

	public boolean getPermission(Player player, String string) {
		// TODO Auto-generated method stub
		return false;
	}
   }

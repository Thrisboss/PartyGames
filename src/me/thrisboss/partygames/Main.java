package me.thrisboss.partygames;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.hamar;
public class Main extends JavaPlugin implements Listener{
	
	public static boolean WaitingStart = false;
	
	
	public void onEnable(){
		getLogger().info("[PartyGames] plugin à été activé!");
		registerEvents();
		registerCommands();
	    instance = this;
	}

	public void onDisable(){
		getLogger().info("[PartyGames] plugin est désactivé");
		
	}

	public void registerEvents(){
    org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
	//pm.registerEvents(new Listeners.JoinEvent(), this);
   // pm.registerEvents(new listeners.Quete2(), this);
	
	
	}
	public void registerCommands(){
		 getCommand("join").setExecutor(new hamar());
		 //getCommand("confirme").setExecutor(new Confirm());
		// getCommand("gm0").setExecutor(new Gamemode0());
		// getCommand("array").setExecutor(new array());
		// getCommand("menuadmin").setExecutor(new menuadmin());
		// getCommand("menu").setExecutor(new menu());
		
		
	}
	public static Main instance;
	

}
	
	

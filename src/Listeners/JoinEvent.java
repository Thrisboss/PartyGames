package Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
	
	@EventHandler
	public void onJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.isOp() && p.getWorld().getName().equalsIgnoreCase("world")){ // a changer
	          Bukkit.broadcastMessage(ChatColor.GOLD + "L'admin " + ChatColor.RED + p.getName() + " " + ChatColor.GOLD + "à rejoint le hub!");
	          p.sendMessage(ChatColor.GREEN + "Bienvenue" + ChatColor.GOLD +" admin " + ChatColor.RED + p.getName() + "");
	          p.setGameMode(GameMode.CREATIVE);
	          p.setAllowFlight(true);
	          p.setFlying(true);
			  p.setFoodLevel(20);
		      p.setHealth(20);
		        
	        
	           
		} if(p.getWorld().getName().equalsIgnoreCase("world") && !p.isOp()){ // a changer
			p.setGameMode(GameMode.SURVIVAL);
			p.setFoodLevel(20);
	        p.setHealth(20);
	        p.sendMessage(ChatColor.GOLD + "Bienvenue");
	        p.getInventory().clear();
		} 
		 

        
        
		
		
	}
	

}

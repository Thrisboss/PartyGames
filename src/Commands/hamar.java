package Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ArrayList.ArrayLists;
import me.McVier3ck.countdown.Countdown;
import me.thrisboss.partygames.Main;

public class hamar implements CommandExecutor{
 	

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Location WaitingLobby = new Location(Bukkit.getWorld("world"), 10, 80, 10); // A changer
		
		
        if(cmd.getName().equalsIgnoreCase("join")){
        	if(!ArrayLists.InGame.contains(p.getName())){
        	if(p.hasPermission("partygames.join")){
            
            p.setHealth(20);
            p.setAllowFlight(false);
            p.setExp(0);
            p.setFireTicks(0);
            p.setFoodLevel(20);
        	
            ArrayLists.InGame.add(p.getName());
            
            ArrayLists.Waiting.add(p.getName());
            
            p.teleport(WaitingLobby);
        	
            if(!ArrayLists.Waiting.isEmpty()){
            	if(ArrayLists.Waiting.size() >= 2 && ArrayLists.InGame.contains(p.getName()) && p.isOnline() &&  !Main.WaitingStart){
            		p.sendMessage(ChatColor.GOLD + "Vous avez rejoint le lobby d'attente!");
            		Bukkit.broadcastMessage(ChatColor.GOLD + "[PartyGames] " + ChatColor.GREEN + "Le countdown va start!" );
            		Main.WaitingStart = true;
            		return true;
            	} else if(ArrayLists.Waiting.size() < 2 && ArrayLists.NotInGame.contains(p.getName()) && !ArrayLists.InGame.contains(p.getName()) && !p.isOnline()){
            		p.sendMessage(ChatColor.RED + "ERREUR!");
            		return false;
            	} else if(ArrayLists.Waiting.size() < 2 && ArrayLists.InGame.contains(p.getName()) && p.isOnline() && Main.WaitingStart){
            		p.sendMessage(ChatColor.GOLD + "Vous avez rejoint le lobby d'attente!");
            		Bukkit.broadcastMessage(ChatColor.GOLD + "[PartyGames] " + ChatColor.GREEN + "Il manque 1 joueur!" );
            		Main.WaitingStart = false;
            		return false;
            	} else if(ArrayLists.Waiting.size() >= 2 && ArrayLists.InGame.contains(p.getName()) && p.isOnline() && Main.WaitingStart){
            		p.sendMessage(ChatColor.GOLD + "Vous avez rejoint le lobby d'attente!");
            		return true;
            	}
            	else if(ArrayLists.Waiting.size() < 2 && ArrayLists.InGame.contains(p.getName()) && p.isOnline() && !Main.WaitingStart){
            		Bukkit.broadcastMessage(ChatColor.GOLD + "[PartyGames] " + ChatColor.GREEN + "Il manque 1 joueur!" );
            		p.sendMessage(ChatColor.GOLD + "Vous avez rejoint le lobby d'attente!");
            		return true;
            	}
            	return false;
            }
            return false;
        	}
        	p.sendMessage(ChatColor.RED + "Vous n'avez pas la permission!");
        	return false;
        	}
            p.sendMessage(ChatColor.RED + "Vous êtes déjà dans une partie!");
            return false;
        }
		return false;
	}
}

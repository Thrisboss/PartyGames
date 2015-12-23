package Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignClick implements Listener {
	
	
	
	
	@EventHandler
	public void OnPlayerInteract(PlayerInteractEvent e){
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if (!(e.getClickedBlock().getType() == Material.SIGN) && !(e.getClickedBlock().getType() == Material.SIGN_POST)) return;
         Sign s = (Sign) e.getClickedBlock().getState();
	     Player p = e.getPlayer();
		
		if (s.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "[" + ChatColor.BLUE + "PartyGames" + ChatColor.GREEN + "]")) {
			e.getPlayer().performCommand("partygames join");
		
		}
	}
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		Player p = e.getPlayer();
		if (e.getLines().length > 0 && !e.getLine(0).equalsIgnoreCase("[PartyGames]")) return;
		if (e.getLines().length < 3) {
			e.getBlock().breakNaturally();
			p.sendMessage("A PartyGames sign must have at least 3 lines.");
			return;
		}
		
		try { Integer.parseInt(e.getLine(2)); }
		catch (Exception ex) {
			e.getBlock().breakNaturally();
			 p.sendMessage(e.getLine(2) + ChatColor.RED + " is not a valid number!");
			return;
		}
		
		e.setLine(0, ChatColor.GREEN + "[" + ChatColor.BLUE + "PartyGames" + ChatColor.GREEN + "]");
	}
}
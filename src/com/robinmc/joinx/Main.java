package com.robinmc.joinx;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	private String JOIN_MESSAGE;
	private String QUIT_MESSAGE;
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		
		super.saveDefaultConfig();
		super.saveConfig();
		JOIN_MESSAGE = colors(super.getConfig().getString("join"));
		QUIT_MESSAGE = colors(super.getConfig().getString("quit"));
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event){
		event.setJoinMessage(JOIN_MESSAGE.replace("{x}", event.getPlayer().getName()));
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent event){
		event.setQuitMessage(QUIT_MESSAGE.replace("{x}", event.getPlayer().getName()));
	}
	
	private static String colors(String string){
		return ChatColor.translateAlternateColorCodes('&', string);
	}

}

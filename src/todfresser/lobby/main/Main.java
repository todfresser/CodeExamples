package todfresser.lobby.main;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import todfresser.lobby.inventory.LobbyInventory;

public class Main extends JavaPlugin{
	
	private static Main instance;
	public static Main getInstance(){
		return instance;
	}
	
	@Override
	public void onEnable(){
		instance = this;
		try {
			LobbyInventory.loadallLobbyInventorys();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

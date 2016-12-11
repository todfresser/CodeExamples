package todfresser.example;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class FileExample{
	String f1 = "Message:Hallo ich bin %PLAYER%";
	
	public static void save(ItemStack item,String function, Location l){
		File file = new File("plugins/Smash/Maps", "Spawn.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("SpawnLocation", l.getWorld().getName() + l.getX() + "," + l.getY() + "," + l.getZ() + "," + l.getYaw());
		
		
		
		String data = "FarmWelt,10,3,50,40.45462343";
		String[] ed = data.split(",");
		Location newLoc = new Location(Bukkit.getWorld(ed[0]), Integer.parseInt(ed[1]) + 0.5, Integer.parseInt(ed[2]), Integer.parseInt(ed[3]) + 0.5);
		
	}
	
}

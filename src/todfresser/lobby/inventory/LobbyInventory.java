package todfresser.lobby.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class LobbyInventory {
	private static List<LobbyInventory> inventorys = new ArrayList<>();
	
	public static Collection<LobbyInventory> getallInventorys(){
		return inventorys;
	}
	
	public static LobbyInventory getfromTitleAndSize(String title, int size){
		for (LobbyInventory inv : inventorys){
			if (inv.getSize() == size && inv.getTitle().equals(title)){
				return inv;
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static void saveallLobbyInventorys() throws IOException{
		String newLine = System.getProperty("line.separator");
		for (LobbyInventory inv : inventorys){
			File file = new File("plugins/Lobby/Inventorys", inv.getTitle() + ".lobby");
			if (file.exists()) file.delete();
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("size," + Integer.toString(inv.getSize()));
			bw.write(newLine);
			for (int slot = 0; slot < inv.getSize(); slot++){
				if (inv.getItem(slot) != null){
					LobbyItem item = inv.getItem(slot);
					bw.write("item," + Integer.toString(slot) + "," + item.getDisplayName() + "," + Integer.toString(item.getType().getId()) + "," + item.getActionString());
					bw.write(newLine);
				}
			}
			bw.close();
		}
	}
	
	public static void loadallLobbyInventorys() throws IOException{
		File folder = new File("plugins/Lobby/Inventorys");
		if (folder.exists()){
			if (folder.list().length != 0){
				String[] fileNames = folder.list();
				for(int i = 0; i < fileNames.length; i++){
					File file = new File("plugins/Lobby/Inventorys", fileNames[i]);
					
					if (file.exists()){
						FileReader fr = null;
						fr = new FileReader(file);
						LobbyInventory inv = new LobbyInventory();
						inv.setTitle(file.getName().replace(".lobby", ""));
						BufferedReader br = new BufferedReader(fr);
						String line = null;
						while((line = br.readLine()) != null){
							String[] s = line.split(",");
							if (s[0].equals("item")){
								LobbyItem item = new LobbyItem();
								item.setDisplayName(s[2]);
								item.setTypeID(Integer.parseInt(s[3]));
								item.setActionString(s[4]);
								inv.setItem(Integer.parseInt(s[1]), item);
							}
							if (s[0].equals("size")){
								inv.setSize(Integer.parseInt(s[1]));
								break;
							}
						}
						br.close();
						inv.load();
					}
					
				}
			}
		}
	}
	
	private HashMap<Integer, LobbyItem> items = new HashMap<>();
	private Inventory spigotinventory;
	
	private String title;
	private int size;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Collection<LobbyItem> getItems() {
		return items.values();
	}
	
	public LobbyItem getItem(int slot){
		if (items.containsKey(slot)){
			return items.get(slot);
		}
		return null;
	}

	public Inventory getSpigotInventory() {
		return spigotinventory;
	}

	public LobbyInventory(){}
	
	public void setItem(int slot, LobbyItem item){
		if (slot >= size) return;
		if (items.containsKey(slot)) items.remove(slot);
		items.put(slot, item);
	}
	
	public void load(){
		if (!inventorys.contains(this)){
			spigotinventory = Bukkit.createInventory(null, size, title);
			for (int slot = 0; slot < size; slot++){
				if (items.containsKey(slot)){
					spigotinventory.setItem(slot, items.get(slot).toSpigotItemStack());
				}
			}
			inventorys.add(this);
		}
	}
	
	public void unload(){
		for (LobbyInventory inv : inventorys){
			if (inv.getSize() == this.getSize() && inv.getTitle().equals(this.getTitle())){
				inventorys.remove(inv);
			}
		}
	}
	
	
}

package todfresser.lobby.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LobbyItem {
	
	private String name;
	private String itemaction;
	private int typeID = 1;
	
	public LobbyItem(){}
	
	public String getDisplayName() {
		return name;
	}

	public void setDisplayName(String name) {
		this.name = name;
	}

	public String getActionString() {
		return itemaction;
	}

	public void setActionString(String action) {
		this.itemaction = action;
	}
	
	public void performAction(Player p){
		//Einfügen
	}

	@SuppressWarnings("deprecation")
	public Material getType() {
		return Material.getMaterial(typeID);
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	
	public ItemStack toSpigotItemStack(){
		ItemStack item = new ItemStack(getType());
		ItemMeta meta = item.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
}

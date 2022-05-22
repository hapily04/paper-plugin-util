package me.hapily.plugins.util.paperpluginutil.menus;

import me.hapily.plugins.util.paperpluginutil.PaperPluginUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu implements InventoryHolder {

    private Inventory inventory;
    private Component name;
    private int size;
    private InventoryType type;
    private HashMap<Integer, MenuItem> menuItemHashMap;

    public Menu(InventoryType type, int rows, @Nullable Component name){
        if(!type.isCreatable())
            throw new IllegalArgumentException("Inventory type must be creatable & able to be shown to players.");
        else if(type == InventoryType.CHEST && rows == 0)
            throw new IllegalArgumentException("If the inventory type is 'chest' you must provide a row amount (or it must not be 0).");
        else if(type != InventoryType.CHEST && rows != 0)
            throw new IllegalArgumentException("If the inventory type is not 'chest', you cannot provide a row amount.");
        else{
            if(type == InventoryType.CHEST){
                if(rows < 1 || rows > 6)
                    throw new IllegalArgumentException("The row count can only be between 1 and 6.");
                if(name == null){
                    this.inventory = Bukkit.createInventory(this, rows * 9);
                }
                else{
                    this.inventory = Bukkit.createInventory(this, rows * 9, name);
                }
            }
            else{
                if(name == null){
                    this.inventory = Bukkit.createInventory(this, type);
                }
                else{
                    this.inventory = Bukkit.createInventory(this, type, name);
                }
            }
            this.size = inventory.getSize();
            this.name = name == null ? type.defaultTitle() : name;
            this.type = type;
            this.menuItemHashMap = new HashMap<>();
            PaperPluginUtil.getInstance().getManager().menus.add(this);
        }
    }

    public Menu(InventoryType type, @Nullable Component name){
        new Menu(type, 0, name);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    public Component getName(){
        return name;
    }

    public void setName(Component name){
        inventory.clear();
        inventory.close();
        Menu menu = new Menu(type, size / 9, name);
        // TODO create new inventory and open to all players of this inventory with the same items
    }

    public int getSize(){
        return size;
    }

    public void fillWith(ItemStack item){
        for (int i = 0; i < size; i++) {
            inventory.setItem(i, item);
        }
    }

    public HashMap<Integer, MenuItem> getItems(){
        return menuItemHashMap;
    }

    public void setItem(int slot, MenuItem item){
        inventory.setItem(slot, item.getItem());
        menuItemHashMap.put(slot, item);
    }

    public ArrayList<Player> getPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        for(HumanEntity humanEntity : inventory.getViewers()){
            players.add((Player) humanEntity);
        }
        return players;
    }

    public void openTo(Player player){
        player.openInventory(inventory);
    }


}

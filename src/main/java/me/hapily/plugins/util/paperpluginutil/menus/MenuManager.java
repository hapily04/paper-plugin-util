package me.hapily.plugins.util.paperpluginutil.menus;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MenuManager implements Listener {

    public ArrayList<Menu> menus;

    public MenuManager(JavaPlugin plugin){
        this.menus = new ArrayList<>();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inventory = event.getClickedInventory();
        for(Menu menu : menus){
            if(Objects.requireNonNull(inventory).getHolder() == menu){
                HashMap<Integer, MenuItem> items = menu.getItems();
                if(items.containsKey(event.getRawSlot()))
                    items.get(event.getRawSlot()).runConsumer(event);
            }
        }
    }

}

package me.hapily.plugins.util.paperpluginutil.menus;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Consumer;

public class MenuItem {

    private final ItemStack item;
    private final Consumer<InventoryClickEvent> consumer;

    public MenuItem(ItemStack item, Consumer<InventoryClickEvent> consumer){
        this.item = item;
        this.consumer = consumer;
    }

    public ItemStack getItem() {
        return item;
    }

    public void runConsumer(InventoryClickEvent event){
        consumer.accept(event);
    }

}

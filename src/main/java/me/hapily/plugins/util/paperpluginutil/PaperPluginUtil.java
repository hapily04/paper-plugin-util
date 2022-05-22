package me.hapily.plugins.util.paperpluginutil;

import me.hapily.plugins.util.paperpluginutil.menus.Menu;
import me.hapily.plugins.util.paperpluginutil.menus.MenuManager;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperPluginUtil {

    public PaperPluginUtil(JavaPlugin plugin){
        new MenuManager(plugin);
    }

}

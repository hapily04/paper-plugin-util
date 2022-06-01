package me.hapily.plugins.util.paperpluginutil;

import me.hapily.plugins.util.paperpluginutil.menus.MenuManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperPluginUtil {

    private final MenuManager manager;

    public PaperPluginUtil(JavaPlugin plugin){
        this.manager = new MenuManager(plugin);
    }

    public MenuManager getManager() {
        return manager;
    }
}

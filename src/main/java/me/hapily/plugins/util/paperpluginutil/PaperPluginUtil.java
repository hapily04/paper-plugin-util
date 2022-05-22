package me.hapily.plugins.util.paperpluginutil;

import me.hapily.plugins.util.paperpluginutil.menus.MenuManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperPluginUtil {

    private static PaperPluginUtil instance;
    private final MenuManager manager;

    public PaperPluginUtil(JavaPlugin plugin){
        instance = this;
        this.manager = new MenuManager(plugin);
    }

    public static PaperPluginUtil getInstance() {
        return instance;
    }

    public MenuManager getManager() {
        return manager;
    }
}

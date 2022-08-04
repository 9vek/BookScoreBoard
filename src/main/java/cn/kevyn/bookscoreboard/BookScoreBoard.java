package cn.kevyn.bookscoreboard;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class BookScoreBoard extends JavaPlugin {

    public static BookScoreBoard INSTANCE;

    public final String ENABLE = "[BookBoard]" + ChatColor.BLUE + " plugin is now enabled！";
    public final String DISABLE = "[BookBoard]" + ChatColor.RED + " plugin is now disabled！";
    public final String RELOAD = "[BookBoard]" + ChatColor.GREEN + " config is now successfully reloaded！";

    public boolean hasPlaceHolderAPI;

    public BookScoreBoard() {
        BookScoreBoard.INSTANCE = this;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            hasPlaceHolderAPI = true;
        } else {
            hasPlaceHolderAPI = false;
        }

        getCommand("bsb-reload").setExecutor(BSBCommand.INSTANCE);
        getCommand("bsb-open").setExecutor(BSBCommand.INSTANCE);
        getServer().getPluginManager().registerEvents(new BSBListener(), this);

        BSBHandler.INSTANCE.loadConfig();
        getServer().getConsoleSender().sendMessage(ENABLE);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getServer().getConsoleSender().sendMessage(DISABLE);
    }

    public void reloadPlugin() {
        reloadConfig();
        BSBHandler.INSTANCE.loadConfig();
        getServer().getConsoleSender().sendMessage(RELOAD);
    }

}


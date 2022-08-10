package cn.kevyn.bookscoreboard;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class BSBListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        String playerName = event.getPlayer().getName();
        if (!BSBHandler.INSTANCE.playerBooks.keySet().contains(playerName)) {
            BSBHandler.INSTANCE.playerBooks.put(playerName, new ItemStack(Material.WRITTEN_BOOK));
        }
    }

}

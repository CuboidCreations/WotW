package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import com.gmail.Xeiotos.WotW.WotWGame;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

/**
 *
 * @author Xeiotos
 */
public class WorldChangeListener implements Listener {
    
    @EventHandler
    public void onPlayerPortalEnter(PlayerPortalEvent event) {
        if (WotWGame.getInstance().getGameStage() == GameStage.INTERIM) {
            event.getPlayer().sendMessage(ChatColor.RED + "You can't change worlds during Interim. Please wait " + (WotWGame.getInstance().getGameTimer().getTimeLeft() - WotWGame.getSolsticeTime()) + " more minutes.");
            event.setCancelled(true);
        }
    }
}

package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Managers.WotWPlayerManager;
import com.gmail.Xeiotos.WotW.WotW;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 *
 * @author Xeiotos
 */
public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onJoin(final PlayerLoginEvent event) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(WotW.getInstance(), new Runnable() {
            @Override
            public void run() {
                WotWPlayerManager.getManager().addPlayer(event.getPlayer());
            }
        });
    }
}

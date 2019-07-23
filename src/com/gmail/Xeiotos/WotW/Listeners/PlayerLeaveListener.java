package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Managers.WotWPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Xeiotos
 */
public class PlayerLeaveListener implements Listener {
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onLeave(PlayerQuitEvent event) {
        WotWPlayerManager.getManager().getWotWPlayer(event.getPlayer()).getComboTimer().cancel();
        WotWPlayerManager.getManager().removePlayer(event.getPlayer().getName());
    }
}

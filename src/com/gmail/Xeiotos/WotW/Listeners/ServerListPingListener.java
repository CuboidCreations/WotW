/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import com.gmail.Xeiotos.WotW.WotW;
import com.gmail.Xeiotos.WotW.WotWGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 *
 * @author Chris
 */
public class ServerListPingListener implements Listener {
    
    private static final String MOTD = Bukkit.getMotd();
    
    @EventHandler
    public void onPing(ServerListPingEvent event) {
        if (WotW.getGame().getGameStage() == GameStage.INTERIM) {
            event.setMotd(MOTD + ChatColor.AQUA + " Interim " + ChatColor.RESET + (WotW.getGame().getGameTimer().getTimeLeft() - WotWGame.getSolsticeTime())+ "m");
        } else {
            event.setMotd(MOTD + ChatColor.RED + " Solstice " + ChatColor.RESET + (WotW.getGame().getGameTimer().getTimeLeft()) + "m");
        }
    }
}

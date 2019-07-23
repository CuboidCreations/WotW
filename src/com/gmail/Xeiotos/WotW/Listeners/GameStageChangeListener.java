/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import com.gmail.Xeiotos.WotW.Events.GameStageChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author Chris
 */
public class GameStageChangeListener implements Listener {

    @EventHandler
    public void onGameStageChange(GameStageChangeEvent event) {
        if (event.getGameStage() == GameStage.INTERIM) {
            Bukkit.broadcastMessage(ChatColor.BLUE + "A veil of calmth falls over the world as the gates close.");
        } else {
            Bukkit.broadcastMessage(ChatColor.RED + "The Earth's core trembles as the gates of Hell open.");
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1f, 1f);
                player.playSound(player.getLocation(), Sound.ENDERMAN_SCREAM, 1f, 1f);
                player.playSound(player.getLocation(), Sound.GHAST_SCREAM, 1f, 1f);
            }
        }
    }
}

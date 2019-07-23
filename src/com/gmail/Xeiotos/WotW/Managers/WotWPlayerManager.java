/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Managers;

import com.gmail.Xeiotos.WotW.WotWPlayer;
import java.util.ArrayList;
import org.bukkit.entity.Player;

/**
 *
 * @author Chris
 */
public class WotWPlayerManager {
    
    private static WotWPlayerManager WotWPlayerManager;
    private static ArrayList<WotWPlayer> WotWPlayers = new ArrayList<>();
    
    /**
    * Create a new instance of a WotWPlayerManager
    */    
    public WotWPlayerManager() {
    }

    /**
    * Get the WotWPlayerManager instance
    * @return WotWPlayerManager instance
    */
    public static WotWPlayerManager getManager() {
        if (WotWPlayerManager == null) {
            WotWPlayerManager = new WotWPlayerManager();
        }

        return WotWPlayerManager; // NOT THREAD SAFE!
    }
    
    /**
    * Remove a player from the player list by WotWPlayer
    * @param WotWPlayer WotWplayer to remove
    */
    public void removePlayer(WotWPlayer WotWPlayer) {
        WotWPlayers.remove(WotWPlayer);
    }
    
    /**
    * Add a player to the list by player object
    * @param player Player to add
    */
    public void addPlayer(Player player) {
        WotWPlayers.add(new WotWPlayer(player));
    }
    
    /**
    * Remove a player from the player list by playername
    * @param playerName WotWplayer to remove
    */
    public void removePlayer(String playerName) {
        WotWPlayers.remove(getWotWPlayer(playerName));
    }
    
    /**
    * Remove a player from the player list by player
    * @param player WotWplayer to remove
    */
    public void removePlayer(Player player) {
        WotWPlayers.remove(getWotWPlayer(player));
    }
    
    /**
    * Get a WotWPlayer by it's player object
    * @param p Player to lookup
    * @return WotWPlayer from the list, null if not found
    */
    public WotWPlayer getWotWPlayer(Player p) {
        return getWotWPlayer(p.getName());
    }
    
    /**
    * Get a WotWPlayer by it's name
    * @param name Player name to lookup
    * @return WotWPlayer from the list, null if not found
    */
    public WotWPlayer getWotWPlayer(String name) {
        if (name != null) {
            for (WotWPlayer p : WotWPlayers) {
                if (p.getName().equalsIgnoreCase(name)) {
                    return p;
                }
            }
        }
        return null;
    }
    
    /**
    * Get all WotWPlayers
    * @return List of all WotWPlayers, null if none.
    */
    public ArrayList<WotWPlayer> getWotWPlayers() {
        return WotWPlayers;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Events;

import com.gmail.Xeiotos.WotW.Enums.Combo;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Chris
 */
public class ComboEvent extends Event {

    private final static HandlerList handlers = new HandlerList();
    private final Player player;
    private final Combo combo;

    public ComboEvent(final Player player, final Combo combo) {
        this.player = player;
        this.combo = combo;
    }

    public Player getPlayer() {
        return player;
    }

    public Combo getCombo() {
        return combo;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}

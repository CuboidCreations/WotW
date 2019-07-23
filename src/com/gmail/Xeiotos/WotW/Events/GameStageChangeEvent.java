/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Events;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Chris
 */
public class GameStageChangeEvent extends Event {

    private final static HandlerList handlers = new HandlerList();
    private final GameStage gameStage;

    public GameStageChangeEvent(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

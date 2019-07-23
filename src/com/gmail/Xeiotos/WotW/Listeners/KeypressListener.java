/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Enums.Combo;
import com.gmail.Xeiotos.WotW.Enums.Keypress;
import com.gmail.Xeiotos.WotW.Events.ComboEvent;
import com.gmail.Xeiotos.WotW.Managers.WotWPlayerManager;
import com.gmail.Xeiotos.WotW.Utils.ComboVerification;
import com.gmail.Xeiotos.WotW.WotWPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

/**
 *
 * @author Chris
 */
public class KeypressListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void PlayerSprintHandler(PlayerToggleSprintEvent event) {
        WotWPlayer wotWPlayer = WotWPlayerManager.getManager().getWotWPlayer(event.getPlayer());
        wotWPlayer.getComboTimer().initiateCombo();
        if (event.getPlayer().isSprinting()) {
            handleKeypress(wotWPlayer, event, Keypress.DOUBLEFORWARDRELEASE);
        } else {
            handleKeypress(wotWPlayer, event, Keypress.DOUBLEFORWARD);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void PlayerSprintHandler(PlayerInteractEvent event) {
        Action eventAction = event.getAction();

        if (eventAction == Action.RIGHT_CLICK_AIR || eventAction == Action.RIGHT_CLICK_BLOCK) {
            WotWPlayer wotWPlayer = WotWPlayerManager.getManager().getWotWPlayer(event.getPlayer());
            wotWPlayer.getComboTimer().initiateCombo();
            handleKeypress(wotWPlayer, event, Keypress.RIGHTMOUSE);
        } else if (eventAction == Action.LEFT_CLICK_AIR || eventAction == Action.LEFT_CLICK_BLOCK) {
            WotWPlayer wotWPlayer = WotWPlayerManager.getManager().getWotWPlayer(event.getPlayer());
            wotWPlayer.getComboTimer().initiateCombo();
            handleKeypress(wotWPlayer, event, Keypress.LEFTMOUSE);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void PlayerSprintHandler(PlayerToggleFlightEvent event) {
        WotWPlayer wotWPlayer = WotWPlayerManager.getManager().getWotWPlayer(event.getPlayer());
        wotWPlayer.getComboTimer().initiateCombo();
        handleKeypress(wotWPlayer, event, Keypress.DOUBLESPACE);
    }

    private void handleKeypress(WotWPlayer wotWPlayer, PlayerEvent event, Keypress keypress) {
        if (ComboVerification.verifyCombo(wotWPlayer.getCurrentCombo())) {
            wotWPlayer.getCurrentCombo().add(keypress);
            Combo combo = ComboVerification.getCombo(wotWPlayer.getCurrentCombo());
            if (combo != null) {
                wotWPlayer.getCurrentCombo().clear();
                Bukkit.getServer().getPluginManager().callEvent(new ComboEvent(event.getPlayer(), combo));
            }
        } else {
            wotWPlayer.getCurrentCombo().clear();
            wotWPlayer.getCurrentCombo().add(keypress);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Listeners;

import com.gmail.Xeiotos.WotW.Events.ComboEvent;
import com.gmail.Xeiotos.WotW.WotW;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author Xeiotos
 */
public class ComboListener implements Listener {
    
    @EventHandler 
    public void comboHandler(ComboEvent event) {
        try {
            event.getCombo().getSkill().getConstructor(Player.class).newInstance(event.getPlayer()).runTask(WotW.getInstance());
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ComboListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

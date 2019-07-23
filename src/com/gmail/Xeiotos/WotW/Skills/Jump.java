/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Skills;

import com.gmail.Xeiotos.WotW.Enums.Combo;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 *
 * @author Chris
 */
public class Jump extends Skill {
    
    private final Player player;

    public Jump(Player player) {
        super(Combo.JUMP, 1, 5);
        this.player = player;
    }
    
    @Override
    public void run() {
        if (player.isOnline()) {
            Vector velocity = player.getLocation().getDirection().multiply(level);
            player.setVelocity(velocity);
            this.cancel();
        } else {
            this.cancel();
        }
    }
}

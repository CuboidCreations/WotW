/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Skills;

import com.gmail.Xeiotos.WotW.Enums.Combo;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Xeiotos
 */
public abstract class Skill extends BukkitRunnable {

    protected int level;
    protected int maxLevel;
    protected Combo combo;

    public Skill(Combo combo, int level, int maxLevel) {
        this.level = level;
        this.maxLevel = maxLevel;
        this.combo = combo;
    }
    
    @Override
    public abstract void run();

    public Combo getCombo() {
        return combo;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Utils;

import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Xeiotos
 */
public class SimpleTimer extends BukkitRunnable {
    
    protected long initialTime;
    protected long period;
    protected long timeLeft;

    public SimpleTimer(long initialTime, long period) {
        this.initialTime = initialTime;
        this.timeLeft = initialTime;
        this.period = period;
    } 

    public long getInitialTime() {
        return initialTime;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public long getPeriod() {
        return period;
    }
    
    @Override
    public void run() {
        timeLeft = timeLeft - period;
    }     
}
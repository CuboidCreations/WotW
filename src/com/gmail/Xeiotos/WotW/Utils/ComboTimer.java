/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Utils;

import com.gmail.Xeiotos.WotW.WotW;
import com.gmail.Xeiotos.WotW.WotWPlayer;

/**
 *
 * @author Chris
 */
public class ComboTimer extends SimpleTimer {

    private final WotWPlayer wotWPlayer;

    public ComboTimer(WotWPlayer wotWPlayer, long period) {
        super(WotW.getComboTimeout(), 5);
        this.wotWPlayer = wotWPlayer;
    }

    @Override
    public void run() {
        if (timeLeft <= 0) {
            wotWPlayer.setIsInCombo(false);
        } else {
            timeLeft = timeLeft - period;
        }
    }
    
    public void initiateCombo() {
        wotWPlayer.setIsInCombo(true);
        timeLeft = initialTime;
    }
}

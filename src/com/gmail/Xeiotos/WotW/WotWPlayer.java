/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW;

import com.gmail.Xeiotos.WotW.Enums.Keypress;
import com.gmail.Xeiotos.WotW.Utils.ComboTimer;
import java.util.ArrayList;
import org.bukkit.entity.Player;

/**
 *
 * @author Xeiotos
 */
public class WotWPlayer {

    private Player player;
    private String playerName;
    private boolean isInCombo;
    private ArrayList<Keypress> currentCombo = new ArrayList();
    private ComboTimer comboTimer;

    public WotWPlayer(Player player) {
        this.player = player;
        this.playerName = player.getName();
        this.comboTimer = new ComboTimer(this, 5);
        comboTimer.runTaskTimer(WotW.getInstance(), 5L, 5L);
    }

    public String getName() {
        return playerName;
    }
    
    public void setIsInCombo(boolean isInCombo) {
        this.isInCombo = isInCombo;
        if (!isInCombo) {
            currentCombo.clear();
        }
    }

    public boolean isIsInCombo() {
        return isInCombo;
    }

    public ComboTimer getComboTimer() {
        return comboTimer;
    }

    public ArrayList<Keypress> getCurrentCombo() {
        return currentCombo;
    }
}

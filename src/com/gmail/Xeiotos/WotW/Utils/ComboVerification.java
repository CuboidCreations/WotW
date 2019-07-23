/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.Xeiotos.WotW.Utils;

import com.gmail.Xeiotos.WotW.Enums.Combo;
import com.gmail.Xeiotos.WotW.Enums.Keypress;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Xeiotos
 */
public class ComboVerification {

    public static boolean verifyCombo(ArrayList<Keypress> currentCombo) {
        int i = 0;
        ArrayList<Keypress> possibleKeys = new ArrayList<>();
        for (Keypress keypress : currentCombo) {
            possibleKeys.clear();
            for (Combo combo : Combo.values()) {
                Keypress[] keys = combo.getKeys();
                if (keys.length < i) {
                    continue;
                } else {
                    possibleKeys.add(keys[i]);
                }
            }
            if (!possibleKeys.contains(keypress)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static Combo getCombo(ArrayList<Keypress> possibleCombo) {
        for (Combo combo : Combo.values()) {
            if (possibleCombo.equals(new ArrayList(Arrays.asList(combo.getKeys())))) {
                return combo;
            }
        }
        return null; 
    }
}

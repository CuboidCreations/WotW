package com.gmail.Xeiotos.WotW.Enums;

import com.gmail.Xeiotos.WotW.Skills.Jump;
import com.gmail.Xeiotos.WotW.Skills.Skill;

/**
 *
 * @author Xeiotos
 */
public enum Combo {
    JUMP(Jump.class, Keypress.LEFTMOUSE,Keypress.RIGHTMOUSE,Keypress.DOUBLEFORWARD);

    private Keypress[] keys;
    private  Class<? extends Skill> skill;
    
    private Combo(Class<? extends Skill> skill, Keypress... keys) {
        this.keys = keys;
        this.skill = skill;
    }

    public Keypress[] getKeys() {
        return keys;
    }

    public Class<? extends Skill> getSkill() {
        return skill;
    }

}

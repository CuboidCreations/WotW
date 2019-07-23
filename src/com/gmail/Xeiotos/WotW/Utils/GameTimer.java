package com.gmail.Xeiotos.WotW.Utils;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import com.gmail.Xeiotos.WotW.WotWGame;

/**
 *
 * @author Xeiotos
 */
public class GameTimer extends SimpleTimer {

    public GameTimer() {
        super((WotWGame.getInterimTime() + WotWGame.getSolsticeTime()), 1);
    }

    @Override
    public void run() {
        timeLeft = timeLeft - period;
        if (timeLeft > WotWGame.getSolsticeTime()) {
            WotWGame.getInstance().setGameStage(GameStage.INTERIM);
        } else if (timeLeft <= (WotWGame.getSolsticeTime()) && timeLeft > 0) {
            WotWGame.getInstance().setGameStage(GameStage.SOLSTICE);
        } else if (timeLeft <= 0) {
            resetGameTimer();
            WotWGame.getInstance().setGameStage(GameStage.INTERIM);
        }
    }

    public void resetGameTimer() {
        System.out.println(initialTime);
        timeLeft = initialTime;
    }
}

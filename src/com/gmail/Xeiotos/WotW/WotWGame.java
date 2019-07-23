package com.gmail.Xeiotos.WotW;

import com.gmail.Xeiotos.WotW.Enums.GameStage;
import com.gmail.Xeiotos.WotW.Events.GameStageChangeEvent;
import com.gmail.Xeiotos.WotW.Utils.GameTimer;
import org.bukkit.Bukkit;

/**
 *
 * @author Xeiotos
 */
public class WotWGame {

    private GameStage gameStage;
    private GameTimer gameTimer;
    private static WotWGame instance;
    private static long interimTime;
    private static long solsticeTime;

    public void start(long interimTime, long solsticeTime) {
        instance = this;
        
        WotWGame.interimTime = interimTime;
        WotWGame.solsticeTime = solsticeTime;
        
        gameStage = GameStage.INTERIM;

        this.gameTimer = new GameTimer();
        gameTimer.runTaskTimer(WotW.getInstance(), 1200L, 1200L);
    }

    public void setGameStage(GameStage gameStage) {
        if (gameStage != this.gameStage) {
            this.gameStage = gameStage;
            Bukkit.getServer().getPluginManager().callEvent(new GameStageChangeEvent(gameStage));
        }
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public static WotWGame getInstance() {
        return instance;
    }

    public static long getInterimTime() {
        return interimTime;
    }

    public static long getSolsticeTime() {
        return solsticeTime;
    }

    public GameTimer getGameTimer() {
        return gameTimer;
    }
    
    
}

package com.gmail.Xeiotos.WotW;

import com.gmail.Xeiotos.WotW.Listeners.ComboListener;
import com.gmail.Xeiotos.WotW.Listeners.GameStageChangeListener;
import com.gmail.Xeiotos.WotW.Listeners.KeypressListener;
import com.gmail.Xeiotos.WotW.Listeners.PlayerJoinListener;
import com.gmail.Xeiotos.WotW.Listeners.PlayerLeaveListener;
import com.gmail.Xeiotos.WotW.Listeners.ServerListPingListener;
import com.gmail.Xeiotos.WotW.Listeners.WorldChangeListener;
import com.gmail.Xeiotos.WotW.Managers.WotWPlayerManager;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Chris
 */
public class WotW extends JavaPlugin {
    
    private static WotW instance;
    private static long comboTimeout;
    private static int levelCap;
    private static Random randomGenerator = new Random();
    private static final WotWGame game = new WotWGame();

    @Override
    public void onEnable() {
        instance = this;
        
        saveDefaultConfig();
        
        comboTimeout = getConfig().getLong("comboTimeout");
        levelCap = getConfig().getInt("levelCap");
        
        Bukkit.getServer().getPluginManager().registerEvents(new ComboListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KeypressListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new GameStageChangeListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WorldChangeListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ServerListPingListener(), this);
        
        for (Player player: Bukkit.getOnlinePlayers()) {
            WotWPlayerManager.getManager().addPlayer(player);
        }
        
        game.start(getConfig().getLong("gameStages.interim"), getConfig().getLong("gameStages.solstice"));
    }

    public static long getComboTimeout() {
        return comboTimeout;
    }
    
    public static WotW getInstance() {
        return instance;
    }

    public static Random getRandomGenerator() {
        return randomGenerator;
    }

    public static WotWGame getGame() {
        return game;
    }

    public static int getLevelCap() {
        return levelCap;
    }
}

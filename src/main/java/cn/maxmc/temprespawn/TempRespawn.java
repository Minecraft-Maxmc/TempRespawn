package cn.maxmc.temprespawn;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TempRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("temprespawn").setExecutor(new RespawnCommand());
        Bukkit.getPluginManager().registerEvents(new DeathListen(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

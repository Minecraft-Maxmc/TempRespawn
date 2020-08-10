package cn.maxmc.temprespawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListen implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        if(RespawnCommand.getRespawnMap().containsKey(e.getPlayer())){
            e.setRespawnLocation(RespawnCommand.getRespawnMap().get(e.getPlayer()));
        }
    }
}

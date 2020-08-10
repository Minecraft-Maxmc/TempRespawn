package cn.maxmc.temprespawn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class RespawnCommand implements CommandExecutor {
    private static Map<Player, Location> respawnMap = new HashMap<>();

    public static Map<Player, Location> getRespawnMap() {
        return respawnMap;
    }

    private final static String MAXMC = "§6§lMAXMC §a§l>> ";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(MAXMC+"§c该指令只能由玩家执行");
            return true;
        }
        Player p = (Player) sender;
        if(args.length == 0){
            p.sendMessage(MAXMC+"§c参数错误,请重试");
            return true;
        }
        String sub = args[0];
        if(sub.equals("set")){
            if(args.length != 4){
                p.sendMessage(MAXMC+"§c参数错误,请重试");
                return true;
            }
            String xs = args[1];
            String ys = args[2];
            String zs = args[3];
            int x,y,z;
            if ((!isInt(xs)) || (!isInt(ys)) || (!isInt(zs))) {
                p.sendMessage(MAXMC+"§c坐标不合法");
                return true;
            }
            x = toInt(xs);
            y = toInt(ys);
            z = toInt(zs);
            Location loc = new Location(p.getWorld(),x,y,z);
            respawnMap.put(p,loc);
            p.sendMessage(MAXMC+"§a成功设置临时重生点");
            return true;
        }
        if(sub.equals("reset")){
            respawnMap.remove(p);
            p.sendMessage(MAXMC+"§a成功清除临时重生点");
            return true;
        }
        return true;
    }

    private boolean isInt(String intString){
        try {
            Integer.parseInt(intString);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private int toInt(String intString){
        return Integer.parseInt(intString);
    }
}

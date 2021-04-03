package xyz.n7mn.dev.yukigassen.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.n7mn.dev.yukigassen.YukiGassen;
import xyz.n7mn.dev.yukigassen.gamestate.GameState;


public class Start implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        GameState.setState(GameState.STARTING);
        new BukkitRunnable() {
            int timer = 10;
            @Override
            public void run() {
                if (timer > 0) {
                    Bukkit.broadcastMessage("ゲームは" + timer + "秒後に開始されます");
                    timer--;
                } else {
                    cancel();
                    GameState.setState(GameState.PLAYING);
                    Bukkit.broadcastMessage("ゲームが開始されました");
                }
            }
        }.runTaskTimer(JavaPlugin.getProvidingPlugin(YukiGassen.class), 0, 20);
        return true;
    }
}
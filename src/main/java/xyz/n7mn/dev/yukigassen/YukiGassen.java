package xyz.n7mn.dev.yukigassen;

import xyz.n7mn.dev.yukigassen.commands.Start;
import xyz.n7mn.dev.yukigassen.events.BlockEvent;
import xyz.n7mn.dev.yukigassen.events.DamageEvent;
import xyz.n7mn.dev.yukigassen.gamestate.GameState;
import org.bukkit.plugin.java.JavaPlugin;

public final class YukiGassen extends JavaPlugin {

    @Override
    public void onEnable() {
        GameState.setState(GameState.LOBBY);
        saveDefaultConfig();
        getCommand("start").setExecutor(new Start());
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockEvent(),this)
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
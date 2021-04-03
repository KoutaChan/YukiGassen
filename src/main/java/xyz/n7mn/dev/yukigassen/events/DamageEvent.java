package xyz.n7mn.dev.yukigassen.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import xyz.n7mn.dev.yukigassen.gamestate.GameState;

public class DamageEvent implements Listener {

    @EventHandler
    public void Damage(EntityDamageEvent event) {
        if(event.getEntityType() == EntityType.PLAYER) {
            if(GameState.getState() != GameState.PLAYING) {
                event.setCancelled(true);
            }
        }
    }
}

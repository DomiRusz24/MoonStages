package me.domirusz24.bq.bqmoonstage.bqmoonstage;

import org.bukkit.plugin.java.JavaPlugin;
import pl.betoncraft.betonquest.BetonQuest;

public final class BQMoonStage extends JavaPlugin {

    @Override
    public void onEnable() {
        BetonQuest.getInstance().registerConditions("moonstage", MoonStage.class);
    }
}

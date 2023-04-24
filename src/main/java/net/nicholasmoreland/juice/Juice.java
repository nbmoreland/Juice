package net.nicholasmoreland.juice;

import org.bukkit.plugin.java.JavaPlugin;

import net.nicholasmoreland.juice.client.ClientManager;

public class Juice extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ClientManager(), this);

        getLogger().info("Connected to server.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disconnected from server.");
    }

}

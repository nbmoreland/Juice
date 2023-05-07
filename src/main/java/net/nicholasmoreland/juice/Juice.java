package net.nicholasmoreland.juice;

import org.bukkit.plugin.java.JavaPlugin;

import net.nicholasmoreland.juice.client.ClientManager;
import net.nicholasmoreland.juice.database.DatabaseManager;

public class Juice extends JavaPlugin {

    public DatabaseManager dbm = new DatabaseManager("localhost", 27017, "project-cherry", "users");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ClientManager(dbm), this);

        getLogger().info("Connected to server.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disconnected from server.");
    }

}

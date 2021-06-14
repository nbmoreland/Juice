package net.nicholasmoreland.juice.client;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class ClientManager implements Listener {

    private final HashMap<UUID, Client> clientMap = new HashMap<>();

    public HashMap<UUID, Client> getClientMap() {
        return clientMap;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        String name = player.getName();
        Client client;

        if (name.equals("FaultyRam")) {
            client = new Client(name, ClientRank.DEV);
        } else {
            client = new Client(name);
        }
        clientMap.put(uuid, client);
        System.out.printf("%s with rank of %s has been added to client map.", name, client.getRank().toString());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        clientMap.remove(uuid);
        System.out.printf("%s has been removed from client map.", player.getName());
    }

}

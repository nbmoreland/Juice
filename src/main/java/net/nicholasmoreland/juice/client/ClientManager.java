package net.nicholasmoreland.juice.client;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ClientManager implements Listener {

    private final HashMap<String, Client> clientMap = new HashMap<>();

    public HashMap<String, Client> getClientMap() {
        return clientMap;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        Client client = new Client(name);

        if (name.equals("FaultyRam")) {
            client.setRank(ClientRank.DEV);
        }
        clientMap.put(name, client);
        player.setPlayerListName(client.getRank().toString() + " " + player.getName());
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        clientMap.remove(player.getName());
    }

    @EventHandler(priority = EventPriority.LOW)
    private void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        ClientRank rank = clientMap.get(player.getName()).getRank();

        event.setFormat(rank.toString() + " " + player.getName() + ": " + ChatColor.WHITE + event.getMessage());
    }

}

package net.nicholasmoreland.juice.client;

import org.bson.Document;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.nicholasmoreland.juice.database.DatabaseManager;

import java.util.HashMap;

public class ClientManager implements Listener {

    private final DatabaseManager dbm;
    private final HashMap<String, Client> clients;

    public ClientManager(DatabaseManager dbm) {
        this.dbm = dbm;
        this.clients = new HashMap<>();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        Client client = new Client(name);
        Document document = dbm.findUser(name);

        if (document == null) {
            dbm.addUser(player.getUniqueId().toString(), name, client.getRank().getName(), client.getAuth(),
                    client.getEmail());
        } else {
            client.setRank(ClientRank.valueOf(document.get("rank").toString().toUpperCase()));
            client.setAuth(true);
            client.setEmail("nmoreland18@outlook.com");
        }

        clients.put(name, client);
        player.setPlayerListName(client.getRank().toString() + " " + name);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        clients.remove(player.getName());
    }

    @EventHandler(priority = EventPriority.LOW)
    private void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        ClientRank rank = clients.get(player.getName()).getRank();

        event.setFormat(rank.toString() + " " + player.getName() + ": " + ChatColor.WHITE + event.getMessage());
    }

}

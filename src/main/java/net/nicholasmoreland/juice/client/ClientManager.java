package net.nicholasmoreland.juice.client;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    private final List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

}

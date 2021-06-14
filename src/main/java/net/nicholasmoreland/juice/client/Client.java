package net.nicholasmoreland.juice.client;

public class Client {

    private String name;
    private ClientRank rank;

    public Client(String name) {
        this.name = name;
        this.rank = ClientRank.GUEST;
    }

    public Client(String name, ClientRank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setRank(ClientRank rank) {
        this.rank = rank;
    }

    public ClientRank getRank() {
        return rank;
    }

}

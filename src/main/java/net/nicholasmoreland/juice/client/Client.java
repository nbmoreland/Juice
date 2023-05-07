package net.nicholasmoreland.juice.client;

public class Client {

    private String name;
    private ClientRank rank;
    private boolean auth;
    private String email;

    public Client(String name) {
        this.name = name;
        this.rank = ClientRank.GUEST;
        this.auth = false;
        this.email = "";
    }

    public Client(String name, ClientRank rank, boolean auth, String email) {
        this.name = name;
        this.rank = rank;
        this.auth = auth;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setAuth(boolean option) {
        this.auth = option;
    }

    public boolean getAuth() {
        return auth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}

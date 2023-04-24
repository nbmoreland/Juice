package net.nicholasmoreland.juice.client;

import org.bukkit.ChatColor;

public enum ClientRank {

    DEV("Developer", ChatColor.LIGHT_PURPLE),
    GUEST("Guest", ChatColor.GRAY);

    private final String name;
    private final ChatColor chatColor;

    ClientRank(String name, ChatColor chatColor) {
        this.name = name;
        this.chatColor = chatColor;
    }

    public ChatColor geChatColor() {
        return this.chatColor;
    }

    @Override
    public String toString() {
        return this.chatColor + "[" + this.name + "]";
    }
}

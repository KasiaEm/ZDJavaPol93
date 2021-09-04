package sda.ex.ex24;

import java.util.HashMap;
import java.util.Map;

public class User implements Subscriber {
    private String username;
    private String password;
    private Map<Chat, Integer> messagesFromChats = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Map<Chat, Integer> getMessagesFromChats() {
        return messagesFromChats;
    }

    @Override
    public void update(Chat chat) {
        messagesFromChats.put(chat, messagesFromChats.get(chat) + 1);
    }
}

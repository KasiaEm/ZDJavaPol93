package sda.ex.ex24;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public String getPassword() {
        return password;
    }

    public Map<Chat, Integer> getMessagesFromChats() {
        return messagesFromChats;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void update(Chat chat) {
        messagesFromChats.put(chat, messagesFromChats.get(chat) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }
}

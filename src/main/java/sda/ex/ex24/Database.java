package sda.ex.ex24;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashSet;
import java.util.Set;

public class Database {
    private Set<User> users = new HashSet<>();
    private String loggedIn;

    public void addUser(User newUser) throws DBException {
        boolean found = users.stream()
                .anyMatch(u -> u.getUsername().equals(newUser.getUsername()));
        if (found) {
            throw new DBException("User already exists!");
        } else {
            String hash = DigestUtils.md5Hex(newUser.getPassword());
            newUser.setPassword(hash);
            users.add(newUser);
        }
    }

    public User login(User toLogin) throws DBException {
        String hash = DigestUtils.md5Hex(toLogin.getPassword());
        toLogin.setPassword(hash);
        User dbUser = users.stream()
                .filter(u -> u.equals(toLogin))
                .findAny()
                .orElseThrow(() -> new DBException("Invalid username or password!"));
        loggedIn = toLogin.getUsername();
        return dbUser;
    }
}

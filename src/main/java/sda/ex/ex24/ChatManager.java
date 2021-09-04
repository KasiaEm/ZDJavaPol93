package sda.ex.ex24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChatManager {
    private static Set<Chat> chats = new HashSet<>();
    private static Database database;

    public static void main(String[] args) {
        prepareData();
        printHelp();

        String line = "";
        User loggedIn = null;
        Chat selectedChat = null;

        while (!line.equals("-exit")) {
            Scanner sc = new Scanner(System.in);
            if (loggedIn != null) System.out.print("[" + loggedIn.getName() + "] ");
            line = sc.nextLine();

            if (line.equals("-login")) {
                System.out.print("[username]");
                String username = sc.nextLine();
                System.out.print("[password]");
                String password = sc.nextLine();
                try {
                    loggedIn = database.login(new User(username, password));
                    System.out.println("[New messages]");
                    loggedIn.getMessagesFromChats().forEach((k, v) -> System.out.println(k.getChatName() + " [" + v + "]"));

                } catch (DBException e) {
                    System.out.println(e.getMessage());
                }
            } else if (line.equals("-chats")) {
                if (loggedIn == null) {
                    System.out.println("You're not logged in.");
                } else if (loggedIn.getMessagesFromChats() == null || loggedIn.getMessagesFromChats().size() == 0) {
                    System.out.println("You're not subscribing any chats.");
                } else {
                    int chatsAmount = loggedIn.getMessagesFromChats().size();
                    int i = 0;
                    Chat[] chatTable = new Chat[chatsAmount];
                    System.out.println("[Select chat]");
                    for (Chat chat : loggedIn.getMessagesFromChats().keySet()) {
                        chatTable[i] = chat;
                        System.out.println("[" + (i++) + "] " + chat.getChatName());
                    }
                    int nr = -1;
                    while (nr < 0 || nr >= chatsAmount) {
                        nr = sc.nextInt();
                    }
                    selectedChat = chatTable[nr];
                    loggedIn.getMessagesFromChats().put(selectedChat, 0);
                    System.out.println(selectedChat.getChatHistory());
                }
            } else if (line.equals("-logout")) {
                database.logout();
                loggedIn = null;
                selectedChat = null;
            } else {
                if (selectedChat != null) {
                    selectedChat.updateChatHistory("[" + loggedIn.getName() + "] " + line);
                    selectedChat.notifyAllUsers();
                    loggedIn.getMessagesFromChats().put(selectedChat, 0);
                }
            }
        }
    }

    public static void printHelp() {
        System.out.println("_____________________ \n"
                + "Type \n"
                + "-exit to exit \n"
                + "-login to login \n"
                + "-chats to select chat \n"
                + "-logout to logout \n"
                + "_____________________ \n");
    }

    public static void prepareData() {
        database = Database.getConnection();
        Chat chatJava = new Chat("Java");
        Chat chatCPP = new Chat("C++");
        User u1 = new User("John", "john1");
        User u2 = new User("Mary", "mary1");
        User u3 = new User("Dave", "dave1");
        User u4 = new User("Tina", "tina1");
        try {
            database.addUser(u1);
            database.addUser(u2);
            database.addUser(u3);
            database.addUser(u4);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        chatJava.addSubscriber(u1);
        chatJava.addSubscriber(u2);
        chatJava.addSubscriber(u3);
        chatCPP.addSubscriber(u3);
        chatCPP.addSubscriber(u4);
        chats.add(chatJava);
        chats.add(chatCPP);
    }
}

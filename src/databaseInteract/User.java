package databaseInteract;

import java.util.ArrayList;

//In construction. Not working yet
public class User {
    private String name;
    private String login;
    private String password;
    private ArrayList<Program> Programs;

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Program> getPrograms() {
        return Programs;
    }

    public User(String name, String login, String password, ArrayList<Program> Programs) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.Programs = Programs;
    }
}
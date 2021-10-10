package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Stas", "Kosyy", (byte) 21);
        usi.saveUser("Nikita", "Boloto", (byte) 31);
        usi.saveUser("Kostya", "Mel", (byte) 15);
        usi.saveUser("Masha", "Trofimova", (byte) 20);
        ArrayList<User> users = (ArrayList<User>) usi.getAllUsers();
        for (User user: users) {
            System.out.println(user);
        }
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}

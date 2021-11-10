package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Stas", "Kosyy", (byte)21);
        userService.saveUser("BBBB", "BBBB", (byte)21);
        userService.saveUser("CCCC", "CCCC", (byte)21);
        userService.saveUser("DDDDD", "DDD", (byte)21);
        userService.saveUser("FFF", "FFF", (byte)21);
        userService.removeUserById(1);
        List<User> users = userService.getAllUsers();
        System.out.println("Пользователи в таблице:");
        for (User us : users) {
            System.out.println(us);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

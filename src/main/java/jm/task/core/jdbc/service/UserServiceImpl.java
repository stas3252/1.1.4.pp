package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl udJDBCI = new UserDaoJDBCImpl();
    public void createUsersTable() {
        udJDBCI.createUsersTable();
    }

    public void dropUsersTable() {
        udJDBCI.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udJDBCI.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        udJDBCI.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return udJDBCI.getAllUsers();
    }

    public void cleanUsersTable() {
        udJDBCI.cleanUsersTable();
    }
}

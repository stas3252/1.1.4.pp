package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao UDHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        UDHibernate.createUsersTable();
    }

    public void dropUsersTable() {
        UDHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UDHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UDHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UDHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        UDHibernate.cleanUsersTable();
    }
}

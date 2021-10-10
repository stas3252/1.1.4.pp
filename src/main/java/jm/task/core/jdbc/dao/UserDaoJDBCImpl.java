package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util DB = new Util();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS USERS " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " name VARCHAR(50), " +
                " lastName VARCHAR (50), " +
                " age INTEGER NOT NULL, " +
                " PRIMARY KEY (id))";
        try {
            DB.statement.executeUpdate(SQL);
            System.out.println("Таблица USERS успешно создана!");
        } catch (SQLException e) {
            System.out.println("Таблица USERS не создана!");
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE USERS";
        try {
            DB.statement.executeUpdate(sql);
            System.out.println("таблица USERS успешно удалена!");
        } catch (SQLException e) {
            System.out.println("ERR! таблица USERS не удалена!");
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String data = "INSERT USERS(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
        try {
            DB.statement.executeUpdate(data);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            System.out.println("не удалось USER - " + name + " добавить в базу данных");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM USERS WHERE id=" + id;
        try {
            DB.statement.executeUpdate(sql);
            System.out.println("User с Id = " + id + " удален из таблицы USERS!");
        } catch (SQLException e) {
            System.out.println("ERR! не удалось удалить User с Id = " + id + " из таблицы USERS!");
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM USERS";
        ResultSet res;
        List<User> users = new ArrayList<>();

        try {
            res = DB.statement.executeQuery(sql);
            System.out.println("Все данные считаны!");
            int columns = res.getMetaData().getColumnCount();

            while (res.next()) {
                long id = Integer.parseInt(res.getString(1));
                String name = res.getString(2);
                String lastName = res.getString(3);
                byte age = (byte)Integer.parseInt(res.getString(4));
                User user = new User(name, lastName, age);
                user.setId(id);
                users.add(user);
            }

        } catch (SQLException e) {
            System.out.println("ERR! не удалось считать все данные!");
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM USERS";

        try {
            DB.statement.executeUpdate(sql);
            System.out.println("таблица USERS успешно очищена!");
        } catch (SQLException e) {
            System.out.println("ERR! таблица USERS не очищена!");
            e.printStackTrace();
        }
    }
}

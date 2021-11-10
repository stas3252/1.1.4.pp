package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Util DB = new Util();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS USERS " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " name VARCHAR(50), " +
                " lastName VARCHAR (50), " +
                " age TINYINT NOT NULL, " +
                " PRIMARY KEY (id))";
        try {
            Session session = DB.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(SQL).addEntity(User.class);
            transaction.commit();
            System.out.println("Таблица USERS успешно создана!");
        } catch (HibernateError e) {
            System.out.println("Таблица USERS не создана!");
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = DB.getSessionFactory().getCurrentSession();
        session.createSQLQuery("DROP TABLE IF EXISTS USERS").addEntity(User.class);
        System.out.println("таблица удалена");
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Session session = DB.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        System.out.println("Добавили USER!");
    }

    @Override
    public void removeUserById(long id) {
        Session session = DB.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        System.out.println("User удален");
    }

    @Override
    public List<User> getAllUsers() {
        Session session = DB.getSessionFactory().getCurrentSession();
        return session.createCriteria(User.class).list();
    }

    @Override
    public void cleanUsersTable() {
        Session session = DB.getSessionFactory().getCurrentSession();
        final List<?> instances = session.createCriteria(User.class).list();
        for (Object obj : instances) {
            session.delete(obj);
        }
        System.out.println("Таблица очищена!");
    }
}

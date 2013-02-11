package com.in6k.mypal.dao;

import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;

public class UserDao {

    public static void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static User getById(Integer id) throws SQLException {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return user;
    }


}

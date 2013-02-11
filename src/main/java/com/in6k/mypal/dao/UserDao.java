package com.in6k.mypal.dao;

import com.in6k.mypal.domain.User;
import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Session;

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
}

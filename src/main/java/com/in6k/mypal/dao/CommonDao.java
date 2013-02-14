package com.in6k.mypal.dao;

import com.in6k.mypal.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CommonDao {
    public static List executeQuery(String queryString) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(queryString);
        List result = query.list();

        session.getTransaction().commit();
        session.close();

        return result;
    }

    public static void clearTable(String tableName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("delete from " + tableName + ";").executeUpdate();
        session.createSQLQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

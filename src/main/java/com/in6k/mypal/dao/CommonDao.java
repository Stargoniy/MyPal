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
}

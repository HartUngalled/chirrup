package com.no_company.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessions {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getConfiguredSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() throws HibernateException {
        sessionFactory.close();
    }

}

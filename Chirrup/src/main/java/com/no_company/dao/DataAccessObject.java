package com.no_company.dao;

import com.no_company.model.ModelEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.no_company.util.HibernateSessions.getConfiguredSession;

public abstract class DataAccessObject<T extends ModelEntity> {

    public Class<T> aClass;

    public Integer add(T entity) {
        Session session = null;
        Transaction tx = null;
        Integer userID = null;
        try {
            session = getConfiguredSession();
            tx = session.beginTransaction();
            userID = (Integer) session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }

    public T get(int id) {
        Transaction tx = null;
        T entity = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            entity = session.get(aClass, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return entity;
    }

    public List<T> getAll() {
        Transaction tx = null;
        List<T> allEntities = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allEntities = session.createQuery("FROM " + aClass.getSimpleName() ).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allEntities;
    }

}
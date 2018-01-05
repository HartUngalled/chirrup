package com.no_company.dao;

import com.no_company.model.ModelEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.no_company.util.HibernateSessions.getConfiguredSession;

public abstract class DataAccessObject<T extends ModelEntity> {

    public Class<T> entityClass;

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
            entity = session.get(entityClass, id);
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
            allEntities = session.createQuery("FROM " + entityClass.getSimpleName() ).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allEntities;
    }

    public Integer remove(int id) {
        Transaction tx = null;
        Integer removalCounter = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            T entity = session.get(entityClass, id);
            tx.commit();
            try {
                session.delete(entity);
                removalCounter = 1;
            } catch (IllegalArgumentException iae) {
                removalCounter = 0;
            }
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        }
        return removalCounter;
    }

    public T pool (int id) {
        Transaction tx = null;
        T entity = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            entity = session.get(entityClass, id);
            session.delete(entity);
            tx.commit();
        } catch (HibernateException | IllegalArgumentException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return entity;
    }

    public void update (T entity) {
        Transaction tx = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException | IllegalArgumentException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

}
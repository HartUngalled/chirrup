package com.no_company.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.no_company.util.HibernateSessions.getConfiguredSession;

public class DataAccessObject {

    public Integer add(Object entity) {
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

    public UsersEntity getUser(int userID) {
        Transaction tx = null;
        UsersEntity user = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            user = session.get(UsersEntity.class, userID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public PostsEntity getPost(int postID) {
        Transaction tx = null;
        PostsEntity user = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            user = session.get(PostsEntity.class, postID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public List<UsersEntity> getAllUsers() {
        Transaction tx = null;
        List<UsersEntity> allUsers = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allUsers = session.createQuery("FROM UsersEntity ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allUsers;
    }

    public List<PostsEntity> getAllPosts() {
        Transaction tx = null;
        List<PostsEntity> allPosts = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allPosts = session.createQuery("FROM PostsEntity ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allPosts;
    }

    public UsersEntity getUserByNickname(String nickname) {
        List<UsersEntity> allUsers = getAllUsers();
        for (UsersEntity user : allUsers) {
            if (user.getNickname().equalsIgnoreCase(nickname)) return user;
        }
        return null;
    }

}

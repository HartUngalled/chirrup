package com.no_company.dao;

import com.no_company.model.Posts;
import com.no_company.model.Users;
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

    public Users getUser(int userID) {
        Transaction tx = null;
        Users user = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            user = session.get(Users.class, userID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public Posts getPost(int postID) {
        Transaction tx = null;
        Posts post = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            post = session.get(Posts.class, postID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return post;
    }

    public List<Users> getAllUsers() {
        Transaction tx = null;
        List<Users> allUsers = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allUsers = session.createQuery("FROM Users ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allUsers;
    }

    public List<Posts> getAllPosts() {
        Transaction tx = null;
        List<Posts> allPosts = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allPosts = session.createQuery("FROM Posts ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return allPosts;
    }

    public Users getUserByNickname(String nickname) {
        List<Users> allUsers = getAllUsers();
        for (Users user : allUsers) {
            if (user.getNickname().equalsIgnoreCase(nickname)) return user;
        }
        return null;
    }

}
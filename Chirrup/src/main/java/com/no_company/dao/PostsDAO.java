package com.no_company.dao;

import com.no_company.model.Post;
import com.no_company.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

import static com.no_company.util.HibernateSessions.getConfiguredSession;

public class PostsDAO extends DataAccessObject<Post> {

    public PostsDAO() {
        entityClass = Post.class;
    }

    public List<Post> getAllReverse() {
        List<Post> allPosts = getAll();
        Collections.reverse(allPosts);
        return allPosts;
    }

    public List<Post> getAllUserPostsReverse(int userID) {
        Transaction tx = null;
        List<Post> allPosts = null;
        try (Session session = getConfiguredSession()) {
            tx = session.beginTransaction();
            allPosts = session.createQuery("FROM Post WHERE user.id = " + userID).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        Collections.reverse(allPosts);
        return allPosts;
    }

}

package com.no_company.dao;

import com.no_company.model.Post;

import java.util.Collections;
import java.util.List;

public class PostsDAO extends DataAccessObject<Post> {

    public PostsDAO() {
        aClass = Post.class;
    }

    public List<Post> getAllReverse() {
        List<Post> allPosts = getAll();
        Collections.reverse(allPosts);
        return allPosts;
    }

}

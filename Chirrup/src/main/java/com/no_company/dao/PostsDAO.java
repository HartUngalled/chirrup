package com.no_company.dao;

import com.no_company.model.Posts;

public class PostsDAO extends DataAccessObject<Posts> {

    public PostsDAO() {
        aClass = Posts.class;
    }

}

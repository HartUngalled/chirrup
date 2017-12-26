package com.no_company.dao;

import com.no_company.model.User;

import java.util.List;

public class UsersDAO extends DataAccessObject<User> {

    public UsersDAO() {
        entityClass = User.class;
    }

    public User getByNickname(String nickname) {
        List<User> allUsers = getAll();
        for (User user : allUsers) {
            if (user.getNickname().equalsIgnoreCase(nickname)) return user;
        }
        return null;
    }

}

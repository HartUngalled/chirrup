package com.no_company.dao;

import com.no_company.model.Users;

import java.util.List;

public class UsersDAO extends DataAccessObject<Users> {

    public UsersDAO() {
        aClass = Users.class;
    }

    public Users getByNickname(String nickname) {
        List<Users> allUsers = getAll();
        for (Users user : allUsers) {
            if (user.getNickname().equalsIgnoreCase(nickname)) return user;
        }
        return null;
    }

}

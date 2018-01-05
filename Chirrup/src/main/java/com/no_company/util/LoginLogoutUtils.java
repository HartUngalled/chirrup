package com.no_company.util;

import com.no_company.dao.UsersDAO;
import com.no_company.model.User;
import lombok.Getter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginLogoutUtils {

    public static final String AUTHOR_COOKIE = "User";

    private HttpServletRequest request;
    private HttpServletResponse response;
    @Getter private User loggedUser;

    public LoginLogoutUtils(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        readUserFromCookie();
    }

    private void readUserFromCookie() {

        if (request.getCookies() == null) return;

        for (Cookie cookie : request.getCookies()) {
            if ( AUTHOR_COOKIE.equals(cookie.getName()) ) {

                int userId = Integer.parseInt( cookie.getValue() );

                UsersDAO dao = new UsersDAO();
                loggedUser = dao.get(userId);

                return;

            }
        }
    }



}

package com.no_company.servlets;

import com.google.common.base.Strings;
import com.no_company.dao.UsersDAO;
import com.no_company.model.User;
import com.no_company.util.LoginLogoutUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");

        if ( Strings.isNullOrEmpty(nickname) || Strings.isNullOrEmpty(password) ) {
            resp.sendRedirect("/index.jsp?login_error");
        } else {

            UsersDAO dao = new UsersDAO();
            User registeredUser = dao.getByNickname(nickname);

            if (registeredUser != null && registeredUser.getPassword().contentEquals(password)) {

                Cookie cookie = new Cookie( LoginLogoutUtils.AUTHOR_COOKIE,
                                            String.valueOf(registeredUser.getId()) );
                resp.addCookie(cookie);
                resp.sendRedirect("index.jsp");

            } else {
                resp.sendRedirect("/index.jsp?login_error");
            }

        }
    }

}

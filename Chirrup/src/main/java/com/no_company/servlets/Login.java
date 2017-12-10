package com.no_company.servlets;

import com.google.common.base.Strings;
import com.no_company.dao.DataAccessObject;
import com.no_company.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {

    public static final String AUTHOR_COOKIE = "author-cookie";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        Cookie cookie = new Cookie(AUTHOR_COOKIE, user);

        DataAccessObject dao = new DataAccessObject();
        List<Users> allRegisteredUsers = dao.getAllUsers();

        if ( Strings.isNullOrEmpty(user) && Strings.isNullOrEmpty(password) ) {
            resp.sendRedirect("/index.jsp?login_error");
        } else {

            Users registeredUser = dao.getUserByNickname(user);
            if (registeredUser != null && registeredUser.getPassword().contentEquals(password)) {
                resp.addCookie(cookie);
                resp.sendRedirect("index.jsp");
            } else {
                resp.sendRedirect("/index.jsp?login_error");
            }

        }
    }

}

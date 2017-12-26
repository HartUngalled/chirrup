package com.no_company.servlets;

import com.google.common.base.Strings;
import com.no_company.dao.UsersDAO;
import com.no_company.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nickname = req.getParameter("nickname" );
        String password = req.getParameter("password" );
        String passwordReply = req.getParameter("passwordReply" );

        if (    Strings.isNullOrEmpty(nickname) ||
                Strings.isNullOrEmpty(password) ||
                Strings.isNullOrEmpty(passwordReply)) {

            resp.sendRedirect("/register.jsp?empty_fields" );

        } else if (!password.contentEquals(passwordReply)) {

            resp.sendRedirect("/register.jsp?password_different" );

        } else {

            User user = User.builder().nickname(nickname).password(password).build();
            UsersDAO dao = new UsersDAO();
            dao.add(user);
            resp.sendRedirect("/index.jsp" );

        }

    }
}

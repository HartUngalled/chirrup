package com.no_company.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Logout", value = "/logout")
public class Logout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for (Cookie cookie : req.getCookies()) {
            Cookie nullCookie = new Cookie(Login.AUTHOR_COOKIE, null);
            if (Login.AUTHOR_COOKIE.contentEquals( cookie.getName() )) {
                nullCookie.setPath( cookie.getPath() );
                nullCookie.setMaxAge(0);
                resp.addCookie(nullCookie);
            }
        }

        resp.sendRedirect("index.jsp");
    }
}

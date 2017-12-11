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

        /**
         *      Remove cookie by add new null cookie on the same patch.
         *      Complicated, but simple setMaxAge(0) didn't work.
         */
        for (Cookie cookie : req.getCookies()) {
            if (Login.AUTHOR_COOKIE.contentEquals( cookie.getName() )) {
                Cookie nullCookie = new Cookie(Login.AUTHOR_COOKIE, null);
                nullCookie.setPath( cookie.getPath() );
                nullCookie.setMaxAge(0);
                resp.addCookie(nullCookie);
            }
        }

        resp.sendRedirect("index.jsp");
    }
}

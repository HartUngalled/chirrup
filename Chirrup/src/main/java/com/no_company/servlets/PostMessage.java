package com.no_company.servlets;

import com.no_company.dao.DataAccessObject;
import com.no_company.model.Posts;
import com.no_company.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "postMessage", value = "/postMessage")
public class PostMessage extends HttpServlet{

    DataAccessObject dao = new DataAccessObject();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = dao.getUserByNickname( req.getParameter("author") );
        Posts chirp = new Posts();
        chirp.setMessage( req.getParameter("message") );
        chirp.setTime(Date.from( Instant.now() ));
        chirp.setUser(user);
        dao.add(chirp);

        resp.sendRedirect("index.jsp");
    }
}

package com.no_company.servlets;

import com.no_company.dao.PostsDAO;
import com.no_company.dao.UsersDAO;
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

@WebServlet(name = "postMessage", value = "/postMessage")
public class PostMessage extends HttpServlet{

    private UsersDAO usersDAO = new UsersDAO();
    private PostsDAO postsDAO = new PostsDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = usersDAO.getByNickname( req.getParameter("author") );

        Posts post = new Posts();
        post.setMessage( req.getParameter("message") );
        post.setTime(Date.from( Instant.now() ));
        post.setUser(user);
        postsDAO.add(post);

        resp.sendRedirect("index.jsp");
    }
}

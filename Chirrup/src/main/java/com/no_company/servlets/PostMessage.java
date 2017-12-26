package com.no_company.servlets;

import com.no_company.dao.PostsDAO;
import com.no_company.model.Post;
import com.no_company.model.User;
import com.no_company.util.LoginLogoutUtils;

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

    private PostsDAO dao = new PostsDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginLogoutUtils loginLogoutUtils = new LoginLogoutUtils(req, resp);
        User user = loginLogoutUtils.getLoggedUser();
        String message = req.getParameter("message");
        Date time = Date.from( Instant.now() );

        Post post = Post.builder().message(message).time(time).user(user).build();
        dao.add(post);

        resp.sendRedirect("index.jsp");
    }
}

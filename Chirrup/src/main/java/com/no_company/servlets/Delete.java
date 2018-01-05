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

@WebServlet(name = "Delete", value = "/delete")
public class Delete extends HttpServlet {

    private PostsDAO dao = new PostsDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginLogoutUtils loginLogoutUtils = new LoginLogoutUtils(req, resp);
        User loggedUser = loginLogoutUtils.getLoggedUser();

        int postId = Integer.parseInt( req.getParameter("post_id") );
        Post postToDelete = dao.get(postId);

        if (postToDelete == null) {
            resp.sendRedirect("index.jsp?edit_error=\"post\"");
        } else if (loggedUser == null || loggedUser.getId() != postToDelete.getUser().getId()) {
            resp.sendRedirect("index.jsp?edit_error=\"auth\"");
        } else {
            int flag = dao.remove(postId);
            resp.sendRedirect("index.jsp");
        }

    }


}

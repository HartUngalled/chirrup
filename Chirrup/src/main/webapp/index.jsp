
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="com.no_company.util.LoginLogoutUtils" %>
<%@ page import="com.no_company.model.Users" %>
<%@ page import="com.no_company.dao.PostsDAO" %>
<%@ page import="com.no_company.model.Posts" %>

<html>

<head>
</head>

<body>

<%
    LoginLogoutUtils loginLogoutUtils = new LoginLogoutUtils(request, response);
    Users loggedUser = loginLogoutUtils.getLoggedUser();
%>

<p align="right">
    <%
        if (loggedUser == null)
            out.print("<a href=\"/login.jsp\">Login</a>");
        else
            out.print("<a href=\"/logout\">Logout</a>");
    %>
    <a href="/register.jsp">Register</a>

</p>


<p align="center">
    Hello
    <%
        if (loggedUser != null) {
            out.print( "@" + loggedUser.getNickname() + "<br>" );
            out.print( "Do you want to <a href=\"/post.jsp\">post</a> a message?" );
        } else {
            out.print( "!<br>" );
            out.print( "You need to log in in order to post a messages" );
        }
    %>
</p>

<p align="left">
<%
    /**
     *  Display all posts from db in reverse order (newest on top)
     */
    PostsDAO dao = new PostsDAO();
    List<Posts> allPosts = dao.getAll();
    Collections.reverse(allPosts);
    for (Posts post : allPosts) {
        String author = post.getUser().getNickname();
        out.print( "Author: @" + author + "<br>" );
        out.print( "Posted " + post.getPrettyTime() + "<br>" );
        out.print( "Message: " + post.getMessage() + "<br>" );

        if (loggedUser != null && loggedUser.getNickname().contentEquals(author) ) {
            out.print("<a href=\"/edit.jsp\">Edit</a> ");
            out.print("<a href=\"/delete.jsp\">Delete</a><br>");
        }

        out.print( "<br>" );
    }
%>
</p>

</body>

</html>

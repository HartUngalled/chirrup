<%@ page import="com.no_company.servlets.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="com.no_company.model.Posts" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.no_company.dao.PostsDAO" %>
<html>

<head>

    <%! String author; %>

    <%
        for (Cookie cookie : request.getCookies()) {
            if (Login.AUTHOR_COOKIE.contentEquals( cookie.getName() ) ) {
                author = cookie.getValue();
                break;
            } else {
                author = "guest";
            }
        }
    %>

    <form action="/login" method="post">
        <p align="right">
            User: <input name="user"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" name="login" value="Login">
        </p>
    </form>

    <form action="/logout" method="post">
        <p align="right">
            Logged user: <%= author %> <br>
            <input type="submit" name="logout" value="Logout">
        </p>
    </form>

</head>

<body>

    <form action="/postMessage" method="post">
        <p align="center">
            Message: <br><textarea name="message"></textarea><br>
            <input type="hidden" name="author" value=<%=author%>>
            <input type="submit" name="submit" value="Submit">
        </p>
    </form>

    <%
        /**
         *  Display all posts from db in reverse order (newest on top)
         */
        PostsDAO dao = new PostsDAO();
        List<Posts> allPosts = dao.getAll();
        Collections.reverse(allPosts);
        for (Posts post : allPosts) {
            out.print( "Author: " + post.getUser().getNickname() + "<br>" );
            out.print( "Message: " + post.getMessage() + "<br>" );
            out.print( "At: " + post.getTime() + "<br><br>" );
        }
    %>

</body>

</html>

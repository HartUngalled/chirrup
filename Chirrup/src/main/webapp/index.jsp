<%@ page import="java.util.List" %>
<%@ page import="com.no_company.dao.PostsDAO" %>
<%@ page import="com.no_company.model.Post" %>

<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <%@include file="header.jsp"%>
</head>

<body>


<div class="centerInfo">
    <%
        if (loggedUser == null) {
            out.print( "Hello stranger!<br>" +
                    "You need to <a href=\"/login.jsp\">log in</a> to post messages" );
        } else {
            out.print( "Hello @" + loggedUser.getNickname() + "!<br>" +
                    "Do you want to <a href=\"/post.jsp\">post</a> a message?" );
        }
    %>
</div>

<%--
        Show Messages
--%>
<br><br>
<%
    PostsDAO dao = new PostsDAO();
    List<Post> allPosts = dao.getAllReverse();

    for (Post post : allPosts) {
        String author = post.getUser().getNickname();
        out.print( "Author: @" + author + "<br>" );
        out.print( "Posted " + post.getPrettyTime() + "<br>" );
        out.print( "Message: " + post.getMessage() + "<br>" );

        if (loggedUser != null && loggedUser.getNickname().contentEquals(author) ) {
            out.print("<a href=\"/edit.jsp?post_id=" + post.getId() + "\">Edit</a> ");
            out.print("<a href=\"/delete.jsp?post_id=" + post.getId() + "\">Delete</a><br>");
        }

        out.print( "<br>" );
    }
%>

</body>
</html>

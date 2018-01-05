<%@ page import="com.no_company.dao.PostsDAO" %>
<%@ page import="com.no_company.model.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <%@include file="header.jsp"%>
</head>
<body>

<%
    PostsDAO dao = new PostsDAO();
    int deletedPostId = Integer.parseInt( request.getParameter("post_id") );
    Post postToDelete = dao.get(deletedPostId);
%>

<form action="/delete" method="post">
    <dif class="centerInfo">
        Do you really want to delete this post? <br><br>
        <diff>
            Author: @<%=postToDelete.getUser().getNickname()%> <br>
            Posted <%=postToDelete.getPrettyTime()%> <br>
            Message: <%=postToDelete.getMessage()%> <br>
        </diff>
        <input type="hidden" name="post_id" value=<%=deletedPostId%>>
        <input type="submit" name="submit" value="Delete">
    </dif>
</form>

</body>
</html>
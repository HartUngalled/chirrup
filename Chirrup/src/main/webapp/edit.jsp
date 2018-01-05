<%@ page import="com.no_company.model.Post" %>
<%@ page import="com.no_company.dao.PostsDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <%@include file="header.jsp"%>
</head>
<body>

<%
    PostsDAO dao = new PostsDAO();
    int editedPostId = Integer.parseInt( request.getParameter("post_id") );
    Post postToEdit = dao.get(editedPostId);
%>

<form action="/edit" method="post">
    <div class="centerInfo">
        Message: <br><textarea name="message"><%= postToEdit.getMessage() %></textarea><br>
        <input type="hidden" name="post_id" value=<%=editedPostId%>>
        <input type="submit" name="submit" value="Submit">
    </div>
</form>

</body>
</html>
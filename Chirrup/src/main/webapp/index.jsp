<%@ page import="com.google.common.base.Strings" %>
<html>
<head>
    <p align="right">
        <form action="/login" method="post">
            User: <input name="user"><br>
            password: <input type="password" name="password"><br>
            <input type="submit" name="login" value="Login">
        </form>
    </p>
</head>
<body>

<%
    String error = request.getParameter("login_error");
    if ( error != null ) {
        out.println("Wrong username or password!");
    }
%>

</body>
</html>

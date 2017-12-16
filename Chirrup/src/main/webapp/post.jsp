<%@ page import="com.no_company.model.Users" %>
<%@ page import="com.no_company.util.LoginLogoutUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<%
    LoginLogoutUtils loginLogoutUtils = new LoginLogoutUtils(request, response);
    Users loggedUser = loginLogoutUtils.getLoggedUser();
%>

<form action="/postMessage" method="post">
    <p align="center">
        Message: <br><textarea name="message"></textarea><br>
        <input type="submit" name="submit" value="Submit">
    </p>
</form>

</body>
</html>
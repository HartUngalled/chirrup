<%@ page import="com.no_company.model.User" %>
<%@ page import="com.no_company.util.LoginLogoutUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<%
    LoginLogoutUtils loginLogoutUtils = new LoginLogoutUtils(request, response);
    User loggedUser = loginLogoutUtils.getLoggedUser();
%>

<div class="mainPage">
    <a href="/index.jsp">Main Page</a>
</div>

<div class="loginLogoutRegister">
    <%
        if (loggedUser == null)
            out.print("<a href=\"/login.jsp\">Login</a>");
        else
            out.print("<a href=\"/logout\">Logout</a>");
    %>
    <a href="/register.jsp">Register</a>
</div>

</body>
</html>

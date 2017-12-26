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

<dif class="mainPage">
    <a href="/index.jsp">Main Page</a>
</dif>

<dif class="loginLogoutRegister">
    <%
        if (loggedUser == null)
            out.print("<a href=\"/login.jsp\">Login</a>");
        else
            out.print("<a href=\"/logout\">Logout</a>");
    %>
    <a href="/register.jsp">Register</a>
</dif>

</body>
</html>

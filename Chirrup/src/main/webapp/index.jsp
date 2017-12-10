<html>

<head>

    <%! String author = "guest"; %>

    <%
        for (Cookie cookie : request.getCookies()) {
            if ("Logged_user_cookie".contentEquals( cookie.getName() ) ) {
                author = cookie.getValue();
                break;
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

    <form action="/login" method="post">
        <p align="right">
            Logged user: <%= author %> <br>
            <input type="submit" name="logout" value="Logout">
        </p>
    </form>


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

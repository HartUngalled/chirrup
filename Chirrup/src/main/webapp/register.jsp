<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>

<body>
<form action="/register" method="post">
    <p align="center">
        Nickname: <input type="text" name="nickname"><br>
        Password: <input type="text" name="password"><br>
        Reply Password: <input type="text" name="passwordReply"><br>
        <input type="submit" name="submit" value="Submit">
    </p>
</form>

</body>

</html>

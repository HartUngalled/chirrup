<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <%@include file="header.jsp"%>
</head>
<body>

<form action="/postMessage" method="post">
    <dif class="centerInfo">
        Message: <br><textarea name="message"></textarea><br>
        <input type="submit" name="submit" value="Submit">
    </dif>
</form>

</body>
</html>
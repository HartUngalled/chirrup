<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css">
    <%@include file="header.jsp"%>
</head>
<body>

<form action="/postMessage" method="post">
    <div class="centerInfo">
        Message: <br><textarea name="message"></textarea><br>
        <input type="submit" name="submit" value="Submit">
    </div>
</form>

</body>
</html>
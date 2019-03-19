<%--
  Created by IntelliJ IDEA.
  User: patryk
  Date: 14.03.19
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="average" method="get">
        <% for (int i = 1; i <= 5; i++) { %>
            Liczba <%= i + "." %> <input type="text" name=<%= "number" + i %> /><br>
        <% } %>
        <input type="submit" value="Oblicz średnią"/>
    </form>

</body>
</html>

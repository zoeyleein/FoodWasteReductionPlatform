<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2024-04-09
  Time: 4:56 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Surplus Item Choice</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST">
    <input type="submit" name="action" value="Sale">
</form>
<br>
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST">
    <input type="submit" name="action" value="Donation">
</form>
<br>
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST">
    <input type="submit" name="action" value="Both">
</form>
</body>
</html>

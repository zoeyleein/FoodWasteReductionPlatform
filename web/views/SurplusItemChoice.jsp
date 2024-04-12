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
    <link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
</head>
<body class = "registration">

    <div class="logoblack-container">
        <a href="http://localhost:8080/FoodWasteReductionPlatform/">
        <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
    </div>

    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a></li>
    </ul>

<div class="container">
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST" style = "text-align: center;">
    <input type="submit" name="action" value="Sale">
</form>
<br>
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST" style = "text-align: center;">
    <input type="submit" name="action" value="Donation">
</form>
<br>
<form action="${pageContext.request.contextPath}/SurplusChoiceServlet" method="POST" style = "text-align: center;">
    <input type="submit" name="action" value="Both">
</form>
</body>
</html>

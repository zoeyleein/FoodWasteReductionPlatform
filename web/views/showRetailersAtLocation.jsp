<%--
  Created by IntelliJ IDEA.
  User: mayankarora
  Date: 2024-04-08
  Time: 11:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Retailers List</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
</head>
<body class = "registration">

    <div class="logoblack-container">
        <a href="${pageContext.request.contextPath}">
        <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
    </div>

    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
    </ul>
<p class="balance">Balance : $${currentBal}</p>

<div class="container">
<h1>Retailers at Selected Location</h1>
<br>
<c:if test="${not empty retailerNames}">
    <ul>
        <c:forEach items="${retailerNames}" var="retailer">
            <li>${retailer.getName()}
            <div>
                <form action="FetchInventoryServlet" method="post">
                    <input type="hidden" name="retailerId" value="${retailer.getId()}"/>
                    <input type="hidden" name="currentBal" value="${currentBal}"/>
                    <br>
                    <button type="submit">Shop</button>
                </form>
            </div>
            </li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty retailerNames}">
    <p>No retailers found for the selected location.</p>
</c:if>
</div>
</body>
</html>

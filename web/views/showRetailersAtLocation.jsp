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
</head>
<body>
<h2>Retailers at Selected Location</h2>
<c:if test="${not empty retailerNames}">
    <ul>
        <c:forEach items="${retailerNames}" var="retailer">
            <li>${retailer.getName()}</li>
            <button>Shop</button>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty retailerNames}">
    <p>No retailers found for the selected location.</p>
</c:if>
</body>
</html>

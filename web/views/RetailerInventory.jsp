<%--
  User: Aaron
  Date: 2024-04-06
  Time: 5:22 p.m.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory</title>
    <link href="http://localhost:8080/FoodWasteReductionPlatform/style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<h1>Inventory</h1>
<table>
    <thead>
    <tr>
        <th>Item Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Expiry Date</th>
        <th>Final Price</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate over inventory data and generate table rows -->
    <c:forEach items="${inventory}" var="item">
        <tr>

            <td>${item.getName()}</td>
            <td>${item.getCategory()}</td>
            <td>${item.getQuantity()}</td>
            <td>${item.getExpiryDate()}</td>
            <td>${item.getFinalPrice()}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jingyi
  Date: 2024-04-08
  Time: 2:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Charity Transaction View</title>
    <link href="http://localhost:8080/FoodWasteReductionPlatform/style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
        <div class="logoblack-container">
            <a href="${pageContext.request.contextPath}/">
            <img src="http://localhost:8080/FoodWasteReductionPlatform/image/logo_black.png" alt="Logo"></a>
        </div>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
    <!-- menu icon -->
    <li class="top-menu">
        <div class="cart-icon">
            <img src="http://localhost:8080/FoodWasteReductionPlatform/image/cart-icon.png" alt="Shopping Cart">
        </div>
    </li>
</ul>

<h1>Transaction</h1>

<table>
    <thead>
        <tr>
            <th>Item</th>
            <th>Batch</th>
            <th>Expiry Date</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Final Price</th>
            <th>Donation</th>
            <th></th> <!-- Empty header for Select button -->
        </tr>
    </thead>
    <tbody>

    <!-- The temporary data, have to link from database -->
        <tr>
            <td>Apple</td>
            <td>2022-01</td>
            <td>2024-04-30</td>
            <td>10</td>
            <td>$0.50</td>
            <td>$5.00</td>
            <td>Yes</td>
            <td><button class="select-button">Remove</button></td>
        </tr>
    </tbody>
</table>

<a href="http://localhost:8080/FoodWasteReductionPlatform/views/transaction/CharityTransactionConfirmView.jsp">
    <button class="confirm-button">Confirm</button></a>

</body>
</html>

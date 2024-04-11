<%--
  Created by IntelliJ IDEA.
  User: mayankarora
  Date: 2024-04-07
  Time: 2:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Charity View</title>
    <link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
</head>
<body class = "registration">
        <div class="logoblack-container">
            <a href="http://localhost:8080/FoodWasteReductionPlatform/">
            <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
        </div>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
    <!-- menu icon -->
    <li class="top-menu">
        <div class="cart-icon">
            <a href="http://localhost:8080/FoodWasteReductionPlatform/views/transaction/CharityTransactionView.jsp"><img src="http://localhost:8080/FoodWasteReductionPlatform/image/cart-icon.png" alt="Shopping Cart"></a>
        </div>
    </li>
</ul>

<div class="inventory">
<h1>Inventory</h1>

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
            <td><button class="select-button">Select</button></td>
        </tr>
    </tbody>
</table>

</div>
</body>
</html>

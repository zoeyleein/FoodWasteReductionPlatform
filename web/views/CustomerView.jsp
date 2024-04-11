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
    <title>Customer View</title>
    <link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
        <div class="logoblack-container">
            <a href="http://localhost:8080/FoodWasteReductionPlatform/">
            <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
        </div>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>

    <li class="top-menu">
        <div class="notification-icon">
            <img src="http://localhost:8080/FoodWasteReductionPlatform/image/notification-icon.png" alt="Alerts">
        </div>
        <div class="cart-icon">
            <a href="http://localhost:8080/FoodWasteReductionPlatform/views/transaction/CustomerTransactionView.jsp"><img src="http://localhost:8080/FoodWasteReductionPlatform/image/cart-icon.png" alt="Shopping Cart"></a>
        </div>
        <div class="money-icon">
            <img src="http://localhost:8080/FoodWasteReductionPlatform/image/money-icon.png" alt="Money">
            <span class="user-balance">$100</span>
        </div>
    </li>
</ul>

<h1>Food items</h1>


        <form action="http://localhost:8080/FoodWasteReductionPlatform_Web_exploded/FetchRetailersServlet" method="post">
            <label for="location">Select a location:</label>
            <select id="location" name="location">
                <option value="Nepean">Nepean</option>
                <option value="Kanata">Kanata</option>
                <option value="Barrhaven">Barrhaven</option>
                <option value="Downtown">Downtown</option>
            </select>
            <button type="submit">OK</button>
        </form>


<%--<table>--%>
<%--    <thead>--%>
<%--        <tr>--%>
<%--            <th>Item</th>--%>
<%--            <th>Batch</th>--%>
<%--            <th>Expiry Date</th>--%>
<%--            <th>Quantity</th>--%>
<%--            <th>Unit Price</th>--%>
<%--            <th>Final Price</th>--%>
<%--            <th>Donation</th>--%>
<%--            <th></th> <!-- Empty header for Buy button -->--%>
<%--        </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>

<%--    <!-- The temporary data, have to link from database -->--%>
<%--        <tr>--%>
<%--            <td>Apple</td>--%>
<%--            <td>2022-01</td>--%>
<%--            <td>2024-04-30</td>--%>
<%--            <td>10</td>--%>
<%--            <td>$0.50</td>--%>
<%--            <td>$5.00</td>--%>
<%--            <td>No</td>--%>
<%--            <td><button class="buy-button">Buy</button></td>--%>
<%--        </tr>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<button class="update-inventory-button">Update Inventory</button>--%>

</body>
</html>

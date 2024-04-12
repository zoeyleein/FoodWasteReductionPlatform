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
<body class = "registration">
        <div class="logoblack-container">
            <a href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
        </div>
<ul class="menu">
    <li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
</ul>

            <p class="balance">Balance :<span class="span">$${sessionScope.userBalance}</span></p>
            <form action="${pageContext.request.contextPath}/AddMoneyServlet" method="POST">
                <input type="hidden" name="userId" value="${sessionScope.userId}">
                <input type="hidden" name="currentBal" value="${sessionScope.userBalance}">

                <button id="add-money-btn" type="submit">Add money</button>
            </form>

<div class="container">
<h1>Food items</h1>
        <form action="${pageContext.request.contextPath}/FetchRetailersServlet" method="post">
            <label for="location">Select a location:</label>
            <br>
            <select id="location" name="location">
                <option value="Nepean">Nepean</option>
                <option value="Kanata">Kanata</option>
                <option value="Barrhaven">Barrhaven</option>
                <option value="Downtown">Downtown</option>
            </select>
            <input type="hidden" name="currentBal2" value="${sessionScope.userBalance}">
            <div style="text-align: right;">
            <button type="submit">OK</button>
            </div>
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
</div>
</div>
</body>
</html>

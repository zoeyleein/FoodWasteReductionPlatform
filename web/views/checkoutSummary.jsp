<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout Summary</title>
</head>
<body>
<h2>Checkout Summary</h2>
<table border="1">
    <thead>
    <tr>
        <th>Item Name</th>
        <th>Expiry Date</th>
        <th>Item Price</th>
        <th>On Sale</th>
        <th>Quantity Purchased</th>
        <th>Total Cost (Per Item)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.itemName}</td>
            <td>${item.expiryDate}</td> <!-- Display expiryDate -->
            <td>$${item.unitPrice}</td> <!-- Updated to reflect the correct property name -->
            <td>${item.onSale ? 'Yes' : 'No'}</td> <!-- Adjusted to show Yes/No -->
            <td>${item.quantityPurchased}</td> <!-- Updated to reflect the correct property name -->
            <td>$${item.totalCost}</td> <!-- Display totalCost -->
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th colspan="5">Grand Total Cost</th> <!-- Updated colspan to account for the new column -->
        <th>$${totalCost}</th> <!-- Display the grand totalCost passed from servlet -->
    </tr>
    </tfoot>
</table>
<form action="PaymentServlet" method="post">
    <button type="submit">Proceed to Payment</button> <!-- Updated button text for clarity -->
</form>
</body>
</html>

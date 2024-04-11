<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout Summary</title>
</head>
<body>
<h2>Checkout Summary</h2>
<form action="PaymentServlet" method="post">
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
                <td>${item.expiryDate}</td>
                <td>$${item.unitPrice}</td>
                <td>${item.onSale ? 'Yes' : 'No'}</td>
                <td>${item.quantityPurchased}</td>
                <td>$${item.totalCost}</td>
            </tr>
            <input type="hidden" name="retailerInventoryIDs[]" value="${item.retailerInventoryID}" />
            <input type="hidden" name="quantities[]" value="${item.quantityPurchased}" />
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th colspan="5">Grand Total Cost</th>
            <th>$${totalCost}</th>
        </tr>
        </tfoot>
    </table>
    <input type="hidden" name="totalCost" value="${totalCost}" />
    <button type="submit">Pay now</button>
</form>
</body>
</html>

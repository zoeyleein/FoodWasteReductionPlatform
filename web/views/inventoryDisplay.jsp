<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Inventory List</title>
    <script>
        // Updates the cost and validates quantity and total cost constraints
        function updateCostAndValidate(element, availableQty, unitPrice) {
            let qtyInput = parseInt(element.value, 10);
            if (qtyInput > availableQty) {
                alert('Quantity cannot exceed available stock.');
                element.value = availableQty;
                qtyInput = availableQty;
            }

            //must use .closest here instead of querySelector for all
            //reference: https://stackoverflow.com/questions/63241462/using-closest-on-element-in-different-parent-element
            let costElement = element.closest('tr').querySelector('.cost');
            costElement.innerText = (qtyInput * unitPrice).toFixed(2);

            let totalCost = 0;
            document.querySelectorAll('.cost').forEach(function(item) {
                totalCost += parseFloat(item.innerText);
            });

            // If the total cost exceeds $100, reset the last input change
            if (totalCost > 100) {
                alert('Total cost cannot exceed 100 dollars. Adjusting quantity...');
                element.value = 0; // Reset last changed input
                costElement.innerText = '0.00'; // Reset cost for the last changed item
                // Recalculate total cost after adjustment
                totalCost = 0;
                document.querySelectorAll('.cost').forEach(function(item) {
                    totalCost += parseFloat(item.innerText);
                });
            }

            document.getElementById('totalCost').innerText = 'Total Cost: $' + totalCost.toFixed(2);
        }
    </script>
</head>
<body>
<h2>Inventory</h2>
<c:if test="${not empty inventoryItemsMap}">
    <table border="1">
        <thead>
        <tr>
            <th>Item</th>
            <th>Expiry Date</th>
            <th>On Sale</th>
            <th>Available Quantity</th>
            <th>Unit Price</th>
            <th>Qty</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventoryItemsMap}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value.expiryDate}</td>
                <td>${entry.value.sale ? 'Yes' : 'No'}</td>
                <td>${entry.value.quantity}</td>
                <td>$${entry.value.finalPrice}</td>
                <td>
                    <input type="number" min="0" value="0"
                           oninput="updateCostAndValidate(this, ${entry.value.quantity}, ${entry.value.unitPrice})"/>
                </td>
                <td class="cost">0.00</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p id="totalCost">Total Cost: $0.00</p>
</c:if>
<c:if test="${empty inventoryItemsMap}">
    <p>No inventory items found.</p>
</c:if>
</body>
</html>

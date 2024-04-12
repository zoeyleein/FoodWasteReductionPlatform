<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Inventory List</title>
    <link href="${pageContext.request.contextPath}/style/style.css" type="text/css" rel="stylesheet">
    <script>
        function updateCostAndValidate(element, availableQty, unitPrice) {
            let qtyInput = parseInt(element.value, 10);
            if (qtyInput > availableQty) {
                alert('Quantity cannot exceed available stock.');
                element.value = availableQty;
                qtyInput = availableQty;
            }

            let costElement = element.closest('tr').querySelector('.cost');
            costElement.innerText = (qtyInput * unitPrice).toFixed(2);

            let totalCost = 0;
            document.querySelectorAll('.cost').forEach(function(item) {
                totalCost += parseFloat(item.innerText);
            });

            let maxTotalCost = parseFloat(document.getElementById('totalCostLimit').textContent);
            if (totalCost > maxTotalCost) {
                alert('Total cost cannot exceed ' + maxTotalCost.toFixed(2) + ' dollars. Adjusting quantity...');
                element.value = 0;
                costElement.innerText = '0.00';
                totalCost = 0;
                document.querySelectorAll('.cost').forEach(function(item) {
                    totalCost += parseFloat(item.innerText);
                });
            }

            document.getElementById('totalCost').innerText = 'Total Cost: $' + totalCost.toFixed(2);
        }

        function checkout() {
            const rowsData = getRowJsonData();
            const form = document.createElement('form');
            form.method = 'POST';
            form.action = '${pageContext.request.contextPath}/ProcessCheckoutServlet';
            form.style.display = 'none';

            rowsData.forEach((item, index) => {
                for (const [key, value] of Object.entries(item)) {
                    const hiddenField = document.createElement('input');
                    hiddenField.type = 'hidden';
                    hiddenField.name = `items[${index}].${key}`;
                    hiddenField.value = value;
                    form.appendChild(hiddenField);
                }
            });

            document.body.appendChild(form);

            console.log('clicked');
            form.submit();
        }

        getRowJsonData = () => {
            let rowsData = [];

            document.querySelectorAll('tbody tr').forEach((row) => {
                let cells = row.querySelectorAll('td');
                let retailerInventoryIDElement = row.querySelector('.retailerInventoryID'); // Getting the element
                let retailerInventoryID = retailerInventoryIDElement ? retailerInventoryIDElement.value : 'Error: ID Not Found'; // Using the element's value if it exists
                let itemData = {
                    itemName: cells[0].textContent.split(',')[0],
                    retailerInventoryID: retailerInventoryID, // Now this should properly get the value
                    expiryDate: cells[2].textContent,
                    onSale: cells[3].textContent === 'Yes',
                    unitPrice: parseFloat(cells[5].textContent.replace('$', '')),
                    quantityPurchased: parseInt(cells[6].querySelector('input[type=number]').value, 10),
                    totalCost: parseFloat(cells[7].textContent)
                };
                rowsData.push(itemData);
            });

            return rowsData; // Return the structured data
        };

    </script>
</head>
<body class = "registration">

    <div class="logoblack-container">
        <a href="http://localhost:8080/FoodWasteReductionPlatform/">
        <img src="${pageContext.request.contextPath}/image/logo_black.png" alt="Logo"></a>
    </div>

    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a></li>
    </ul>

<div class="inventory">
<h1>Inventory</h1>
<p id="totalCostLimit" style="display:none;">${currentBal}</p>
<c:if test="${not empty inventoryItemsMap}">
    <table border="1">
        <thead>
        <tr>
            <th>Item</th>
            <th>Expiry Date</th>
            <th>On Sale</th>
            <th>Available Quantity</th>
            <th>Unit Price</th>
            <th>Discounted price</th>
            <th>Quantity</th>
            <th>Cost</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventoryItemsMap}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value.id}</td>
                <td>${entry.value.expiryDate}</td>
                <td>${entry.value.sale ? 'Yes' : 'No'}</td>
                <td>${entry.value.quantity}</td>
                <td>$${entry.value.finalPrice}</td>
                <td>
                    <input type="number" min="0" value="0"
                           oninput="updateCostAndValidate(this, ${entry.value.quantity}, ${entry.value.finalPrice})"/>
                </td>

                <td class="cost">0.00</td>
                <td>
                    <input type="hidden" class="retailerInventoryID" value="${entry.value.id}">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <p id="totalCost">Total Cost: $0.00</p>
    <br>
    <button type="submit" onclick="checkout()">Checkout</button>
</c:if>
<c:if test="${empty inventoryItemsMap}">
    <p>No inventory items found.</p>
</c:if>
</div>
</body>
</html>

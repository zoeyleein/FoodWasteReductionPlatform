<%--
    Document   : RetailerView.jsp
    Created on : April 5, 2024
    Author     : Aaron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Retailer Registration Form</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div>Retailer Inventory</div>
<form action="${pageContext.request.contextPath}/RetailerInventoryServlet" method="post">
    <label for="productName" >Product Name: </label><br>
    <input type="text" id="productName" name="productName" required><br>
    <label for="category" >Product Category: </label><br>
    <select id="category" name="category">
        <option value="Fruit">Fruit</option>
        <option value="Vegetable">Vegetable</option>
        <option value="Meat">Meat</option>
        <option value="Seafood">Seafood</option>
        <option value="Dairy & Eggs">Dairy & Eggs</option>
    </select><br>
    <label for="batch" >Batch Number: </label><br>
    <input type="text" id="batch" name="batch" required><br>
    <label for="quantity" >Quantity: </label><br>
    <input type="number" id="quantity" name="quantity" min="0" required><br>
    <label for="expiryDate">Expiry Date:</label><br>
    <input type="datetime-local" id="expiryDate" name="expiryDate" onchange="validateExpiryDate()"><br>
    <span id="expiryDateError" style="color: red;"></span>

    <script>
        function validateExpiryDate() {
            var inputDate = new Date(document.getElementById("expiryDate").value);
            var currentDate = new Date();

            if (inputDate < currentDate) {
                document.getElementById("expiryDateError").innerHTML = "Expiry date must be present or future.";
                document.getElementById("expiryDate").value = ""; // Clear the input value
            } else {
                document.getElementById("expiryDateError").innerHTML = "";
            }
        }
    </script><br>
    <label for="price" >Unit Price: </label><br>
    <input type="number" id="price" name="price" step="0.01" min="0" required><br>


    <input type="submit" value="Add Item"><br><br>


    <input type="submit" value="Update Item"><br>

    <input type="submit" value="View Inventory">

</form>
</body>
</html>
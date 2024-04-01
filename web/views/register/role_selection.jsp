<%-- 
    Document   : role_selection
    Created on : Mar 27, 2024, 8:16:34 PM
    Author     : camil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select User Type</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="${pageContext.request.contextPath}/SelectUserTypeServlet" method="POST">
    <label for="userType">Select what type of user you are:</label><br>
    <select name="userType" id="userType">
        <option value="Customer">Customer</option>
        <option value="Retailer">Retailer</option>
        <option value="Charity">Charity/Food Bank</option>
    </select>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

<%-- 
    Document   : Retailer_registration
    Created on : Mar 27, 2024, 8:14:52 PM
    Author     : camil
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
        <div>Retailer Registration Form</div>
            <form action="${pageContext.request.contextPath}/ValidateRegistrationServlet" method="post">
                <label for="role" hidden>Role:</label>
                <input type="text" id="role" value="Retailer" hidden>
                <label for="name">*User:</label><br>
                <input type="text" id="name" name="name" required><br>
                <label for="password">*Password:</label><br>
                <input type="password" id="password" name="password" required><br>
                <input type="submit" value="Register">
            </form>
    </body>
</html>
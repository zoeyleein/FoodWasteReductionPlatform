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
        <link href="http://localhost:8080/FoodWasteReductionPlatform/style/style.css" type="text/css" rel="stylesheet">
    </head>
    <body class = "registration">

    <div class="logoblack-container">
                <img src="http://localhost:8080/FoodWasteReductionPlatform/image/logo_black.png" alt="Logo">
    </div>

    <div class="container">
    <h1>Retailer Registration Form</h1>
            <form action="${pageContext.request.contextPath}/ValidateRegistrationServlet" method="post">
            <div class="hidden">
                <label for="role" hidden>Role :</label>
                <input type="text" id="role" value="Retailer" hidden>
            </div>
                <label for="name">*User :</label><br>
                <input type="text" id="name" name="name" required><br>
                <label for="password">*Password :</label><br>
                <input type="password" id="password" name="password" required><br>
                <%--Required fields for not null objects --%>
            <div class="hidden">
                <label for="email" hidden>*Email :</label>
                <input type="email" id="email" name="email" hidden>
                <label for="phone" hidden>*Phone :</label>
                <input type="text" id="phone" name="phone" hidden>
            </div>
                <label for="location">*Location :</label><br>
                <input type="text" id="location" name="location" required><br>
            <div class="hidden">
                <input type="checkbox" id="subscribeToPhone" name="subscribeToPhone" hidden>
                <label for="subscribeToPhone" hidden>Get notifications by Phone</label>
                <input type="checkbox" id="subscribeToMail" name="subscribeToMail" hidden>
                <label for="subscribeToMail" hidden>Get notifications by Mail</label>
            </div>
                <%--Finish of Required fields for not null objects --%>
                <br>
                <input type="submit" value="Register">
            </form>
        </div>
    </body>
</html>
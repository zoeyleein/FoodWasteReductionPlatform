<%-- 
    Document   : Charity_registration
    Created on : Mar 27, 2024, 8:11:30 PM
    Author     : camil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Registration Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Charity Registration Form</div>
            <form action="${pageContext.request.contextPath}/ValidateRegistrationServlet" method="post">
                <input type="text" id="role" value="Charity" hidden><br>
                <label for="name">Name:</label><br>
                <input type="text" id="name" name="name"><br>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email"><br>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password"><br>
                <label for="phone">Phone:</label><br>
                <input type="text" id="phone" name="phone"><br>
                <label for="location">Location:</label><br>
                <input type="text" id="location" name="location"><br>
                <input type="submit" value="Register">
            </form>
    </body>
</html>

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
                <label for="role" hidden>Role:</label>
                <input type="text" id="role" value="Charity" hidden>
                <label for="name">*Charity Name:</label><br>
                <input type="text" id="name" name="name" required><br>
                <label for="password">*Password:</label><br>
                <input type="password" id="password" name="password" required><br>
                <label for="location">*Location:</label><br>
                <input type="text" id="location" name="location" required><br>
                <%--Required fields for not null objects --%>
                <label for="email" hidden>*Email:</label>
                <input type="email" id="email" name="email" hidden>
                <label for="phone" hidden>*Phone:</label>
                <input type="text" id="phone" name="phone" hidden>
                <input type="checkbox" id="subscribeToPhone" name="subscribeToPhone" hidden>
                <label for="subscribeToPhone" hidden>Get notifications by Phone</label>
                <input type="checkbox" id="subscribeToMail" name="subscribeToMail" hidden>
                <label for="subscribeToMail" hidden>Get notifications by Mail</label>
                <%--Finish of Required fields for not null objects --%>
                <input type="submit" value="Register">
            </form>
    </body>
</html>

<%--
    Document   : Customer_registration
    Created on : Mar 27, 2024, 8:12:59 PM
    Author     : Andres Porras
--%>

<%@ page import="dataaccesslayer.DataSource" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.ServletContext" %>

<%
    // Instantiate DataSource
    ServletContext context = pageContext.getServletContext();
    DataSource dataSource = new DataSource(context);

// Establish database connection
    Connection connection = null;
    try {
        connection = dataSource.getConnection();

        // Query database
        String query = "SELECT location FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        //TODO the dropdown needs to be reworked... currently displays all locations meaning duplicates as well
        //TODO need method to check for dupes before populating dropdown
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration Form</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://localhost:8080/FoodWasteReductionPlatform/style/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div>Customer Registration Form</div>
<form action="${pageContext.request.contextPath}/ValidateRegistrationServlet" method="post">
    <label for="role" hidden>Role:</label>
    <input type="text" id="role" value="Customer" hidden>
    <label for="name">*Name:</label><br>
    <input type="text" id="name" name="name" required><br>
    <p style="color: red;">Username already exists, please choose another username</p>
    <label for="email">*Email:</label><br>
    <input type="email" id="email" name="email" required><br>
    <label for="password">*Password:</label><br>
    <input type="password" id="password" name="password" required><br>
    <label for="phone">*Phone:</label><br>
    <input type="text" id="phone" name="phone" required><br>
    <label for="dropdown">Select your nearest store:</label>
    <select id="dropdown" name="selectedValue">
        <%
            // Populate the dropdown
            while (resultSet.next()) {
                String value = resultSet.getString("location");
        %>
        <option value="<%= value %>"><%= value %></option>
        <%
            }
        %>
    </select><br>
    <input type="checkbox" id="subscribeToPhone" name="subscribeToPhone">
    <label for="subscribeToPhone">Get notifications by Phone</label><br>
    <input type="checkbox" id="subscribeToMail" name="subscribeToMail">
    <label for="subscribeToMail">Get notifications by Mail</label><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
<%
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close database connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
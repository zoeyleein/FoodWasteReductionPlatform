<%-- 
    Document   : Charity_registration
    Created on : Mar 27, 2024, 8:11:30 PM
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
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Registration Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="http://localhost:8080/FoodWasteReductionPlatform/style/style.css" type="text/css" rel="stylesheet">
    </head>
    <body class = "registration">

    <div class="logoblack-container">
        <a href="http://localhost:8080/FoodWasteReductionPlatform/">
        <img src="http://localhost:8080/FoodWasteReductionPlatform/image/logo_black.png" alt="Logo"></a>
    </div>

    <div class="container">
    <h1>Charity Registration Form</h1>
            <form action="${pageContext.request.contextPath}/ValidateRegistrationServlet" method="post">
            <div class="hidden">
                <label for="role" hidden>Role :</label>
                <input type="text" id="role" value="Charity" hidden>
            </div>
                <label for="name">*Charity Name :</label><br>
                <input type="text" id="name" name="name" required><br>
                <label for="password">*Password :</label><br>
                <input type="password" id="password" name="password" required><br>
                <label for="dropdown">Select your nearest store :</label>
                <br>
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
                <%--Required fields for not null objects --%>
                <br>
            <div class="hidden">
                <label for="email" hidden>*Email :</label>
                <input type="email" id="email" name="email" hidden>
                <label for="phone" hidden>*Phone :</label>
                <input type="text" id="phone" name="phone" hidden>
                <input type="checkbox" id="subscribeToPhone" name="subscribeToPhone" hidden>
                <label for="subscribeToPhone" hidden>Get notifications by Phone</label>
                <input type="checkbox" id="subscribeToMail" name="subscribeToMail" hidden>
                <label for="subscribeToMail" hidden>Get notifications by Mail</label>
            </div>
                <%--Finish of Required fields for not null objects --%>
                <div style="text-align: right; background-color: white;">
                <input type="submit" value="Register">
                <div>
            </form>
        </div>
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

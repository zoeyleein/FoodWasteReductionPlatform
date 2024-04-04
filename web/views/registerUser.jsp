<%-- 
    Document   : registerUser
    Created on : Mar 26, 2024, 7:48:09 PM
    Author     : camil
--%>
<%@page import="java.sql.SQLException"%>
<%@ page import="dataaccesslayer.UserDAOImpl"%>
<%@ page import="transferobjects.UserDTO"%>
<%@ page import="java.io.*, java.util.*" %>
<%@page import="model.User"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
        <h1>User Registration</h1>
        <%
        // Retrieve parameters from form
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
//        double balance = Double.parseDouble(request.getParameter("balance"));
        double balance = 0;



         // Check if all fields are provided
//        if (name == null || email == null || password == null || role == null || phone == null || location == null) {
//            out.println("Please fill all the fields.");
//        } else {
//        
            // Create a new UserDTO object
            UserDTO user = new UserDTO();
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
            user.setMail(email);
            user.setPhone(phone);
            user.setLocation(location);
            
                UserDAOImpl userDAO = new UserDAOImpl();
        try {
            userDAO.insertUser(user);
            out.println("User registered successfully!");
        } catch (SQLException e) {
            out.println("Failed to register user. Please try again later.");
            e.printStackTrace();
        }
            
//            user.setBalance(balance);
            // Create a new User object
//            User user = new User(name, email, password, role, phone, location, balance);
            
//
//            // Save the user to the database or perform necessary actions
//            // For demonstration purposes, assuming you have a UserDAO class to handle database operations
//            UserDAO userDAO = new UserDAO();
//            boolean success = userDAO.registerUser(user);

//            if (success) {
//                out.println("User registered successfully!");
//            } else {
//                out.println("Failed to register user. Please try again later.");
//            }
//        }
        %>



    </body>
</html>
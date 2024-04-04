/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dataaccesslayer.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camil
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        // Retrieve user and password parameters from the form
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        
        // Check if username and password are valid (you should implement your validation logic here)
        boolean isValid = validateUser(username, password);
        
        // Redirect based on validation result
        if (isValid) {
            // If valid, redirect to a success page
            response.sendRedirect("success.html");
        } else {
            // If not valid, redirect back to the login page with an error message
            response.sendRedirect("invalid_credentials.html");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
        // Dummy method for validating user (replace with your actual validation logic)
    private boolean validateUser(String username, String password) {
        // Dummy validation logic, replace with actual implementation
        return username.equals("admin") && password.equals("admin123");

//    boolean isValid = false;
//    Connection connection = null;
//    PreparedStatement statement = null;
//    ResultSet resultSet = null;
//
//    try {
//        // Establish a connection to the database
//        connection = DataSource.createConnection();
//
//        // Prepare a statement to query the database
//        String query = "SELECT COUNT(*) AS count FROM users WHERE username = ? AND password = ?";
//        statement = connection.prepareStatement(query);
//        statement.setString(1, username);
//        statement.setString(2, password);
//
//        // Execute the query
//        resultSet = statement.executeQuery();
//
//        // Check if there is a matching user with the provided username and password
//        if (resultSet.next()) {
//            int count = resultSet.getInt("count");
//            isValid = count > 0; // If count > 0, the user exists and credentials are valid
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    } finally {
//        // Close ResultSet, PreparedStatement, and Connection
//        try {
//            if (resultSet != null) resultSet.close();
//            if (statement != null) statement.close();
//            if (connection != null) connection.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    return isValid;
}
}

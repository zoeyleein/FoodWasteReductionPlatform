package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInValidation {
    public String logInPageRedirect(String action, String name, String password, Connection con) {
        if (action.equals("Sign in")) {
            return switch (getUserRole(name, password, con)) {
                case "Customer" -> "views/CustomerView.jsp";
                case "Retailer" -> "views/RetailerView.jsp";
                case "Charity" -> "views/CharityView.jsp";
                default -> "views/SignInError.jsp";
            };
        } else if (action.equals("Sign up")) {
            return "views/register/role_selection.jsp";
        } else {
            throw new IllegalArgumentException("Error: Unexpected outcome");
            // if we have a different action, we can redirect to an error page
        }
    }

    public String getUserRole(String username, String password, Connection con) {
//        return error;
        String sql = "SELECT role FROM users WHERE name = ? AND password = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if any rows were returned
                if (rs.next()) {
                    // Retrieve the role of the user from the result set
                    // Return the role of the user
                    return rs.getString("role");
                } else {
                    // No user found with provided credentials
                    return null; // Or throw an exception depending on your application's logic
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            return null; // Return null in case of any exception
        }
    }
}








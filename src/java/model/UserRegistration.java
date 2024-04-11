package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author aaronthomp
 */
public class UserRegistration {

    public String welcomePageRedirect(String action){
        if (action.equals("Log In")) {
            return "views/Signin.jsp";
        } else if (action.equals("Sign Up")) {
            return "views/register/role_selection.jsp";
        } else {
            throw new IllegalArgumentException("Error: Unexpected outcome");
            // if we have a different action, we can redirect to an error page
        }
    }


    public String registrationType(String userType){
        return switch (userType) {
            case "Customer" -> "views/register/Customer_registration.jsp";
            case "Retailer" -> "views/register/Retailer_registration.jsp";
            case "Charity" -> "views/register/Charity_registration.jsp";
            default -> throw new IllegalArgumentException("Error: Unexpected user type");
        };
    }

    public String registrationErrorRedirect(String userType){
        return switch (userType) {
            case "Customer" -> "views/register/Customer_registration_error.jsp";
            case "Retailer" -> "views/register/Retailer_registration_error.jsp";
            case "Charity" -> "views/register/Charity_registration_error.jsp";
            default -> throw new IllegalArgumentException("Error: Unexpected user type");
        };
    }

    public boolean phoneValidation(String phone){
        return phone.matches("\\d{10}");
    }


    public boolean userExists(String name, Connection con) {
        String sql = "SELECT COUNT(*) FROM users WHERE name = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if any rows were returned
                if (rs.next()) {
                    int count = rs.getInt(1); // Get the count of users with the given name
                    return count > 0; // Return true if count is greater than 0 (user exists), otherwise false
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
            return false; // Return false in case of any exception
        }
    }

}



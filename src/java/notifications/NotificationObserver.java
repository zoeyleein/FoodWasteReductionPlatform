package notifications;

import businesslayer.UserBusinessLogic;
import dataaccesslayer.DataSource;
import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;


import java.sql.*;

public class NotificationObserver implements Observer {
    private String userEmail;
    private String userPhone;
    UserBusinessLogic userBusinessLogic;
    DataSource dataSource;

    @Override
    public void setUserPreferences(String phone) {
        this.userPhone = phone;
    }

    @Override
    public void update(RetailerInventoryDTO retailerInventory, Connection connection) {
        String userQuery = "SELECT " +
                "u.name AS user_name, " +
                "u.mail AS user_email, " +
                "u.phone AS user_phone " +
                "FROM " +
                "users u " +
                "WHERE " +
                "u.preference = 'Fruit' " +
                "AND (u.subscribeToPhone = 1 OR u.subscribeToEmail = 1)";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(userQuery)) {

            while (rs.next()) {
                String userName = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String userPhone = rs.getString("user_phone");

                // Print the information
                System.out.println("User Name: " + userName);
                System.out.println("User Email: " + userEmail);
                System.out.println("User Phone: " + userPhone);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

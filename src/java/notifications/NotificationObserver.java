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
        String inventoryItemQuery = "SELECT " +
                "i.name AS item_name, " +
                "i.category AS item_category, " +
                "u.phone AS user_phone, " +
                "u.mail AS user_email " +
                "FROM " +
                "retailer_inventory ri " +
                "JOIN item i ON ri.item_id = i.id " +
                "JOIN users u ON ri.users_id = u.id " +
                "WHERE " +
                "u.subscribeToPhone = 1 OR u.subscribeToEmail = 1";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(inventoryItemQuery)) {

            while (rs.next()) {
                String itemName = rs.getString("item_name");
                String itemCategory = rs.getString("item_category");
                String userPhone = rs.getString("user_phone");
                String userEmail = rs.getString("user_email");

                // Print the information
                System.out.println("Item Name: " + itemName);
                System.out.println("Item Category: " + itemCategory);
                System.out.println("User Phone: " + userPhone);
                System.out.println("User Email: " + userEmail);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

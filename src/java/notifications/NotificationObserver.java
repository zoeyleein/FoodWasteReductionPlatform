package notifications;

import businesslayer.UserBusinessLogic;
import dataaccesslayer.DataSource;
import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificationObserver implements Observer{
    private String userEmail;
    private String userPhone;
    UserBusinessLogic userBusinessLogic;
    DataSource dataSource;



    @Override
    public void setUserPreferences(String phone) {
        this.userPhone = phone;
    }
       @Override
    public void update(RetailerInventoryDTO retailerInventory) {
           try (Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " +
                        "i.name AS item_name, " +
                        "u.name AS user_name, " +
                        "u.subscribeToPhone, " +
                        "u.subscribeToEmail " +
                        "FROM " +
                        "retailer_inventory ri " +
                        "JOIN item i ON ri.item_id = i.id " +
                        "JOIN users u ON ri.users_id = u.id")) {

               while (rs.next()) {
                   String itemName = rs.getString("item_name");
                   String userName = rs.getString("user_name");
                   boolean subscribeToPhone = rs.getBoolean("subscribeToPhone");
                   boolean subscribeToEmail = rs.getBoolean("subscribeToEmail");

                   // Process retrieved data
                   System.out.println("Item Name: " + itemName);
                   System.out.println("User Name: " + userName);
                   System.out.println("Subscribe to Phone: " + subscribeToPhone);
                   System.out.println("Subscribe to Email: " + subscribeToEmail);
                   System.out.println();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

//           System.out.println("The item "+retailerInventory.getId()+"is on sale by "+retailerInventory.getFinalPrice());
           // Logic to send notification to the user based on preferences
    }


}

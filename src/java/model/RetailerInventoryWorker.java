package model;

import transferobjects.InventoryItemDTO;
import transferobjects.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RetailerInventoryWorker {

    int NOT_FOR_SALE = 0;
    int ON_SALE = 1;
    int FOR_DONATION = 2;
    int EXPIRED = 3;
    double salePercent = 0.3;

    public boolean expiryDateValidation(Date expiryDate) {
        Date currentDate = new Date();

        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);

        return daysDifference <= 7;
    }

    public boolean isDonation(Date expiryDate){
        Date currentDate = new Date();
        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);
        return daysDifference <= 3;
    }

    public boolean isExpired(Date expiryDate){
        Date currentDate = new Date();
        long differenceInMillis = expiryDate.getTime() - currentDate.getTime();
        long daysDifference = differenceInMillis / (1000 * 60 * 60 * 24);
        return daysDifference <= 0;
    }

    public int productStatus(Date expiryDate){
        if (isExpired(expiryDate)){
            return EXPIRED;
        } else if (isDonation(expiryDate)){
            return FOR_DONATION;
        } else if (expiryDateValidation(expiryDate)){
            return ON_SALE;
        } else {
            return NOT_FOR_SALE;
        }
    }

    public double productPrice(int status, double unitPrice) {
        if (status == ON_SALE){
            return (unitPrice - (unitPrice * salePercent));
        } else {
            return unitPrice;
        }
    }





    public int insertAndGetGeneratedId(Connection connection, ItemDTO item) throws SQLException {
        String insertQuery = "INSERT INTO item VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setString(3, item.getCategory());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1; // Return -1 if no generated key is retrieved
    }

    public List<InventoryItemDTO> retrieveInventory(Connection connection, int retailerId) {
        List<InventoryItemDTO> inventory = new ArrayList<>();

        String query = "SELECT i.name, i.category, ri.quantity, ri.expiry_date, ri.final_price " +
                "FROM item i " +
                "JOIN retailer_inventory ri ON i.id = ri.item_id " +
                "WHERE ri.users_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, retailerId); // Set the retailer ID parameter
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int quantity = resultSet.getInt("quantity");
                Date expiryDate = resultSet.getDate("expiry_date");
                double finalPrice = resultSet.getDouble("final_price");

                InventoryItemDTO item = new InventoryItemDTO(name, category, quantity, expiryDate, finalPrice);
                inventory.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, such as logging or throwing it
        }

        return inventory;
    }
}


package dataaccesslayer;

import transferobjects.RetailerInventoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RetailerInventoryDAOImpl implements RetailerInventoryDAO {

    @Override
    public void insertRetailerInventory(RetailerInventoryDTO retailerInventory) throws SQLException {
        String sql = "INSERT INTO retailer_inventory (id, users_id, item_id, batch, expiry_date, quantity, unit_price, final_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, retailerInventory.getId()); // Set the RetailerInventoryID manually
            pstmt.setInt(2, retailerInventory.getUsersId());
            pstmt.setInt(3, retailerInventory.getItemId());
            pstmt.setInt(4, retailerInventory.getBatch());
            pstmt.setTimestamp(5, new java.sql.Timestamp(retailerInventory.getExpiryDate().getTime()));
            pstmt.setInt(6, retailerInventory.getQuantity());
            pstmt.setDouble(7, retailerInventory.getUnitPrice());
            pstmt.setDouble(8, retailerInventory.getFinalPrice());
            pstmt.executeUpdate();
        }
    }

    @Override
    public RetailerInventoryDTO getRetailerInventoryById(int inventoryId) {
        String sql = "SELECT * FROM retailer_inventory WHERE id = ?";
        RetailerInventoryDTO inventory = null;
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, inventoryId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                inventory = new RetailerInventoryDTO();
                inventory.setId(rs.getInt("id"));
                inventory.setUsersId(rs.getInt("users_id"));
                inventory.setItemId(rs.getInt("item_id"));
                inventory.setBatch(rs.getInt("batch"));
                inventory.setExpiryDate(rs.getTimestamp("expiry_date"));
                inventory.setQuantity(rs.getInt("quantity"));
                inventory.setUnitPrice(rs.getDouble("unit_price"));
                inventory.setFinalPrice(rs.getDouble("final_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public List<RetailerInventoryDTO> getAllRetailerInventories() {
        List<RetailerInventoryDTO> inventories = new ArrayList<>();
        String sql = "SELECT * FROM retailer_inventory";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                RetailerInventoryDTO inventory = new RetailerInventoryDTO();
                inventory.setId(rs.getInt("id"));
                inventory.setUsersId(rs.getInt("users_id"));
                inventory.setItemId(rs.getInt("item_id"));
                inventory.setBatch(rs.getInt("batch"));
                inventory.setExpiryDate(rs.getTimestamp("expiry_date"));
                inventory.setQuantity(rs.getInt("quantity"));
                inventory.setUnitPrice(rs.getDouble("unit_price"));
                inventory.setFinalPrice(rs.getDouble("final_price"));
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    @Override
    public void updateRetailerInventory(RetailerInventoryDTO retailerInventory) {
        String sql = "UPDATE retailer_inventory SET users_id = ?, item_id = ?, batch = ?, expiry_date = ?, quantity = ?, unit_price = ?, final_price = ? WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, retailerInventory.getUsersId());
            pstmt.setInt(2, retailerInventory.getItemId());
            pstmt.setInt(3, retailerInventory.getBatch());
            pstmt.setTimestamp(4, new java.sql.Timestamp(retailerInventory.getExpiryDate().getTime()));
            pstmt.setInt(5, retailerInventory.getQuantity());
            pstmt.setDouble(6, retailerInventory.getUnitPrice());
            pstmt.setDouble(7, retailerInventory.getFinalPrice());
            pstmt.setInt(8, retailerInventory.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRetailerInventory(int inventoryId) {
        String sql = "DELETE FROM retailer_inventory WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, inventoryId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

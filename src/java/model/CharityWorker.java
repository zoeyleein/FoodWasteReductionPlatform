package model;

import transferobjects.InventoryItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharityWorker {

    public List<InventoryItemDTO> displayCharityClaims(Connection connection) {
        String query = "SELECT i.name, i.category, r.expiry_date, r.quantity, r.id "
                + "FROM item i "
                + "JOIN retailer_inventory r ON i.id = r.item_id "
                + "WHERE r.quantity > 0 AND r.donation = 1";
        List<InventoryItemDTO> items = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                InventoryItemDTO item = new InventoryItemDTO();
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setExpiryDate(rs.getDate("expiry_date"));
                item.setQuantity(rs.getInt("quantity"));
                item.setId(rs.getInt("id"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean claimItem(Connection connection, int itemId, int claimedQuantity) throws SQLException {
        boolean claimSuccessful = false;
        connection.setAutoCommit(false);
        String updateQuery = "UPDATE retailer_inventory SET quantity = quantity - ? WHERE id = ? AND quantity >= ?";

        try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
            updateStmt.setInt(1, claimedQuantity);
            updateStmt.setInt(2, itemId);
            updateStmt.setInt(3, claimedQuantity);

            int affectedRows = updateStmt.executeUpdate();
            if (affectedRows > 0) {
                connection.commit();
                claimSuccessful = true;
            } else {
                connection.rollback();
                claimSuccessful = false;
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
        return claimSuccessful;
    }



}

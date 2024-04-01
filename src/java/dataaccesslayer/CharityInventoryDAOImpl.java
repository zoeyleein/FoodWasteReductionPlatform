package dataaccesslayer;

import transferobjects.CharityInventoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharityInventoryDAOImpl implements CharityInventoryDAO {

    @Override
    public void insertCharityInventory(CharityInventoryDTO charityInventory) throws SQLException {
        String sql = "INSERT INTO charity_inventory (id, users_id, quantity, userInventory_id) VALUES (?, ?, ?, ?)";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, charityInventory.getId());
            pstmt.setInt(2, charityInventory.getUsersId());
            pstmt.setString(3, charityInventory.getQuantity());
            pstmt.setInt(4, charityInventory.getUserInventoryId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public CharityInventoryDTO getCharityInventoryById(int inventoryId) {
        String sql = "SELECT * FROM charity_inventory WHERE id = ?";
        CharityInventoryDTO inventory = null;
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, inventoryId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                inventory = new CharityInventoryDTO();
                inventory.setId(rs.getInt("id"));
                inventory.setUsersId(rs.getInt("users_id"));
                inventory.setQuantity(rs.getString("quantity"));
                inventory.setUserInventoryId(rs.getInt("userInventory_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public List<CharityInventoryDTO> getAllCharityInventories() {
        List<CharityInventoryDTO> inventories = new ArrayList<>();
        String sql = "SELECT * FROM charity_inventory";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                CharityInventoryDTO inventory = new CharityInventoryDTO();
                inventory.setId(rs.getInt("id"));
                inventory.setUsersId(rs.getInt("users_id"));
                inventory.setQuantity(rs.getString("quantity"));
                inventory.setUserInventoryId(rs.getInt("userInventory_id"));
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    @Override
    public void updateCharityInventory(CharityInventoryDTO charityInventory) {
        String sql = "UPDATE charity_inventory SET users_id = ?, quantity = ?, userInventory_id = ? WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, charityInventory.getUsersId());
            pstmt.setString(2, charityInventory.getQuantity());
            pstmt.setInt(3, charityInventory.getUserInventoryId());
            pstmt.setInt(4, charityInventory.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCharityInventory(int inventoryId) {
        String sql = "DELETE FROM charity_inventory WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, inventoryId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.ItemDTO;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public void insertItem(ItemDTO item) throws SQLException {
        String sql = "INSERT INTO item (id, name, category) VALUES (?, ?, ?)";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setString(3, item.getCategory());
            pstmt.executeUpdate();
            System.out.println("Item inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to insert item");
        }
    }

    @Override
    public ItemDTO getItemById(int itemId) {
        String sql = "SELECT * FROM item WHERE id = ?";
        ItemDTO item = null;
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    item = new ItemDTO();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCategory(rs.getString("category"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> items = new ArrayList<>();
        String sql = "SELECT * FROM item";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ItemDTO item = new ItemDTO();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public void updateItem(ItemDTO item) {
        String sql = "UPDATE item SET name = ?, category = ? WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getCategory());
            pstmt.setInt(3, item.getId());
            pstmt.executeUpdate();
            System.out.println("Item updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int itemId) {
        String sql = "DELETE FROM item WHERE id = ?";
        try (Connection con = DataSource.createConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();
            System.out.println("Item deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

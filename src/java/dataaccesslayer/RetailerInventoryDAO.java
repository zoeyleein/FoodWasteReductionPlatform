package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.RetailerInventoryDTO;

public interface RetailerInventoryDAO {

    void insertRetailerInventory(RetailerInventoryDTO retailerInventory) throws SQLException;

    RetailerInventoryDTO getRetailerInventoryById(int inventoryId);

    List<RetailerInventoryDTO> getAllRetailerInventories();

    void updateRetailerInventory(RetailerInventoryDTO retailerInventory);

    void deleteRetailerInventory(int inventoryId);
}

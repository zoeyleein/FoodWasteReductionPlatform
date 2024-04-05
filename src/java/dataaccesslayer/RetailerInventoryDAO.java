package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.RetailerInventoryDTO;

public interface RetailerInventoryDAO {

    public void insertRetailerInventory(RetailerInventoryDTO retailerInventory) throws SQLException;

    public RetailerInventoryDTO getRetailerInventoryById(int inventoryId);

    public List<RetailerInventoryDTO> getAllRetailerInventories();

    public void updateRetailerInventory(RetailerInventoryDTO retailerInventory);

    public void deleteRetailerInventory(int inventoryId);


}

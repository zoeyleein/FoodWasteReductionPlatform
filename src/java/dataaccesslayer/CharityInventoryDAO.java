package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.CharityInventoryDTO;

public interface CharityInventoryDAO {


    void insertCharityInventory(CharityInventoryDTO charityInventory) throws SQLException;

    CharityInventoryDTO getCharityInventoryById(int inventoryId);

    List<CharityInventoryDTO> getAllCharityInventories();

    void updateCharityInventory(CharityInventoryDTO charityInventory);

    void deleteCharityInventory(int inventoryId);
}

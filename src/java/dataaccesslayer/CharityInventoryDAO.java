package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.CharityInventoryDTO;

public interface CharityInventoryDAO {


    public void insertCharityInventory(CharityInventoryDTO charityInventory) throws SQLException;

    public CharityInventoryDTO getCharityInventoryById(int inventoryId);

    public List<CharityInventoryDTO> getAllCharityInventories();

    public void updateCharityInventory(CharityInventoryDTO charityInventory);

    public void deleteCharityInventory(int inventoryId);


}

package dataaccesslayer;

import transferobjects.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

    void insertItem(ItemDTO item) throws SQLException;

    ItemDTO getItemById(int itemId);

    List<ItemDTO> getAllItems();

    void updateItem(ItemDTO item);

    void deleteItem(int itemId);
}
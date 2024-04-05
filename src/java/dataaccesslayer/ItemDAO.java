package dataaccesslayer;

import transferobjects.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

    public void insertItem(ItemDTO item) throws SQLException;

    public ItemDTO getItemById(int itemId);

    public List<ItemDTO> getAllItems();

    public void updateItem(ItemDTO item);

    public void deleteItem(int itemId);


}
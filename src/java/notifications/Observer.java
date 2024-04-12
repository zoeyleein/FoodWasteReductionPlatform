package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

import java.sql.Connection;

public interface Observer {
    void update(RetailerInventoryDTO retailerInventory, Connection connection);
    void setUserPreferences(String phone);
}

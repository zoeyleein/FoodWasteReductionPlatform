package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

public interface Observer {
    void update(RetailerInventoryDTO retailerInventory);
    void setUserPreferences(String phone);
}

package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

public interface Observer {
    void update();
    void setUserPreferences(String phone);
}

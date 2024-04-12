package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

import java.sql.Connection;

public interface Subject {
    void registerObserver(Observer observer, String phone);
    void removeObserver(Observer observer);
    void notifyObservers(RetailerInventoryDTO retailerInventory, Connection connection);
}
package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

public interface Subject {
    void registerObserver(Observer observer, String phone);
    void removeObserver(Observer observer);
    void notifyObservers();
}

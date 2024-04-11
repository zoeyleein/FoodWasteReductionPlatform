package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

public class NotificationObserver implements Observer{
       @Override
    public void update() {
           System.out.println("Notification observer update");
        // Logic to send notification to the user based on preferences
    }
}

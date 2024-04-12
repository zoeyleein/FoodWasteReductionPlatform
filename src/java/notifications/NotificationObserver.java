package notifications;

import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

public class NotificationObserver implements Observer{
    private String userEmail;
    private String userPhone;

    @Override
    public void setUserPreferences(String phone) {
        this.userPhone = phone;
    }
       @Override
    public void update() {
           System.out.println("Notification observer update");
        // Logic to send notification to the user based on preferences
    }


}

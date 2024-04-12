package notifications;

import dataaccesslayer.DataSource;
import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class NotificationService implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer, String phone) {
        observer.setUserPreferences(phone);
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers(RetailerInventoryDTO retailerInventory) {
        for (Observer observer : observers) {};
    }
}

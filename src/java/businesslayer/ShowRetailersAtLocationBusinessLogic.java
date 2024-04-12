package businesslayer;

import dataaccesslayer.DataSource;
import dataaccesslayer.ItemDAOImpl;
import dataaccesslayer.RetailerInventoryDAOImpl;
import dataaccesslayer.UserDAOImpl;
import transferobjects.RetailerInventoryDTO;
import transferobjects.UserDTO;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRetailersAtLocationBusinessLogic {
    public ArrayList<UserDTO> getRetailersAtLocations(String location, ServletContext context) throws SQLException {
        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        DataSource dataSource = new DataSource(context);

        Connection connection = dataSource.getConnection();
        UserDAOImpl userDAO = new UserDAOImpl(connection);
        List<UserDTO> allUsers = userDAO.getAllUsers();

        for (UserDTO user : allUsers) {

            if(user.getLocation().toLowerCase().contains(location) && user.getRole().equals("Retailer")){
                userDTOS.add(user);
            }
        }
        return userDTOS;
    }

//    public ArrayList<RetailerInventoryDTO> getInventory(int id, ServletContext context) throws SQLException {
//        ArrayList<RetailerInventoryDTO> items = new ArrayList<>();
//        DataSource dataSource = new DataSource(context);
//
//        Connection connection = dataSource.getConnection();
//        RetailerInventoryDAOImpl retailerInventoryDAO = new RetailerInventoryDAOImpl(connection);
//       List<RetailerInventoryDTO> allItems = retailerInventoryDAO.getAllRetailerInventories();
//        for(RetailerInventoryDTO retailers:allItems){
//            if(retailers.getUsersId()==id){
//                items.add(retailers);
//            }
//        }
//        return items;
//    }

    public Map<Integer, RetailerInventoryDTO> getInventory(int userId, ServletContext context) throws SQLException {
        Map<Integer, RetailerInventoryDTO> itemsMap = new HashMap<>();
        DataSource dataSource = new DataSource(context);

        try (Connection connection = dataSource.getConnection()) {
            RetailerInventoryDAOImpl retailerInventoryDAO = new RetailerInventoryDAOImpl(connection);
            List<RetailerInventoryDTO> allItems = retailerInventoryDAO.getAllRetailerInventories();
            ItemDAOImpl itemDAO = new ItemDAOImpl(connection);
            for (RetailerInventoryDTO retailer : allItems) {
                if (retailer.getUsersId() == userId && retailer.getQuantity()>0) {
                    int itemId = retailer.getItemId();
                    itemsMap.put(itemId, retailer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return itemsMap;
    }

}

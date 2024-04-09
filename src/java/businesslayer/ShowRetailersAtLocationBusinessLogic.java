package businesslayer;

import dataaccesslayer.DataSource;
import dataaccesslayer.UserDAOImpl;
import transferobjects.UserDTO;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}

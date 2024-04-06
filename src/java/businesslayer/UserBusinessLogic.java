package businesslayer;

import dataaccesslayer.UserDAO;
import dataaccesslayer.UserDAOImpl;
import transferobjects.UserDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserBusinessLogic {

    private UserDAO userDao;

    public UserBusinessLogic(Connection con) {
        this.userDao = new UserDAOImpl(con);
    }

    public void addUser(UserDTO user) throws SQLException {
        userDao.insertUser(user);
    }

    public UserDTO getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public List<UserDTO> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(UserDTO user) throws SQLException {
        userDao.updateUser(user);
    }

    public void deleteUser(int userId) throws SQLException {
        userDao.deleteUser(userId);
    }
}

package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.UserDTO;

public interface UserDAO {

    public void insertUser(UserDTO user) throws SQLException;

    public UserDTO getUserById(int userId);

    public List<UserDTO> getAllUsers();

    public void updateUser(UserDTO user);

    public void deleteUser(int userId);
}
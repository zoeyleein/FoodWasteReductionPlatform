package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.UserAccountDTO;

public interface UserAccountDAO {

    public void insertUserAccount(UserAccountDTO userAccount) throws SQLException;

    public UserAccountDTO getUserAccountById(int accountId);

    public List<UserAccountDTO> getAllUserAccounts();

    public void updateUserAccount(UserAccountDTO userAccount);

    public void deleteUserAccount(int accountId);
}

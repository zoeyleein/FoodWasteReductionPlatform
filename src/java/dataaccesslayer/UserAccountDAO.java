package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.UserAccountDTO;

public interface UserAccountDAO {

    void insertUserAccount(UserAccountDTO userAccount) throws SQLException;

    UserAccountDTO getUserAccountById(int accountId);

    List<UserAccountDTO> getAllUserAccounts();

    void updateUserAccount(UserAccountDTO userAccount);

    void deleteUserAccount(int accountId);
}

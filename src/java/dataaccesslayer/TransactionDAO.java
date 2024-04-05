package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.TransactionDTO;

public interface TransactionDAO {

    void insertTransaction(TransactionDTO transaction) throws SQLException;

    TransactionDTO getTransactionById(String transactionId);

    List<TransactionDTO> getAllTransactions();

    void updateTransaction(TransactionDTO transaction);

    void deleteTransaction(String transactionId);
}


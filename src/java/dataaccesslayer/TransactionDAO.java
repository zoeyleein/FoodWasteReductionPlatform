package dataaccesslayer;

import java.sql.SQLException;
import java.util.List;
import transferobjects.TransactionDTO;

public interface TransactionDAO {

    public void insertTransaction(TransactionDTO transaction) throws SQLException;

    public TransactionDTO getTransactionById(String transactionId);

    public List<TransactionDTO> getAllTransactions();

    public void updateTransaction(TransactionDTO transaction);

    public void deleteTransaction(String transactionId);
}


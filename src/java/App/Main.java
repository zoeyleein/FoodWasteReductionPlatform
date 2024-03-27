package App;

import dataaccesslayer.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DataSource.createConnection();
    }
}

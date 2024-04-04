package dataaccesslayer;

/**
 * Version: 2
 * Author: Mayank Arora
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * DataSource is a singleton class to connect to MySQL database.
 *
 */
public class DataSource {
    private static Properties dbProperties = new Properties();
    private static Connection connection = null;
    private static String url;
    private static String username;
    private static String password;


    /**
     * Sets database properties using the db.properties file.
     * Allows users to edit the file based on their configuration.
     */

    private static void loadDBProperties() {
        try (InputStream input = new FileInputStream("C:\\Users\\camil\\IdeaProjects\\FoodWasteReductionPlatform\\src\\db.properties")) {

            dbProperties.load(input);
            String dbType = dbProperties.getProperty("db");
            String name = dbProperties.getProperty("name");
            String host = dbProperties.getProperty("host");
            String port = dbProperties.getProperty("port");

            url = "jdbc:" + dbType + "://" + host + ":" + port + "/" + name;
            username = dbProperties.getProperty("user");
            password = dbProperties.getProperty("pass");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Creates a database connection after loading the properties.
     * The method prints "DB connected as a confirmation" or "
     * "Cannot create new connection, one exists already" if the database
     * is already connected.
     */

    public static Connection createConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                loadDBProperties();
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, username, password);
                System.out.printf("DB connected");
            } else {
                System.out.println("Cannot create new connection, one exists already");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}

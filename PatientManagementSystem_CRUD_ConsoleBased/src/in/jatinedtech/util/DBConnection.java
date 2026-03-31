package in.jatinedtech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DBURL = "jdbc:mysql://localhost:3306/patientdb";
    private static final String DBUSERNAME = "root";
    private static final String DBPASSWORD = "jatinsoni";

    private static Connection connection = null;

    // Private constructor (to prevent object creation)
    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        // Load Driver (only once)
        Class.forName("com.mysql.cj.jdbc.Driver");

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
        }

        return connection;
    }
}
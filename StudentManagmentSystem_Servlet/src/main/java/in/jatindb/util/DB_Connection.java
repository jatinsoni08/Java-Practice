package in.jatindb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {

	private static final String DBURL = "jdbc:mysql://localhost:3306/Servlet_Example";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "jatinsoni";

	private static Connection connection = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Check if connection is null OR closed
		if (connection == null || connection.isClosed()) {
			// Create new connection
			connection = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			System.out.println("New connection created"); 
		} else {
			System.out.println("Reusing existing connection");
		}

		return connection;
	}

}
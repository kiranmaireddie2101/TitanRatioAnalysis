package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/titan_ratio_db";

    private static final String USER = "root";
    private static final String PASSWORD = "mysystem";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database Connected Successfully!");
            return con;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(
                    "MySQL JDBC Driver not found: " + e.getMessage()
            );

        } catch (SQLException e) {
            throw new RuntimeException(
                    "MySQL Connection Failed: " + e.getMessage()
            );
        }
    }
}
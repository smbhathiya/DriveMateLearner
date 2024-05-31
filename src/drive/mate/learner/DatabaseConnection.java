/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drive.mate.learner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author smbha
 */
public class DatabaseConnection {

    // Default database URL, user, and password
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection = null;

    // Method to establish database connection
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String dbURL = getDatabaseURL();
                connection = DriverManager.getConnection(dbURL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close database connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the database URL based on the operating system
    private static String getDatabaseURL() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return "jdbc:mysql://localhost:3306/drivematedb"; // Windows - port 3306
        } else if (osName.contains("mac")) {
            return "jdbc:mysql://localhost:3308/drivematedb"; // Mac - port 3308
        } else {
            // Default to port 3306 for other operating systems
            return "jdbc:mysql://localhost:3306/drivematedb";
        }
    }
}


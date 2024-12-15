package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static Database instance;
    private Connection connection;

    private Database(){
        try {
            Class.forName("org.sqlite.JDBC");

            String dbPath = System.getProperty("user.home") + "/Desktop/webyes/database/library.db";
            String url = "jdbc:sqlite:" + dbPath;
            this.connection = DriverManager.getConnection(url);
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


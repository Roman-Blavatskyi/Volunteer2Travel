package com.softserve.firstdemo.dao;

//import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost/volunteer2travel?createDatabaseIfNotExist=true";
    private final static String NAME = "root";
    private final static String PASSWORD = "root";
    //    private static Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static DBConnection dbConnection;
    private static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch (SQLException | ClassNotFoundException e) {
           // Logger.getGlobal().info("Connected Error");
            e.printStackTrace();
        }
        return connection;
    }
}

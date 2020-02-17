package com.softserve.firstdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost/volunteer2travel?createDatabaseIfNotExist=true";
    private final static String NAME = "root";
    private final static String PASSWORD = "root";
    private static DBConnection dbConnection;
    private static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

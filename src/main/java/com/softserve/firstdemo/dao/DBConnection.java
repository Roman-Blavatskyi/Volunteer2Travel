package com.softserve.firstdemo.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost/volunteer2travel?createDatabaseIfNotExist=true";
    private final static String NAME = "root";
    private final static String PASSWORD = "root";
    private static Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static DBConnection dbConnection;
    private Connection connection = null;

    private DBConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            logger.info("Connection to Database was successful.");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("There are problems with Database connection.");
            logger.error(e);
        }

    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
            return dbConnection;
        } else {
            return dbConnection;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

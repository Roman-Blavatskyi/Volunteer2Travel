package com.softserve.firstdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private static final String CHECK_EMAIL_PASSWORD = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";


    public boolean checkUserCredentials(String email, String password) {
        boolean isUser = false;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMAIL_PASSWORD)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            isUser = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUser;
    }
}

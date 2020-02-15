package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;


public class UserDao implements IGeneralDao<User> {
    private static final String CREATE_USER =
            "INSERT INTO USERS (NAME, SURNAME, EMAIL, PASSWORD, PHONE, URLIMAGE, COUNTRYID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ALL_USERS = "SELECT * FROM USERS";
    private static final String READ_USER_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private static final String READ_USER_BY_EMAIL = "SELECT * FROM USERS WHERE EMAIL = ?";
    private static final String UPDATE_USER =
            "UPDATE USERS SET NAME=?, SURNAME=?, EMAIL=?, PASSWORD=?, PHONE=?, URLIMAGE=?, COUNTRYID=? WHERE ID = ?";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE ID = ?";
    //    private static Logger logger = Logger.getLogger(UserDao.class.getName());
    private static CountryDao countryDao = new CountryDao();

    @Override
    public void create(User user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getUrlImage());
            preparedStatement.setInt(7, user.getCountry().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           /* logger.info("There are problems with inserting into `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_USERS);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setUrlImage(resultSet.getString("urlImage"));
                user.setCountry(countryDao.readById(resultSet.getInt("countryId")));

                users.add(user);
            }
        } catch (SQLException e) {
        /*    logger.info("There are problems with reading all users from `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User readById(int id) {
        User user = new User();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setPhone(resultSet.getString("phone"));
            user.setUrlImage(resultSet.getString("urlImage"));
            user.setCountry(countryDao.readById(resultSet.getInt("countryId")));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
         /*   logger.info("There are problems with reading users by id from `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getUrlImage());
            preparedStatement.setInt(7, user.getCountry().getId());
            preparedStatement.setInt(8, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
       /*     logger.info("There are problems with updating `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
         /*   logger.info("There are problems with deleting from `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    public User readByEmail(String email) {
        User user = new User();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_EMAIL)) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setUrlImage(resultSet.getString("urlImage"));
                user.setCountry(countryDao.readById(resultSet.getInt("countryId")));
                user.setUserRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
         /*   logger.info("There are problems with reading users by id from `Users` table | UserDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return user;
    }
}

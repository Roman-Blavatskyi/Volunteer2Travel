package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Background;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackgroundDao implements IGeneralDao<Background> {
    private static final String CREATE_BACKGROUND = "INSERT INTO BACKGROUNDS (NAME) VALUES (?)";
    private static final String READ_ALL_BACKGROUNDS = "SELECT * FROM BACKGROUNDS";
    private static final String READ_BACKGROUND_BY_ID = "SELECT * FROM BACKGROUNDS WHERE ID = ?";
    private static final String READ_BACKGROUND_BY_NAME = "SELECT * FROM BACKGROUNDS WHERE NAME = ?";
    private static final String UPDATE_BACKGROUND = "UPDATE BACKGROUNDS SET NAME=? WHERE ID = ?";
    private static final String DELETE_BACKGROUND = "DELETE FROM BACKGROUNDS WHERE ID = ?";

    @Override
    public void create(Background background) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BACKGROUND)) {

            preparedStatement.setString(1, background.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Background> readAll() {
        List<Background> backgrounds = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_BACKGROUNDS);

            while (resultSet.next()) {
                Background background = new Background();
                background.setId(resultSet.getInt("id"));
                background.setName(resultSet.getString("name"));

                backgrounds.add(background);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return backgrounds;
    }

    @Override
    public Background readById(int id) {
        Background background = new Background();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_BACKGROUND_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                background.setId(resultSet.getInt("id"));
                background.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return background;
    }

    @Override
    public void update(Background background) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BACKGROUND)) {

            preparedStatement.setString(1, background.getName());
            preparedStatement.setInt(2, background.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BACKGROUND)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Background readByName(String name) {
        Background background = new Background();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_BACKGROUND_BY_NAME)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                background.setId(resultSet.getInt("id"));
                background.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return background;
    }
}

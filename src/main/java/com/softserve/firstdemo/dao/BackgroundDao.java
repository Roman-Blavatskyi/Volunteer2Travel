package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Background;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BackgroundDao implements IGeneralDao<Background, Integer> {
    private static final String CREATE_BACKGROUND = "INSERT INTO BACKGROUNDS (NAME) VALUES (?)";
    private static final String READ_ALL_BACKGROUNDS = "SELECT * FROM BACKGROUNDS";
    private static final String READ_BACKGROUND_BY_ID = "SELECT * FROM BACKGROUNDS WHERE ID = ?";
    private static final String UPDATE_BACKGROUND = "UPDATE BACKGROUNDS SET NAME=? WHERE ID = ?";
    private static final String DELETE_BACKGROUND = "DELETE FROM BACKGROUNDS WHERE ID = ?";
    private static Logger logger = Logger.getLogger(BackgroundDao.class.getName());

    @Override
    public void create(Background background) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BACKGROUND)) {

            preparedStatement.setString(1, background.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with inserting into `Backgrounds` table | BackgroundDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Background> readAll() {
        List<Background> backgrounds = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_BACKGROUNDS);

            while (resultSet.next()) {
                Background background = new Background();
                background.setId(resultSet.getInt("id"));
                background.setName(resultSet.getString("name"));

                backgrounds.add(background);
            }
        } catch (SQLException e) {
            logger.error("There are problems with reading all backgrounds from `Backgrounds` table | BackgroundDAO Exception.");
            e.printStackTrace();
        }
        return backgrounds;
    }

    @Override
    public Background readById(Integer id) {
        Background background = new Background();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_BACKGROUND_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            background.setId(resultSet.getInt("id"));
            background.setName(resultSet.getString("name"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with reading by id from `Backgrounds` table | BackgroundDAO Exception.");
            e.printStackTrace();
        }
        return background;
    }

    @Override
    public void update(Background background, Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BACKGROUND)) {

            preparedStatement.setString(1, background.getName());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with updating `Backgrounds` table | BackgroundDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BACKGROUND)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with deleting from `Backgrounds` table | BackgroundDAO Exception.");
            e.printStackTrace();
        }
    }
}

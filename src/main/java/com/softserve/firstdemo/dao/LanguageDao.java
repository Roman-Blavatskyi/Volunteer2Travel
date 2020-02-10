package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Language;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDao implements IGeneralDao<Language, Integer> {
    private static final String CREATE_LANGUAGE = "INSERT INTO LANGUAGES (NAME) VALUES (?)";
    private static final String READ_ALL_LANGUAGES = "SELECT * FROM LANGUAGES";
    private static final String READ_LANGUAGE_BY_ID = "SELECT * FROM LANGUAGES WHERE ID = ?";
    private static final String UPDATE_LANGUAGE = "UPDATE LANGUAGES SET NAME=? WHERE ID = ?";
    private static final String DELETE_LANGUAGE = "DELETE FROM LANGUAGES WHERE ID = ?";
    private static Logger logger = Logger.getLogger(LanguageDao.class.getName());

    @Override
    public void create(Language language) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_LANGUAGE)) {

            preparedStatement.setString(1, language.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with inserting into `Languages` table | LanguageDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Language> readAll() {
        List<Language> languages = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_LANGUAGES);

            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));

                languages.add(language);
            }
        } catch (SQLException e) {
            logger.error("There are problems with reading all languages from `Languages` table | LanguageDAO Exception.");
            e.printStackTrace();
        }
        return languages;
    }

    @Override
    public Language readById(Integer id) {
        Language language = new Language();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_LANGUAGE_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            language.setId(resultSet.getInt("id"));
            language.setName(resultSet.getString("name"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with reading by id from `Languages` table | LanguageDAO Exception.");
            e.printStackTrace();
        }
        return language;
    }

    @Override
    public void update(Language language, Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LANGUAGE)) {

            preparedStatement.setString(1, language.getName());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with updating `Languages` table | LanguageDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LANGUAGE)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with deleting from `Languages` table | LanguageDAO Exception.");
            e.printStackTrace();
        }
    }
}

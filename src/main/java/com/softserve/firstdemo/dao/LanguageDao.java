package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDao implements IGeneralDao<Language> {
    private static final String CREATE_LANGUAGE = "INSERT INTO LANGUAGES (NAME) VALUES (?)";
    private static final String READ_ALL_LANGUAGES = "SELECT * FROM LANGUAGES";
    private static final String READ_LANGUAGE_BY_ID = "SELECT * FROM LANGUAGES WHERE ID = ?";
    private static final String READ_LANGUAGE_BY_NAME = "SELECT * FROM LANGUAGES WHERE NAME = ?";
    private static final String UPDATE_LANGUAGE = "UPDATE LANGUAGES SET NAME=? WHERE ID = ?";
    private static final String DELETE_LANGUAGE = "DELETE FROM LANGUAGES WHERE ID = ?";

    @Override
    public void create(Language language) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_LANGUAGE)) {

            preparedStatement.setString(1, language.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Language> readAll() {
        List<Language> languages = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_LANGUAGES);

            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));

                languages.add(language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return languages;
    }

    @Override
    public Language readById(int id) {
        Language language = new Language();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_LANGUAGE_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }

    @Override
    public Language readByName(String name) {
        Language language = new Language();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_LANGUAGE_BY_NAME)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return language;
    }

    @Override
    public void update(Language language) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LANGUAGE)) {

            preparedStatement.setString(1, language.getName());
            preparedStatement.setInt(2, language.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LANGUAGE)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

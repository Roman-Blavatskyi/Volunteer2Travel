package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements IGeneralDao<Country> {
    private static final String CREATE_COUNTRY = "INSERT INTO COUNTRIES (NAME) VALUES (?)";
    private static final String READ_ALL_COUNTRIES = "SELECT * FROM COUNTRIES";
    private static final String READ_COUNTRY_BY_ID = "SELECT * FROM COUNTRIES WHERE ID = ?";
    private static final String READ_COUNTRY_BY_NAME = "SELECT * FROM COUNTRIES WHERE NAME = ?";
    private static final String UPDATE_COUNTRY = "UPDATE COUNTRIES SET NAME=? WHERE ID = ?";
    private static final String DELETE_COUNTRY = "DELETE FROM COUNTRIES WHERE ID = ?";

    @Override
    public void create(Country country) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_COUNTRY)) {

            preparedStatement.setString(1, country.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> readAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_COUNTRIES);

            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));

                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country readById(int id) {
        Country country = new Country();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_COUNTRY_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public Country readByName(String name) {
        Country country = new Country();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_COUNTRY_BY_NAME)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(Country country) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COUNTRY)) {

            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COUNTRY)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

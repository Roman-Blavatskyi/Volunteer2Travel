package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements IGeneralDao<City> {
    private static final String CREATE_CITY = "INSERT INTO CITIES (NAME) VALUES (?)";
    private static final String READ_ALL_CITIES = "SELECT * FROM CITIES";
    private static final String READ_CITY_BY_ID = "SELECT * FROM CITIES WHERE ID = ?";
    private static final String READ_CITY_BY_NAME = "SELECT * FROM CITIES WHERE NAME = ?";
    private static final String UPDATE_CITY = "UPDATE CITIES SET NAME=? WHERE ID = ?";
    private static final String DELETE_CITY = "DELETE FROM CITIES WHERE ID = ?";

    @Override
    public void create(City city) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CITY)) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
     /*       logger.info("There are problems with inserting into `Country` database | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public List<City> readAll() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_CITIES);

            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));

                cities.add(city);
            }
        } catch (SQLException e) {
      /*      logger.info("There are problems with reading all cities from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public City readById(int id) {
        City city = new City();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_CITY_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            city.setId(resultSet.getInt("id"));
            city.setName(resultSet.getString("name"));

        } catch (SQLException e) {
  /*          logger.info("There are problems with reading by id from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void update(City city) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITY)) {

            preparedStatement.setString(1, city.getName());
            preparedStatement.setInt(2, city.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
/*            logger.info("There are problems with updating `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITY)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
   /*         logger.info("There are problems with deleting from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    public City readCityByName(String name) {
        City city = new City();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_CITY_BY_NAME)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next() == false) {
                return null;
            } else {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
            }

        } catch (SQLException e) {
  /*          logger.info("There are problems with reading by id from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return city;
    }
}

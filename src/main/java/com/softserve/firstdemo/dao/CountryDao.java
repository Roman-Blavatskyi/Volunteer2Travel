package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Country;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao implements IGeneralDao<Country, Integer> {
    private static final String CREATE_COUNTRY = "INSERT INTO COUNTRIES (NAME) VALUES (?)";
    private static final String READ_ALL_COUNTRIES = "SELECT * FROM COUNTRIES";
    private static final String READ_COUNTRY_BY_ID = "SELECT * FROM COUNTRIES WHERE ID = ?";
    private static final String UPDATE_COUNTRY = "UPDATE COUNTRIES SET NAME=? WHERE ID = ?";
    private static final String DELETE_COUNTRY = "DELETE FROM COUNTRIES WHERE ID = ?";
//    private static Logger logger = Logger.getLogger(CountryDao.class.getName());

    @Override
    public void create(Country country) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_COUNTRY)) {

            preparedStatement.setString(1, country.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
     /*       logger.info("There are problems with inserting into `Country` database | CountryDAO Exception.");
            logger.info(e);*/
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
      /*      logger.info("There are problems with reading all countries from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country readById(Integer id) {
        Country country = new Country();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_COUNTRY_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
  /*          logger.info("There are problems with reading by id from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(Country country, Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COUNTRY)) {

            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
/*            logger.info("There are problems with updating `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COUNTRY)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
   /*         logger.info("There are problems with deleting from `Country` table | CountryDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }
}

package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Location;
//import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDao implements IGeneralDao<Location, Integer> {
    private static final String CREATE_LOCATION = "INSERT INTO LOCATIONS (COUNTRYID, CITY) VALUES (?, ?)";
    private static final String READ_ALL_LOCATIONS = "SELECT * FROM LOCATIONS";
    private static final String READ_LOCATION_BY_ID = "SELECT * FROM LOCATIONS WHERE ID = ?";
    private static final String UPDATE_LOCATION = "UPDATE LOCATIONS SET COUNTRYID=?, CITY=?  WHERE ID = ?";
    private static final String DELETE_LOCATION = "DELETE FROM LOCATIONS WHERE ID = ?";
    private static CountryDao countryDao = new CountryDao();
//    private static Logger logger = Logger.getLogger(LocationDao.class.getName());

    @Override
    public void create(Location location) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_LOCATION)) {

            preparedStatement.setInt(1, location.getCountry().getId());
            preparedStatement.setString(2, location.getCity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
       /*     logger.info("There are problems with inserting into `Locations` table | LocationDAO Exceptions.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public List<Location> readAll() {
        List<Location> locations = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_LOCATIONS);

            while (resultSet.next()) {
                Location location = new Location();
                location.setId(resultSet.getInt("id"));
                location.setCountry(countryDao.readById(resultSet.getInt("countryId")));
                location.setCity(resultSet.getString("city"));

                locations.add(location);
            }
        } catch (SQLException e) {
/*            logger.info("There are problems with reading all locations from `Locations` table | LocationDAO Exceptions.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location readById(Integer id) {
        Location location = new Location();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_LOCATION_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            location.setId(resultSet.getInt("id"));
            location.setCountry(countryDao.readById(resultSet.getInt("countryId")));
            location.setCity(resultSet.getString("city"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
    /*        logger.info("There are problems with reading by id from `Locations` table | LocationDAO Exceptions.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void update(Location location, Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOCATION)) {

            preparedStatement.setObject(1, location.getCountry());
            preparedStatement.setString(2, location.getCity());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
  /*          logger.info("There are problems with updating `Locations` table | LocationDAO Exceptions.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LOCATION)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
   /*         logger.info("There are problems with deleting from `Locations` table | LocationDAO Exceptions.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }
}

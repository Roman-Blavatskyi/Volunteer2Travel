package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.City;
import com.softserve.firstdemo.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

public class ProjectDao implements IGeneralDao<Project> {
    private static final String CREATE_PROJECT =
            "INSERT INTO PROJECTS (name, description, startDate, duration, urlImage, locationId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    private static final String READ_PROJECT_BY_ID = "SELECT * FROM PROJECTS WHERE ID = ?";
    private static final String UPDATE_PROJECT =
            "UPDATE SET PROJECTS NAME=?, DESCRIPTION=?, STARTDATE=?, DURATION=?, URLIMAGE=?, LOCATIONID=?  WHERE ID = ?";
    private static final String DELETE_PROJECT = "DELETE FROM PROJECTS WHERE ID = ?";
    private static CountryDao countryDao = new CountryDao();
    private static CityDao cityDao = new CityDao();
    //    private static Logger logger = Logger.getLogger(ProjectDao.class.getName());

    @Override
    public void create(Project project) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PROJECT)) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, (Date) project.getStartDate());
            preparedStatement.setInt(4, project.getDuration());
            preparedStatement.setString(5, project.getUrlImage());
            preparedStatement.setInt(6, project.getCountry().getId());
            preparedStatement.setInt(7, project.getCity().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
      /*      logger.info("There are problems with inserting into `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> readAll() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(READ_ALL_PROJECTS)) {

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getDate("startDate"));
                project.setDuration(resultSet.getInt("duration"));
                project.setUrlImage(resultSet.getString("urlImage"));
                project.setCountry(countryDao.readById(resultSet.getInt("countryId")));
                project.setCity(cityDao.readById(resultSet.getInt("cityId")));

                projects.add(project);
            }
        } catch (SQLException e) {
           /* logger.info("There are problems with reading all projects from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Project readById(int id) {
        Project project = new Project();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_PROJECT_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getInt("id"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setStartDate(resultSet.getDate("startDate"));
            project.setDuration(resultSet.getInt("duration"));
            project.setUrlImage(resultSet.getString("urlImage"));
            project.setCountry(countryDao.readById(resultSet.getInt("countryId")));
            project.setCity(cityDao.readById(resultSet.getInt("cityId")));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
          /*  logger.info("There are problems with reading projects by id from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT)) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, (Date) project.getStartDate());
            preparedStatement.setInt(4, project.getDuration());
            preparedStatement.setString(5, project.getUrlImage());
            preparedStatement.setInt(6, project.getCountry().getId());
            preparedStatement.setInt(7, project.getCity().getId());
            preparedStatement.setInt(8, project.getId());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
       /*     logger.info("There are problems with updating `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        /*    logger.info("There are problems with deleting from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
    }
}

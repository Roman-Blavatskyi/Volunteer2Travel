package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Project;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao implements IGeneralDao<Project, Integer> {
    private static final String CREATE_PROJECT =
            "INSERT INTO PROJECTS (NAME, DESCRIPTION, STARTDATE, DURATION, URLIMAGE, LOCATIONID) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    private static final String READ_PROJECT_BY_ID = "SELECT * FROM PROJECTS WHERE ID = ?";
    private static final String UPDATE_PROJECT =
            "UPDATE SET PROJECTS NAME=?, DESCRIPTION=?, STARTDATE=?, DURATION=?, URLIMAGE=?, LOCATIONID=?  WHERE ID = ?";
    private static final String DELETE_PROJECT = "DELETE FROM PROJECTS WHERE ID = ?";
    private static Logger logger = Logger.getLogger(ProjectDao.class.getName());
    private static LocationDao locationDao;

    @Override
    public void create(Project project) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PROJECT)) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, (Date) project.getStartDate());
            preparedStatement.setInt(4, project.getDuration());
            preparedStatement.setString(5, project.getUrlImage());
            preparedStatement.setInt(6, project.getLocation().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with inserting into `Projects` table | ProjectDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> readAll() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_PROJECTS);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setStartDate(resultSet.getDate("startDate"));
                project.setDuration(resultSet.getInt("duration"));
                project.setUrlImage(resultSet.getString("urlImage"));
                project.setLocation(locationDao.readById(resultSet.getInt("locationId")));

                projects.add(project);
            }
        } catch (SQLException e) {
            logger.error("There are problems with reading all projects from `Projects` table | ProjectDAO Exception.");
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Project readById(Integer id) {
        Project project = new Project();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_PROJECT_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getInt("id"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setStartDate(resultSet.getDate("startDate"));
            project.setDuration(resultSet.getInt("duration"));
            project.setUrlImage(resultSet.getString("urlImage"));
            project.setLocation(locationDao.readById(resultSet.getInt("locationId")));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with reading projects by id from `Projects` table | ProjectDAO Exception.");
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project, Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT)) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, (Date) project.getStartDate());
            preparedStatement.setInt(4, project.getDuration());
            preparedStatement.setString(5, project.getUrlImage());
            preparedStatement.setInt(6, project.getLocation().getId());
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with updating `Projects` table | ProjectDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with deleting from `Projects` table | ProjectDAO Exception.");
            e.printStackTrace();
        }
    }
}

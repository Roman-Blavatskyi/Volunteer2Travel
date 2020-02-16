package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Background;
import com.softserve.firstdemo.entity.Language;
import com.softserve.firstdemo.entity.Project;
import com.softserve.firstdemo.entity.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

public class ProjectDao implements IGeneralDao<Project> {
    private static final String CREATE_PROJECT =
            "INSERT INTO PROJECTS (name, description, startDate, duration, urlImage, countryId, cityId) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    private static final String READ_PROJECT_BY_ID = "SELECT * FROM PROJECTS WHERE ID = ?";
    private static final String UPDATE_PROJECT = "UPDATE PROJECTS SET NAME=?, DESCRIPTION=?, STARTDATE=?, DURATION=?, URLIMAGE=?, COUNTRYID=?, CITYID=? WHERE ID = ?";
    private static final String DELETE_PROJECT = "DELETE FROM PROJECTS WHERE ID = ?";
    private static final String READ_ALL_BACKGROUNDS_OF_PROJECT = "SELECT backgrounds.id, backgrounds.name\n" +
            "FROM backgrounds INNER JOIN projects_backgrounds ON backgrounds.id = projects_backgrounds.backgroundId\n" +
            "WHERE projects_backgrounds.projectId = ?";
    private static final String READ_ALL_SKILLS_OF_PROJECT = "SELECT skills.id, skills.name\n" +
            "FROM skills INNER JOIN projects_skills ON skills.id = projects_skills.skillsId\n" +
            "WHERE projects_skills.projectId = ?";
    private static final String READ_ALL_LANGUAGES_OF_PROJECT = "SELECT languages.id, languages.name\n" +
            "FROM languages INNER JOIN projects_languages ON languages.id = projects_languages.languageId\n" +
            "WHERE projects_languages.projectId = ?";

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
            resultSet.next();

            project.setId(resultSet.getInt("id"));
            project.setName(resultSet.getString("name"));
            project.setDescription(resultSet.getString("description"));
            project.setStartDate(resultSet.getDate("startDate"));
            project.setDuration(resultSet.getInt("duration"));
            project.setUrlImage(resultSet.getString("urlImage"));
            project.setCountry(countryDao.readById(resultSet.getInt("countryId")));
            project.setCity(cityDao.readById(resultSet.getInt("cityId")));

        } catch (SQLException e) {
          /*  logger.info("There are problems with reading projects by id from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public Project readByName(String name) {
        return null;
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

    public List<Background> readProjectBackgroundsById(int id) {
        List<Background> backgrounds = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_BACKGROUNDS_OF_PROJECT)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Background background = new Background();
                background.setId(resultSet.getInt("id"));
                background.setName(resultSet.getString("name"));
                backgrounds.add(background);
            }
        } catch (SQLException e) {
/*            logger.info("There are problems with reading all projects from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return backgrounds;
    }

    public List<Skill> readProjectSkillsById(int id) {
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_SKILLS_OF_PROJECT)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt("id"));
                skill.setName(resultSet.getString("name"));
                skills.add(skill);
            }
        } catch (SQLException e) {
/*            logger.info("There are problems with reading all projects from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return skills;
    }

    public List<Language> readProjectLanguagesById(int id) {
        List<Language> languages = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_LANGUAGES_OF_PROJECT)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));
                languages.add(language);
            }
        } catch (SQLException e) {
/*            logger.info("There are problems with reading all projects from `Projects` table | ProjectDAO Exception.");
            logger.info(e);*/
            e.printStackTrace();
        }
        return languages;
    }
}

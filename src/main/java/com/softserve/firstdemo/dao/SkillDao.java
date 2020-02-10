package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Skill;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDao implements IGeneralDao<Skill, Integer> {
    private static final String CREATE_SKILL = "INSERT INTO SKILLS (NAME) VALUES (?)";
    private static final String READ_ALL_SKILLS = "SELECT * FROM SKILLS";
    private static final String READ_SKILL_BY_ID = "SELECT * FROM SKILLS WHERE ID = ?";
    private static final String UPDATE_SKILL = "UPDATE SKILLS SET NAME=? WHERE ID = ?";
    private static final String DELETE_SKILL = "DELETE FROM SKILLS WHERE ID = ?";
    private static Logger logger = Logger.getLogger(SkillDao.class.getName());

    @Override
    public void create(Skill skill) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SKILL)) {

            preparedStatement.setString(1, skill.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with inserting into `Skills` table | SkillDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> readAll() {
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_SKILLS);

            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt("id"));
                skill.setName(resultSet.getString("name"));

                skills.add(skill);
            }
        } catch (SQLException e) {
            logger.error("There are problems with reading all skills from `Skills` table | SkillDAO Exception.");
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public Skill readById(Integer id) {
        Skill skill = new Skill();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_SKILL_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            skill.setId(resultSet.getInt("id"));
            skill.setName(resultSet.getString("name"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with reading by id from `Skills` table | SkillDAO Exception.");
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void update(Skill skill, Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SKILL)) {

            preparedStatement.setString(1, skill.getName());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with updating `Skills` table | SkillDAO Exception.");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SKILL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with deleting from `Skills` table | SkillDAO Exception.");
            e.printStackTrace();
        }
    }
}

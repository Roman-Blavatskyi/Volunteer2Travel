package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Skill;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SkillDao implements IGeneralDao<Skill, Integer> {
    private static final String CREATE_SKILL = "INSERT INTO SKILLS (NAME) VALUES (?)";
    private static final String READ_ALL_SKILLS = "SELECT * FROM SKILLS";
    private static final String READ_SKILL_BY_ID = "SELECT * FROM SKILLS WHERE ID = ?";
    private static final String UPDATE_SKILL = "UPDATE SKILLS SET NAME=? WHERE ID = ?)";
    private static final String DELETE_SKILL = "DELETE FROM SKILLS WHERE ID = ?";
    private static Logger logger = Logger.getLogger(SkillDao.class.getName());

    @Override
    public void create(Skill skill) {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SKILL)) {

            preparedStatement.setInt(1, skill.getId());
            preparedStatement.setString(2, skill.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error("There are problems with inserting into `Skills` database.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("There are problems with connection closing.");
            }
        }

    }

    @Override
    public List<Skill> readAll() {
        return null;
    }

    @Override
    public Skill readById(Integer integer) {
        return null;
    }

    @Override
    public void update(Skill skill, Integer integer) {

    }

    @Override
    public void delete(Integer integer) {

    }
}

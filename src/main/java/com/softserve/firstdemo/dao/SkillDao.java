package com.softserve.firstdemo.dao;

import com.softserve.firstdemo.entity.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDao implements IGeneralDao<Skill> {
    private static final String CREATE_SKILL = "INSERT INTO SKILLS (NAME) VALUES (?)";
    private static final String READ_ALL_SKILLS = "SELECT * FROM SKILLS";
    private static final String READ_SKILL_BY_ID = "SELECT * FROM SKILLS WHERE ID = ?";
    private static final String READ_SKILL_BY_NAME = "SELECT * FROM SKILLS WHERE NAME = ?";
    private static final String UPDATE_SKILL = "UPDATE SKILLS SET NAME=? WHERE ID = ?";
    private static final String DELETE_SKILL = "DELETE FROM SKILLS WHERE ID = ?";

    @Override
    public void create(Skill skill) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_SKILL)) {

            preparedStatement.setString(1, skill.getName());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> readAll() {
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(READ_ALL_SKILLS);

            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getInt("id"));
                skill.setName(resultSet.getString("name"));

                skills.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }

    @Override
    public Skill readById(int id) {
        Skill skill = new Skill();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_SKILL_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                skill.setId(resultSet.getInt("id"));
                skill.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public Skill readByName(String name) {
        Skill skill = new Skill();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_SKILL_BY_NAME)) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == false) {
                return null;
            } else {
                skill.setId(resultSet.getInt("id"));
                skill.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void update(Skill skill) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SKILL)) {

            preparedStatement.setString(1, skill.getName());
            preparedStatement.setInt(2, skill.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SKILL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

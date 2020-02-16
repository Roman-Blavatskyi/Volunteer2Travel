package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.SkillDao;
import com.softserve.firstdemo.entity.Skill;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.util.List;

public class SkillService {
    private SkillDao skillDao = new SkillDao();
    private StringValidator stringValidator = new StringValidator();

    public void addSkill(String name) {
        Skill skill = new Skill();
        stringValidator.validateString(name);
        skill.setName(name);
        skillDao.create(skill);
    }

    public List<Skill> findAllSkills() {
        return skillDao.readAll();
    }

    public Skill findById(int id) {
        return skillDao.readById(id);
    }

    public Skill findSkillByName(String name) {
        return skillDao.readByName(name);
    }

    public void editSkill(int id, String name) {
        Skill skill = skillDao.readById(id);
        stringValidator.validateString(name);
        skill.setName(name);
        skillDao.update(skill);
    }

    public void deleteSkill(int id) {
        if (id != 0) {
            skillDao.delete(id);
        }
    }
}

package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.BackgroundDao;
import com.softserve.firstdemo.entity.Background;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.util.List;

public class BackgroundService {

    private BackgroundDao backgroundDao = new BackgroundDao();
    private StringValidator stringValidator = new StringValidator();

    public void addBackground(String name) {
        Background background = new Background();
        stringValidator.validateString(name);
        background.setName(name);

        backgroundDao.create(background);
    }

    public List<Background> findAllBackgrounds() {
        return backgroundDao.readAll();
    }

    public Background findById(int id) {
        return backgroundDao.readById(id);
    }

    public Background findBackgroundByName(String name) {
        return backgroundDao.readByName(name);
    }

    public void editBackground(int id, String name) {
        Background background = backgroundDao.readById(id);
        stringValidator.validateString(name);
        background.setName(name);

        backgroundDao.update(background);
    }

    public void deleteBackground(int id) {
        if (id != 0) {
            backgroundDao.delete(id);
        }
    }
}

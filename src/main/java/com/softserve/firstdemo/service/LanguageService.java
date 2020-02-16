package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.LanguageDao;
import com.softserve.firstdemo.entity.Language;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.util.List;

public class LanguageService {
    private LanguageDao languageDao = new LanguageDao();
    private StringValidator stringValidator = new StringValidator();

    public void addLanguage(String name) {
        Language language = new Language();
        stringValidator.validateString(name);
        language.setName(name);
        languageDao.create(language);
    }

    public List<Language> findAllLanguages() {
        return languageDao.readAll();
    }

    public Language findById(int id) {
        return languageDao.readById(id);
    }

    public Language findLanguageByName(String name) {
        return languageDao.readByName(name);
    }

    public void editLanguage(int id, String name) {
        Language Language = languageDao.readById(id);
        stringValidator.validateString(name);
        Language.setName(name);
        languageDao.update(Language);
    }

    public void deleteLanguage(int id) {
        if (id != 0) {
            languageDao.delete(id);
        }
    }
}

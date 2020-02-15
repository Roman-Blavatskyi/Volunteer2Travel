package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.CityDao;
import com.softserve.firstdemo.dao.CountryDao;
import com.softserve.firstdemo.dao.ProjectDao;
import com.softserve.firstdemo.entity.Project;
import com.softserve.firstdemo.service.validation.CityValidator;
import com.softserve.firstdemo.service.validation.CountryValidatorForProject;
import com.softserve.firstdemo.service.validation.IntegerValidator;
import com.softserve.firstdemo.service.validation.StringValidator;

import java.sql.Date;
import java.util.List;

//import org.apache.log4j.Logger;

public class ProjectService {
    //    private static Logger logger = Logger.getLogger(ProjectService.class);
    private ProjectDao projectDao = new ProjectDao();
    private CountryDao countryDao = new CountryDao();
    private CityDao cityDao = new CityDao();
    private StringValidator stringValidator = new StringValidator();
    private CountryValidatorForProject countryValidator = new CountryValidatorForProject();
    private CityValidator cityValidator = new CityValidator();
    private IntegerValidator integerValidator = new IntegerValidator();

    public void addProject(String name, String description, Date startDate, String duration,
                           String urlImage, String country, String city) {

        Project project = new Project();
        stringValidator.validateString(name);
        project.setName(name);
        stringValidator.validateString(description);
        project.setDescription(description);
        project.setStartDate(startDate);
        integerValidator.validateInteger(duration);
        project.setDuration(Integer.valueOf(duration));
        project.setUrlImage(urlImage);
        stringValidator.validateString(country);
        countryValidator.validateCountry(project, country);
        stringValidator.validateString(city);
        cityValidator.validateCity(project, city);

        projectDao.create(project);
    }

    public Project findById(int id) {
        return projectDao.readById(id);
    }

    public List<Project> findAllProjects() {
        return projectDao.readAll();
    }

    public void editProject(int id, String name, String description, Date startDate, String duration,
                            String urlImage, String country, String city) {

        Project project = projectDao.readById(id);

        stringValidator.validateString(name);
        project.setName(name);
        stringValidator.validateString(description);
        project.setDescription(description);
        project.setStartDate(startDate);
        integerValidator.validateInteger(duration);
        project.setDuration(Integer.valueOf(duration));
        project.setUrlImage(urlImage);
        stringValidator.validateString(country);
        countryValidator.validateCountry(project, country);
        stringValidator.validateString(city);
        cityValidator.validateCity(project, city);

        projectDao.update(project);

    }

    public void deleteProject(int id) {
        if (id != 0) {
            projectDao.delete(id);
        }
    }
}

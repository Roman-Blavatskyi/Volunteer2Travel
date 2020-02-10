package com.softserve.firstdemo.service;

import com.softserve.firstdemo.dao.ProjectDao;
import com.softserve.firstdemo.entity.Location;
import com.softserve.firstdemo.entity.Project;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

public class ProjectService {
    private static Logger logger = Logger.getLogger(ProjectService.class.getName());
    private ProjectDao projectDao = new ProjectDao();

    public void create(String name, String description, Date startDate, int duration, String urlImage, Location location) {
        Project project = new Project(name, description, startDate, duration, urlImage, location);
        projectDao.create(project);
    }

    public Project readById(int id) {
        return projectDao.readById(id);
    }

    public List<Project> readAllProjects() {
        return projectDao.readAll();
    }

    public void update(int id, String name, String description, Date startDate, int duration, String urlImage, Location location) {
        Project project = new Project();

        if (name != null && !name.equalsIgnoreCase("")) {
            project.setName(name);
        }

        if (description != null && !description.equalsIgnoreCase("")) {
            project.setDescription(description);
        }

        if (startDate != null && !name.equalsIgnoreCase("")) {
            project.setStartDate(startDate);
        }

        if (duration != 0) {
            project.setDuration(duration);
        }

        if (urlImage != null && !urlImage.equalsIgnoreCase("")) {
            project.setUrlImage(urlImage);
        }

        if (location != null) {
            project.setLocation(location);
        }

        projectDao.update(project, id);
    }

    public void delete(int id) {
        if (id != 0) {
            projectDao.delete(id);
        }
    }
}

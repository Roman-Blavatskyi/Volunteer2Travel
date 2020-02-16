package com.softserve.firstdemo.controller;

import com.softserve.firstdemo.entity.Project;
import com.softserve.firstdemo.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/explore/project")
public class ProjectServlet extends HttpServlet {

    private ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Project project = projectService.findById(id);
        req.setAttribute("project", project);
        req.setAttribute("backgrounds", projectService.findAllBackgroundsOfProject(id));
        req.setAttribute("skills", projectService.findAllSkillsOfProject(id));
        req.setAttribute("languages", projectService.findAllLanguagesOfProject(id));
        req.getRequestDispatcher("/views/project.jsp").forward(req, resp);
    }
}

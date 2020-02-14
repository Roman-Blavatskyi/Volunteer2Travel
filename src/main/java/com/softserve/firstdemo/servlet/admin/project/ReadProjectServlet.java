package com.softserve.firstdemo.servlet.admin.project;

import com.softserve.firstdemo.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/project")
public class ReadProjectServlet extends HttpServlet {

    private ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_projects", projectService.findAllProjects());
        req.getRequestDispatcher("/views/admin/project/admin-project.jsp").forward(req, resp);
    }
}
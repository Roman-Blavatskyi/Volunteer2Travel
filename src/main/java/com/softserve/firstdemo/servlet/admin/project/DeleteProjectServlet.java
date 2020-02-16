package com.softserve.firstdemo.servlet.admin.project;

import com.softserve.firstdemo.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-project")
public class DeleteProjectServlet extends HttpServlet {

    private ProjectService projectService = new ProjectService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        projectService.deleteProject(id);
        resp.sendRedirect("/admin-page/project");
    }
}

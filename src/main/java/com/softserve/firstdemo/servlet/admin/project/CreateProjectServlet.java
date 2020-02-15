package com.softserve.firstdemo.servlet.admin.project;

import com.softserve.firstdemo.service.ProjectService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/admin-page/create-project")
public class CreateProjectServlet extends HttpServlet {
    private ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/project/create-project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        String duration = req.getParameter("duration");
        String urlImage = req.getParameter("urlImage");
        String country = req.getParameter("country");
        String city = req.getParameter("city");

        try {
            projectService.addProject(name, description, startDate, duration, urlImage, country, city);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/project/admin-project.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/project/create-project.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

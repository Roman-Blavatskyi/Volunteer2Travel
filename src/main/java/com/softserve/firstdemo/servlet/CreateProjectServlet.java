package com.softserve.firstdemo.servlet;

import com.softserve.firstdemo.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/createProject")
public class CreateProjectServlet extends HttpServlet {
    private ProjectService projectService = new ProjectService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/createProject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date startDate = Date.valueOf(req.getParameter("startDate"));
        int duration = Integer.valueOf(req.getParameter("duration"));
        String urlImage = req.getParameter("urlImage");
        String country = req.getParameter("country");
        String city = req.getParameter("city");

        projectService.addProject(name, description, startDate, duration, urlImage, country, city);
        resp.sendRedirect("/views/explore");
    }
}

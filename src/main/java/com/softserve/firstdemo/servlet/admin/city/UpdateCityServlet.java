package com.softserve.firstdemo.servlet.admin.city;

import com.softserve.firstdemo.entity.City;
import com.softserve.firstdemo.service.CityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/update-city")
public class UpdateCityServlet extends HttpServlet {

    private CityService cityService = new CityService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        City city = cityService.findById(id);
        req.setAttribute("city", city);
        req.getRequestDispatcher("/views/admin/city/update-city.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        try {
            cityService.editCity(id, name);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/city/admin-city.jsp");
            requestDispatcher.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/city/admin-city.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}

package com.softserve.firstdemo.servlet.admin.city;

import com.softserve.firstdemo.service.CityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/create-city")
public class CreateCityServlet extends HttpServlet {

    private CityService cityService = new CityService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/city/create-city.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            cityService.addCity(name);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/city/admin-city.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/city/admin-city.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

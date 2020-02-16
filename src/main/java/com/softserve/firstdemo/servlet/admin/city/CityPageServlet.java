package com.softserve.firstdemo.servlet.admin.city;

import com.softserve.firstdemo.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/city")
public class CityPageServlet extends HttpServlet {

    private CityService cityService = new CityService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_cities", cityService.findAllCities());
        req.getRequestDispatcher("/views/admin/city/admin-city.jsp").forward(req, resp);
    }
}
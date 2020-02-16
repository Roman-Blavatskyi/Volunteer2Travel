package com.softserve.firstdemo.servlet.admin.city;

import com.softserve.firstdemo.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-city")
public class DeleteCityServlet extends HttpServlet {

    private CityService cityService = new CityService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        cityService.deleteCity(id);
        resp.sendRedirect("/admin-page/city");
    }
}

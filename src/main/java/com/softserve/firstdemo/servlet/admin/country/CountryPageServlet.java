package com.softserve.firstdemo.servlet.admin.country;

import com.softserve.firstdemo.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/country")
public class CountryPageServlet extends HttpServlet {

    private CountryService countryService = new CountryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_countries", countryService.findAllCountries());
        req.getRequestDispatcher("/views/admin/country/admin-country.jsp").forward(req, resp);
    }
}
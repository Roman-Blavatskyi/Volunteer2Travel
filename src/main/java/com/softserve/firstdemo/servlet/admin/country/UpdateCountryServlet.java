package com.softserve.firstdemo.servlet.admin.country;

import com.softserve.firstdemo.entity.Country;
import com.softserve.firstdemo.service.CountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/update-country")
public class UpdateCountryServlet extends HttpServlet {

    private CountryService countryService = new CountryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Country country = countryService.findById(id);
        req.setAttribute("country", country);
        req.getRequestDispatcher("/views/admin/country/update-country.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        try {
            countryService.editCountry(id, name);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/country/admin-country.jsp");
            requestDispatcher.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/country/admin-country.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}

package com.softserve.firstdemo.servlet.admin.country;

import com.softserve.firstdemo.service.CountryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/create-country")
public class CreateCountryServlet extends HttpServlet {

    private CountryService countryService = new CountryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/country/create-country.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            countryService.addCountry(name);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/country/admin-country.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/country/admin-country.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

package com.softserve.firstdemo.servlet.admin.country;

import com.softserve.firstdemo.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-country")
public class DeleteCountryServlet extends HttpServlet {

    private CountryService countryService = new CountryService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        countryService.deleteCountry(id);
        resp.sendRedirect("/admin-page/country");
    }
}

package com.softserve.firstdemo.servlet.admin.language;

import com.softserve.firstdemo.service.LanguageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/create-language")
public class CreateLanguageServlet extends HttpServlet {

    private LanguageService languageService = new LanguageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/language/create-language.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            languageService.addLanguage(name);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/language/admin-language.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/language/admin-language.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

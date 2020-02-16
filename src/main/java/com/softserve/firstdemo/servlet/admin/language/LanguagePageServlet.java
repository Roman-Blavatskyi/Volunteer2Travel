package com.softserve.firstdemo.servlet.admin.language;

import com.softserve.firstdemo.service.LanguageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/language")
public class LanguagePageServlet extends HttpServlet {

    private LanguageService languageService = new LanguageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_languages", languageService.findAllLanguages());
        req.getRequestDispatcher("/views/admin/language/admin-language.jsp").forward(req, resp);
    }
}
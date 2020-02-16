package com.softserve.firstdemo.servlet.admin.language;

import com.softserve.firstdemo.service.LanguageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-language")
public class DeleteLanguageServlet extends HttpServlet {

    private LanguageService languageService = new LanguageService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        languageService.deleteLanguage(id);
        resp.sendRedirect("/admin-page/language");
    }
}

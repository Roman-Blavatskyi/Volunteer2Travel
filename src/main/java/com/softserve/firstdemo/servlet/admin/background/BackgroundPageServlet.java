package com.softserve.firstdemo.servlet.admin.background;

import com.softserve.firstdemo.service.BackgroundService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/background")
public class BackgroundPageServlet extends HttpServlet {

    private BackgroundService backgroundService = new BackgroundService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_backgrounds", backgroundService.findAllBackgrounds());
        req.getRequestDispatcher("/views/admin/background/admin-background.jsp").forward(req, resp);
    }
}

package com.softserve.firstdemo.servlet.admin.background;

import com.softserve.firstdemo.service.BackgroundService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-background")
public class DeleteBackgroundServlet extends HttpServlet {

    private BackgroundService backgroundService = new BackgroundService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        backgroundService.deleteBackground(id);
        resp.sendRedirect("/admin-page/background");
    }
}

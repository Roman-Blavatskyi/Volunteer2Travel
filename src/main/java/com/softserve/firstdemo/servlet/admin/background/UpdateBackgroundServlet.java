package com.softserve.firstdemo.servlet.admin.background;

import com.softserve.firstdemo.entity.Background;
import com.softserve.firstdemo.service.BackgroundService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/update-background")
public class UpdateBackgroundServlet extends HttpServlet {

    private BackgroundService backgroundService = new BackgroundService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Background background = backgroundService.findById(id);
        req.setAttribute("background", background);
        req.getRequestDispatcher("/views/admin/background/update-background.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        try {
            backgroundService.editBackground(id, name);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/background/admin-background.jsp");
            requestDispatcher.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/background/admin-background.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}

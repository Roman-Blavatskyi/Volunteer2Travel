package com.softserve.firstdemo.servlet.user;

import com.softserve.firstdemo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/profile/personal-info/edit")
public class UserProfileEditServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("user", userService.findById(id));
        req.getRequestDispatcher("/views/user/user-profile-edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String country = req.getParameter("country");
        String urlImage = req.getParameter("urlImage");
        try {
            userService.editUser(id, name, surname, phone, country, urlImage);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/user/user.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/user/user.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

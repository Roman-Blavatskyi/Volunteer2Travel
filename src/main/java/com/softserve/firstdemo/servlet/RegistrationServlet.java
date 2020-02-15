package com.softserve.firstdemo.controller;

import com.softserve.firstdemo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String email = req.getParameter("e-mail");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeat password");

        try {
            userService.addUser(name, surname, country, phone, email, password, repeatPassword);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/login.jsp");
            req.setAttribute("msg", "You registered successfully!");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/registration.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

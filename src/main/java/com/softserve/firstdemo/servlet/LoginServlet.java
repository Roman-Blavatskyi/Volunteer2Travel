package com.softserve.firstdemo.controller;

import com.softserve.firstdemo.entity.User;
import com.softserve.firstdemo.service.LoginService;
import com.softserve.firstdemo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher = null;

        if (loginService.checkUserCredentials(email, password)) {
            User user = userService.findUserByEmail(email);
            if (userService.isUser(user.getUserRole())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("/user/home");
            } else if (userService.isAdmin(user.getUserRole())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("/admin-page");
            }
        } else {
            requestDispatcher = req.getRequestDispatcher("views/invalid-email-password.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}


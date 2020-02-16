package com.softserve.firstdemo.servlet.admin.skill;

import com.softserve.firstdemo.service.SkillService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/create-skill")
public class CreateSkillServlet extends HttpServlet {

    private SkillService skillService = new SkillService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/skill/create-skill.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            skillService.addSkill(name);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/admin/skill/admin-skill.jsp");
            rd.forward(req, resp);
        } catch (IllegalArgumentException e) {
            req.setAttribute("msg", e.getMessage());
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/admin/skill/admin-skill.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

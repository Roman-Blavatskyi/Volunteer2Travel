package com.softserve.firstdemo.servlet.admin.skill;

import com.softserve.firstdemo.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/skill")
public class SkillPageServlet extends HttpServlet {

    private SkillService skillService = new SkillService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admin_skills", skillService.findAllSkills());
        req.getRequestDispatcher("/views/admin/skill/admin-skill.jsp").forward(req, resp);
    }
}
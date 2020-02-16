package com.softserve.firstdemo.servlet.admin.skill;

import com.softserve.firstdemo.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-page/delete-skill")
public class DeleteSkillServlet extends HttpServlet {

    private SkillService skillService = new SkillService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        skillService.deleteSkill(id);
        resp.sendRedirect("/admin-page/skill");
    }
}

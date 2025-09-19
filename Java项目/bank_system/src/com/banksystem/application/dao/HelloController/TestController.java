package com.banksystem.application.dao.HelloController;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello_world")
public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String name = req.getParameter("name");
        System.out.println(name);
        resp.setContentType("text/html/; charset=UTF-8"); //浏览器不识别text/plain，所以加上charset=UTF-8
        resp.getWriter().println("Hello_world " + name + "!");
    }
}
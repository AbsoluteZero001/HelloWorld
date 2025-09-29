package com.banksystem.application.HelloController;

import java.io.BufferedReader;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());
        JSONObject jsonObject = JSONObject.parseObject(sb.toString(),JSONObject.class);
        String mobile = jsonObject.getString("mobile");
        String pwd = jsonObject.getString("pwd");
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("data", mobile);
        resp.getWriter().write(json.toJSONString());

    }
}

package com.zourongsheng.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet" ,value ="/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("before redirect");

//        response.sendRedirect("index.jsp");
        System.out.println("after redirect");
        response.sendRedirect("/2019211001001106ZouRongsheng_war_exploded/index.jsp");
    }
}

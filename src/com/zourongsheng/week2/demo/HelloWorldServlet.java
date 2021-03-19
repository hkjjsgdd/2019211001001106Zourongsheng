package com.zourongsheng.week2.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
       this.doPost(request,response);
   }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Date date = new Date();
        PrintWriter writer =response.getWriter();
        writer.println("Name: ZouRongsheng");
        writer.println("ID: 2019211001001106");
        writer.println("Date and Time:"+date);




    }


}

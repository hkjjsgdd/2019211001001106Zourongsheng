package com.zourongsheng.week3.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1 = request.getParameter("id");
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        String email1 = request.getParameter("email");
        String gender1 = request.getParameter("gender");
        String birthdate1 = request.getParameter("birthdate");

//        String sql = "insert into usertable(id,username,password,email,gender,birthdate) values(id1,username1,password1,email1,gender1,birthdate1)";
//        try {
//            ResultSet rs = con.createStatement().executeQuery(sql);
//
//            System.out.println("成功");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

package com.zourongsheng.week5.demo;

import com.zourongsheng.week4.demo.entity.User;
import sun.java2d.pipe.ValidatePipe;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet" , value="/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    public void init() {
//        String driver = getServletConfig().getServletContext().getInitParameter("driver");
//        String url = getServletConfig().getServletContext().getInitParameter("url");
//        String username = getServletConfig().getServletContext().getInitParameter("username");
//        String password = getServletConfig().getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println(con);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement ps=null;

        PrintWriter out = response.getWriter();
        ArrayList<User> list = new ArrayList<User>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String search = "select * from usertable where username = ? and password=?";
        try {
            ps=con.prepareStatement(search);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
//            while (rs.next()){
//                System.out.println(rs.getString("username"));
//                System.out.println(rs.getString("password"));
//            }
            User user=new User();
            if (rs.next()){
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
//
            if (user.getUsername()!= null && user.getPassword().equals(password)){
//                    out.println("Login Success!!!");
//                    out.println("Welcome," +username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

                }else {
//                    out.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

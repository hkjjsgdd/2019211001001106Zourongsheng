package com.zourongsheng.week4.demo;

import com.zourongsheng.week4.demo.entity.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//
//@WebServlet(
//        urlPatterns = {"/week4/register"}
//
//)
public class RegisterServlet04 extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException{
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
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
//        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthDate");
        User user =new User(username,password,email,gender,DateUitil.StrToUtil(birthdate));

        String sql = "insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
        String search = "select * from usertable";

        try {
            ps=con.prepareStatement(sql);

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getGender());
            ps.setDate(5,DateUitil.UtilToSql(user.getBirthdate()));
            ps.executeUpdate();
            System.out.println("插入成功");
//            ResultSet rs = con.createStatement().executeQuery(search);
//            System.out.println(rs);
//            System.out.println(rs.next());
//            ArrayList<User> list = new ArrayList<User>();
//            while (rs.next()){
//                User user1 =new User();
//                user1.setId(rs.getInt("id"));
//                user1.setUsername(rs.getString("username"));
//                user1.setPassword(rs.getString("password"));
//                user1.setEmail(rs.getString("email"));
//                user1.setGender(rs.getString("gender"));
//                user1.setBirthdate(DateUitil.StrToUtil(rs.getString("birthdate")));
//                list.add(user1);
//            }
//
//            System.out.println("查询成功");
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();



//            out.println("<HTML>");
//            out.println("<head><meta charset=utf-8></head>");
//            out.println("<Body>");
//            out.println("<table width='500' border='1' cellspacing='1' cellpadding='52' align='center'>");
//            out.println("<thead><tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birthdate</th></tr>");
//            for (User users : list) {
//                out.println("<tbody><tr><th>"+users.getId()+"</th><th>"+users.getUsername()+"</th><th>"+users.getPassword()+"</th><th>"+users.getEmail()+"</th><th>"+users.getGender()+"</th><th>"+DateUitil.utilToStr(user.getBirthdate())+"</th></tr></tbody>");
//            }
//            out.println("</table>");
//            out.println("</Body>");
//            out.println("</HTML>");
//            System.out.println(rs);
//            request.setAttribute("rname",rs);
//            request.getRequestDispatcher("userList.jsp").forward(request,response);
//            System.out.println("I am in Registerjsp");
            System.out.println("================");
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

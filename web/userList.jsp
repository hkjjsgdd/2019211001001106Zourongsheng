<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/10
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.zourongsheng.week4.demo.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zourongsheng.week4.demo.DateUitil" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>id</td><td>username</td><td>password</td><td>email</td><td>gender</td><td>birthdate</td>
    </tr>
    <%
      ResultSet rs= (ResultSet) request.getAttribute("rname");
        ArrayList<User> list = new ArrayList<User>();

      if (rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else
        {
//            System.out.println(rs.next());
            while (rs.next()){
//                System.out.println("进入了循环");
                User user1 =new User();
                user1.setId(rs.getInt("id"));
                user1.setUsername(rs.getString("username"));
                user1.setPassword(rs.getString("password"));
                user1.setEmail(rs.getString("email"));
                user1.setGender(rs.getString("gender"));
                user1.setBirthdate(DateUitil.StrToUtil(rs.getString("birthdate")));
                list.add(user1);
        }
            for (User users : list) {
                out.println("<tr><th>"+users.getId()+"</th><th>"+users.getUsername()+"</th><th>"+users.getPassword()+"</th><th>"+users.getEmail()+"</th><th>"+users.getGender()+"</th><th>"+ DateUitil.utilToStr(users.getBirthdate())+"</th></tr>");
            }

        }

    %>
</table>
<%@include file="footer.jsp"%>
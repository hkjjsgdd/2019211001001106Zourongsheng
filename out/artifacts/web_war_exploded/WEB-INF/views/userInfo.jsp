<%@ page import="com.zourongsheng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/11
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--<%--%>
<%--    Cookie [] allCookies = request.getCookies();--%>
<%--    for(Cookie c:allCookies){--%>
<%--        out.println("<br/>"+c.getName()+"==="+c.getValue());--%>
<%--    }--%>
<%--%>--%>
<%
    User u1 =(User)session.getAttribute("user");
    System.out.println(u1);
%>
<table>
    <tr><td>ID:<%=u1.getId()%></td></tr>
    <tr><td>Username:</td><td><%=u1.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u1.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u1.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u1.getGender()%></td></tr>
    <tr><td>Birth Date:</td><td><%=u1.getBirthdate()%></td></tr>

</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>

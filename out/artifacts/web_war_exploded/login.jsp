<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/2
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="login">
    UserName:<input type="text" name="username"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" class="button" value="Login">
</form>
<%@include file="footer.jsp"%>

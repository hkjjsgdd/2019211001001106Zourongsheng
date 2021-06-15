
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
    <jsp:useBean id="user" scope="request" class="com.zourongsheng.lab2.Login"/>
    <jsp:setProperty name="user" property="*"/>
<%
    if (user.getUsername().equals("admin") && user.getPassword().equals("admin"))
    {
%>
    <jsp:forward page="welcome.jsp"/>
<%
    }else {
%>
<%
    out.println("Your Username or Password error");
%>
    <jsp:include page="login.jsp"/>
<%
    }
%>
</body>
</html>
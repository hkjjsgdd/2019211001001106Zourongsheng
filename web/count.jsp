<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/2
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
    This is Count JSP page .<br>
<%--    <%!int count=0; %>--%>
<%--    this Page has access : <%out.println(++count);%>--%>
    <%!int getCount(){
       return ++count;
    } %>
    <%! int count=0; %>
    The page count is now (using count()): <%out.println(getCount());%>
</body>
</html>

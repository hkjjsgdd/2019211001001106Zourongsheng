<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/31
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
//java code here
    public void jspInit(){
        System.out.println("I am in jspinit()");
    }

%>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
</html>
<%!
public void jspDestroy(){
    System.out.println("I am in jspDestroy");
}

%>


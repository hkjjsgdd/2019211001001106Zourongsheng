<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/13
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="http://www.ecjtu.jx.cn/">go to ecjtu</a>
<form method="post" action="hello">
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    Date and Time:<%=new Date()%><br/>
    <input type="submit" value="Send data to server--ZouRongsheng">
</form>

</body>
</html>

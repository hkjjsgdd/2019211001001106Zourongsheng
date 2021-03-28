<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/19
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>

</head>
<body>
<form method="post" action="register">
    id:<input type="text" name="id" placeholder="id"><br/>
    Name:<input type="text" name="username" placeholder="username"><br/>
    Password:<input type="text" name="password" placeholder="password"><br/>
    Email:<input type="text" name="email" placeholder="email"><br/>
    gender:<input type="text" name="gender" placeholder="gender"><br/>
    Birthdate:<input type="text" name="birthDate" placeholder="Date of Birth(yyyy-dd-mm format)"><br/>
    <input type="submit" class="button" value="register">
</form>
</body>
</html>


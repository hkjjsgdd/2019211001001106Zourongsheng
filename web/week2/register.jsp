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
    <style type="text/css">
        .button {
            background-color: orange;
        }
    </style>
    <script>

        /*验证邮箱*/
        function checkEmail(){
            var email=$("email");
            var email_prompt=divId("email_prompt");
            email_prompt.innerHTML="";
            var reg=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
            if(reg.test(email)==false){
                email_prompt.innerHTML="Email格式不正确，例如web@163.com";
                return false;
            }
            return true;
        }
        /*密码验证*/
        function checkPwd(){
            var pwd=$("pwd");
            var pwdId=divId("pwd_prompt");
            pwdId.innerHTML="";
            var reg=/^[a-zA-Z0-9]{8,10}$/;
            if(reg.test(pwd)==false){
                pwdId.innerHTML="密码不能含有非法字符，长度在8-10之间";
                return false;
            }
            return true;
        }


    </script>
</head>
<body>
<form method="post">
    Name:<input type="text" name="username" placeholder="username"><br/>
    Password:<input type="text" name="password" placeholder="password" οnblur="checkPwd()"><br/>
    Email:<input type="text" name="email" placeholder="email" οnblur="checkEmail()"><br/>
    Birthdate:<input type="date" placeholder="Date of Birth(yyyy-dd-mm format)"><br/>
    <input type="submit" class="button" value="register">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: �϶�
  Date: 2021/6/13
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cal</title>
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/CalServlet" method="post">
    First val: <input id="one" type="text" name="firstVal" value="${cookie.cFirstValue.value}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Enter a name :<input id="name" type="text" name="name" value="${cookie.cName.value}"><br>
    Second val :<input id="two" type="text" name="secondVal" value="${cookie.cSecondValue.value}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Length :<input id="length" type="text" readonly value="${cookie.cLength.value}"><br>
    Result :<input id="res" type="text" readonly value="${cookie.cResult.value}"><br>
    <input id="hidden" type="hidden" name="action" value="">
    <button id="add" type="button">Add</button>&nbsp;
    <button id="subtract" type="button">Subtract</button>&nbsp;
    <button id="multiply" type="button">Multiply</button>&nbsp;
    <button id="divide" type="button">Divide</button>&nbsp;
    <button id="computeLength" type="button">Compute Length</button>&nbsp;
    <br>
    <button id="reset" type="button">Reset</button>
</form>
<script src="../js/jquery.js"></script>
<script>

    function checkNum() {
        var text = /^[0-9]+.?[0-9]*$/;
        if (!text.test($('#one').val())){
            alert("First val is not a number");
            return false;
        }
        if (!text.test($('#two').val())){
            alert("Second val is not a number");
            return false;
        }
        return true;
    }

    function checkString() {
        var text=/\d/;
        if (text.test($('#name').val())){
            alert("Name is not valid");
            return false;
        }
        return true;
    }


    $('#add').click(function () {
        $("#hidden").attr("value","add");
        if(checkNum()){
            $('#form').submit();
        }
    })
    $('#subtract').click(function () {
        $('#hidden').attr("value","subtract");
        if(checkNum()){
            $('#form').submit();
        }
    })
    $('#multiply').click(function () {
        $('#hidden').attr("value","multiply");
        if(checkNum()){
            $('#form').submit();
        }
    })
    $('#divide').click(function () {
        $('#hidden').attr("value","divide");
        if(checkNum()){
            $('#form').submit();
        }
    })
    $('#computeLength').click(function () {
        $('#hidden').attr("value","computeLength");
        if(checkString()){
            $('#form').submit();
        }
    })

        
    $('#reset').click(function () {
        $('#one').attr("value","");
        $('#two').attr("value","");
        $('#name').attr("value","");
        $('#length').attr("value","");
        $('#res').attr("value","");
        $('#hidden').attr("value","");
    })

    



</script>
</body>
</html>

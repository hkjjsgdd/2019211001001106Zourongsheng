<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1><%="Hello World!!"%></h1>
<%--<a href="hello-servlet">Hello Servlet-week1</a>--%>
<%--</br>--%>
<%--<a href="week2/register.jsp">Student Info Servlet-week2</a>--%>
<%--</br>--%>
<%--<a href="week3/register.jsp">Life Cycle Servlet-week3</a>--%>
<%--</br>--%>
<%--<a href="index.jsp">include-week5</a>--%>
<%--</br>--%>
<%--<a href="login.jsp">login-week5</a>--%>
<%--</br>--%>
<h2>Welcome to My Online Shop Home Page.</h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>

<%@include file="footer.jsp"%>
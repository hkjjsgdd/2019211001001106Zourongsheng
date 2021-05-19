<%@ page import="com.zourongsheng.week11.demo.Dog" %>
<%@ page import="com.zourongsheng.week11.demo.Person" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/5/16
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        com.zourongsheng.week11.demo.Dog dog=new Dog();
        dog.setName("Tommy");
        Person person = new Person();
        person.setName("Evan");
        person.setDog(dog);

        pageContext.setAttribute("person",person);

    %>
<h1>Get Person's Dog name Using java code</h1>
<%
    Person p = (Person) request.getAttribute("person");
    Dog d = person.getDog();
    out.println(d.getName());
%>
<h1>Get Person'Dog name Using EL code</h1>
${person.dog.name}
</body>
</html>

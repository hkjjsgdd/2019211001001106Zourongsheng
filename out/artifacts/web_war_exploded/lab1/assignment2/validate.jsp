<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>


<%--todo 2: use c:choose ,c:when c:otherwise to validate username is 'admin' and  password is 'admin'--%>
<c:choose>
    <c:when test="${param.username.equals('admin')}">
        <%--todo 3: when username == admin use c:url and c:param to make url = "welcome.jsp?username=admin"--%>
         <c:url var="url" value="welcome.jsp">
            <c:param name="username" value="admin"/>
         </c:url>
        <%-- todo 4.use c:redirect to url= welcome.jsp?username=admin--%>
        <c:redirect url="${url}"/>
    </c:when>
    <%-- todo 5. use c:otherwise --%>
<c:otherwise>
    <%-- todo 6:use c:set to set a attribute name message="username password error" in request  --%>
    <c:set var="message" value="Username Password Error" scope="request"/>
    <%--todo 7:use c:import to include login.jsp --%>
    <c:import url="login.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>

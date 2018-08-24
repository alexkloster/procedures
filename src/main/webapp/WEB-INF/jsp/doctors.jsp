<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 24.08.2018
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor managemet</title>
</head>
<body>
<h1>Doctors</h1>
<table>
    <c:forEach items="${doctors}" var="doctor">
        <tr>
            <td>${doctor.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

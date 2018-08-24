<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexk
  Date: 24.08.2018
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Static content -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/js/app.js"></script>
    <title>Procedures scheduling</title>
</head>
<body>
<hr>
<div>
    <table>
        <tr>
            <td>
                <select name="doctors" title="Select doctor">
                    <c:forEach items="${doctors}" var="doctor">
                        <option value="${doctor.id}">${doctor.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="button" value="Add doctor" onclick="addDoctorField();">
            </td>
        </tr>
    </table>
</div>
<br>
<div id="addDoctor" style="visibility: hidden">
    <form action="/add/doctor" method="post" onsubmit="return validate()">
        <table>
            <tr>
                <td>Doctor name:</td>
                <td><input id="newDoctorName" name="name"></td>
                <td><input type="submit" value="Add doctor" onclick="addDoctor()"></td>
            </tr>
        </table>
    </form>

</div>




</body>
</html>

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
    <title>Procedures scheduling</title>
</head>
<body>
<h1>Spring Boot - MVC web application example</h1>
<hr>
<div>
    <select name="doctors" title="Select doctor">
        <c:forEach items="${doctors}" var="doctor">
            <option value="${doctor.id}">${doctor.name}</option>
        </c:forEach>
    </select>
    <form action="/manage/doctors" method="post">
        <input type="button" value="Add doctor">
    </form>
</div>

<script type="text/javascript">
    function addDoctorField() {

        var element = document.createElement("input");
        element.setAttribute("type", "text");
        element.setAttribute("name", "mytext");
        var spanvar = document.getElementById("myspan");
        spanvar .appendChild(element);
    }
</SCRIPT>

<div id="certificationtog">
    <p class="setting">
        <input type="button" id="addrows" name="addrows" class="addperson"
               value="Add Rows" onclick="add();">
        <input type="button" id="removerows" class="removerows"
               value="Delete Rows" />
        <span id="myspan"></span>
        <br><br>
        <span style="width: 0px; margin-left: 20px; font-weight: bold; float: none;">
      </span>
    </p>
</div>

</body>
</html>

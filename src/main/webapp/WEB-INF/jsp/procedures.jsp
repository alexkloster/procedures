<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexanderkloster
  Date: 26.08.2018
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Static content -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/app.js"></script>
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
    <title>Procedures</title>
</head>
<body>
<div id="content">
    <h1>Procedure scheduling application</h1>
    <h3>Existing procedures</h3>
    <table class="table table-hover" id="studiesTable">
        <thead class="thead-light">
        <tr>
            <td>Description</td>
            <td>Status</td>
            <td>Planned start time</td>
            <td>Estimated end time</td>
            <td>Doctor</td>
            <td>Patient</td>
            <td>Room</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${studies}" var="study">
            <tr id="${study.id}" onclick=onClickRow(this.id)>
                <td>${study.description}</td>
                <td>${study.status}</td>
                <td>${study.plannedStartTime}</td>
                <td>${study.estimatedEndTime}</td>
                <td>${study.doctor.name}</td>
                <td>${study.patient.name}</td>
                <td>${study.room.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

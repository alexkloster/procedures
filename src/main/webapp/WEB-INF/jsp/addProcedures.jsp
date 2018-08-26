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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/app.js"></script>
    <title>Procedures scheduling</title>
</head>
<body>
<hr>
<h3>Select date of procedure</h3>
<br>
<div>
    <table>
        <tr>
            <td>Day:</td>
            <td width="20"></td>
            <td>Start time:</td>
            <td width="20"></td>
            <td>Estimated end time:</td>
        </tr>
        <tr>
            <td>
                <input type = "date" id = "procedureDay">
            </td>
            <td></td>
            <td>
                <input type = "time" id = "procedureStartTime">
            </td>
            <td></td>
            <td>
                <input type = "time" id = "procedureEndTime">
            </td>
            <td width="20"></td>
            <td><input type="button" value = "Check availability" onclick="checkAvailability()"></td>
        </tr>

    </table>
</div>
<br>
<h3>Select doctor, patient and room for procedure</h3>
<br>
<div>
    <table>
        <tr>
            <td>
                <label>Doctors:</label>
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <label>Patients:</label>
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <label>Rooms:</label>
            </td>
        </tr>
        <tr>
            <td>
                <select id="docList" name = "doctors" title="Select doctor">
                    <c:forEach items="${doctors}" var="doctor">
                        <option value="${doctor.id}">${doctor.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20"></td>
            <td>
                <input type="button" value="Add doctor" onclick="addDoctorDiv();">
            </td>
            <td width="20"></td>
            <td>
                <select id="patientList" name = "patients">
                    <c:forEach items="${patients}" var="patient">
                        <option value="${patient.id}">${patient.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20"></td>
            <td>
                <input type="button" value="Add patient" onclick="addPatientDiv();">
            </td>
            <td width="20"></td>
            <td>
                <select id="roomList" name = "rooms">
                    <c:forEach items="${rooms}" var="room">
                        <option value="${room.id}">${room.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td width="20"></td>
            <td>
                <input type="button" value="Add room" onclick="addRoomDiv();">
            </td>
        </tr>
    </table>
</div>
<br>
<div id="addDoctor" style="visibility: hidden">
        <table>
            <tr>
                <td>Doctor name:</td>
            </tr>
            <tr>
                <td><input id="newDoctorName" name="name"></td>
                <td width="20"></td>
                <td><input type="button" value="Add doctor"></td>
            </tr>
        </table>
</div>

<div id="addPatient" style="visibility: hidden">
    <table>
        <tr>
            <td>Patient name:</td>
            <td width="20"></td>
            <td>Sex:</td>
            <td width="20"></td>
            <td>Date of birth:</td>
        </tr>
        <tr>
            <td><input type="text" id="newPatientName" name="name"></td>
            <td width="20"></td>
            <td>
                <select id="sexList" name="sex">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </td>
            <td width="20"></td>
            <td><input type="date" id="newPatientBirth" name="birthDate"></td>
            <td width="20"></td>
            <td><input type="button" value="Add patient"></td>
        </tr>
    </table>
</div>

<div id="addRoom" style="visibility: hidden">
    <table>
        <tr>
            <td>Room name:</td>
        </tr>
        <tr>
            <td><input id="newRoomName" name="name"></td>
            <td width="20"></td>
            <td><input type="button" value="Add room"></td>
        </tr>
    </table>
</div>




</body>
</html>

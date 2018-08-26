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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <title>Procedures scheduling</title>
</head>
<body>
<div id="content">
    <div id="procedureDescription">
        <h3>Enter procedure description</h3>
        <br>
        <label>Description:</label>
        <input type="text" id="procedureDescriptionText">
    </div>
    <br>
    <hr>
    <br>
    <div id="procedureDate">
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
                        <input type="date" class="form-control" id="procedureDay">
                    </td>
                    <td></td>
                    <td>
                        <input type="time" class="form-control" id="procedureStartTime">
                    </td>
                    <td></td>
                    <td>
                        <input type="time" class="form-control" id="procedureEndTime">
                    </td>
                    <td width="20"></td>
                    <td><input type="button" class="btn btn-secondary" value="Check availability" onclick="checkAvailability()"></td>
                </tr>

            </table>
        </div>
    </div>
    <br>
    <hr>
    <br>
    <div id="roomDoctorPatient">
        <h3>Select doctor, patient and room for procedure</h3>
        <br>
        <hr>
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
                        <select class="form-control" id="docList" name="doctors" title="Select doctor">
                            <c:forEach items="${doctors}" var="doctor">
                                <option value="${doctor.id}">${doctor.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="20"></td>
                    <td>
                        <input type="button" class="btn btn-secondary" value="Add doctor" onclick="addDoctorDiv();">
                    </td>
                    <td width="20"></td>
                    <td>
                        <select class="form-control" id="patientList" name="patients">
                            <c:forEach items="${patients}" var="patient">
                                <option value="${patient.id}">${patient.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="20"></td>
                    <td>
                        <input type="button" class="btn btn-secondary" value="Add patient" onclick="addPatientDiv();">
                    </td>
                    <td width="20"></td>
                    <td>
                        <select class="form-control" id="roomList" name="rooms">
                            <c:forEach items="${rooms}" var="room">
                                <option value="${room.id}">${room.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="20"></td>
                    <td>
                        <input type="button" class="btn btn-secondary" value="Add room" onclick="addRoomDiv();">
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <div id="addDoctor" style="display: none;">
            <table>
                <tr>
                    <td>Doctor name:</td>
                </tr>
                <tr>
                    <td><input class="form-control" id="newDoctorName" name="name"></td>
                    <td width="20"></td>
                    <td><input type="button" class="btn btn-secondary" value="Add doctor" onclick="addDoc()"></td>
                </tr>
            </table>
        </div>

        <div id="addPatient" style="display: none;">
            <table>
                <tr>
                    <td>Patient name:</td>
                    <td width="20"></td>
                    <td>Sex:</td>
                    <td width="20"></td>
                    <td>Date of birth:</td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" id="newPatientName" name="name"></td>
                    <td width="20"></td>
                    <td>
                        <select id="sexList" name="sex">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </td>
                    <td width="20"></td>
                    <td><input type="date" class="form-control" id="newPatientBirth" name="birthDate"></td>
                    <td width="20"></td>
                    <td><input type="button" class="btn btn-secondary" value="Add patient"></td>
                </tr>
            </table>
        </div>

        <div id="addRoom" style="display: none;">
            <table>
                <tr>
                    <td>Room name:</td>
                </tr>
                <tr>
                    <td><input class="form-control" id="newRoomName" name="name"></td>
                    <td width="20"></td>
                    <td><input type="button" class="btn btn-secondary" value="Add room"></td>
                </tr>
            </table>
        </div>
        <br>
        <hr>
        <br>
    </div>
    <br>
    <div>
        <button class="btn btn-primary float-left">Back to procedures</button>
        <button class="btn btn-primary float-right"  onclick=saveProcedure()>Save procedure</button>
    </div>
</div>
</body>

</html>

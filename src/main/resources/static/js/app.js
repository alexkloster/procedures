function validate() {
    var name = document.getElementById("name").value;
    if (name == '') {
        alert('Please enter a valid name.');
        return false;
    } else {
        return true;
    }
}

function checkAvailability() {
    var date = document.getElementById("procedureDay");
    var startTime = document.getElementById("procedureStartTime");
    var endTime = document.getElementById("procedureEndTime");

}

function addDoctorDiv() {
    var doctor = document.getElementById("addDoctor");
    doctor.style.display = 'inline';
}

function addPatientDiv() {
    var doctor = document.getElementById("addPatient");
    doctor.style.display = 'inline';
}

function addRoomDiv() {
    var doctor = document.getElementById("addRoom");
    doctor.style.display = 'inline';
}

function hideDoctorField() {
    alert("Doctor added");

}


function addDoc() {
    var doctor = {};
    doctor.name = document.getElementById("newDoctorName").value;
    var doctorsArr = [];
    $('#docList').find('option').each(function () {
        doctorsArr.push(this.text)
    });
    if (doctorsArr.indexOf(doctor.name) >= 1) {
        alert("This doctor is already exist!")
    } else {
        $.ajax({
            url: "/add/doctor",
            type: "POST",
            data: JSON.stringify(doctor),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        });
        var doctorDiv = document.getElementById("addDoctor");
        doctorDiv.style.display = 'none';
    }
}

function addRoom() {
    var room = {};
    room.name = document.getElementById("newRoomName").value;
    var roomsArr = [];
    $('#roomList').find('option').each(function () {
        roomsArr.push(this.text)
    });
    if (roomsArr.indexOf(room.name) >= 1) {
        alert("This room is already exist!")
    } else {
        $.ajax({
            url: "/add/room",
            type: "POST",
            data: JSON.stringify(room),
            dataType: "json",
            contentType: "application/json; charset=utf-8"
        });
        var roomDiv = document.getElementById("addRoom");
        roomDiv.style.display = 'none';
    }
}

function saveProcedure() {
    var doctor = {};
    var selectedDoctor = $("#docList").find(":selected");
    doctor.name = selectedDoctor.text();
    doctor.id = selectedDoctor.val();

    var patient = {};
    var selectedPatient = $("#patientList").find(":selected");
    patient.name = selectedPatient.text();
    patient.id = selectedPatient.val();

    var room = {};
    var selectedRoom = $("#roomList").find(":selected");
    room.name = selectedRoom.text();
    room.id = selectedRoom.val();

    var date = new Date($('#procedureDay').val());
    var day = ('0' + date.getDate()).slice(-2);
    var month = ('0' + (date.getMonth() + 1)).slice(-2);
    var year = date.getFullYear();

    var startTime = $("#procedureStartTime").val();
    var endTime = $("#procedureEndTime").val();

    var study = {};
    study.doctor = doctor;
    study.patient = patient;
    study.room = room;
    study.description = $("#procedureDescriptionText").val();
    study.plannedStartTime = [year, month, day].join('-') + " " + startTime + ":00";
    study.estimatedEndTime = [year, month, day].join('-') + " " + endTime + ":00";

    $.ajax({
        url: "/save/procedure",
        type: "POST",
        data: JSON.stringify(study),
        dataType: "json",
        contentType: "application/json; charset=utf-8"
    });

}

function createDateTime(date, time) {
    return date + ":" + time;
}

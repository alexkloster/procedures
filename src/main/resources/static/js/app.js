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
    doctor.style.visibility = 'visible';
}

function addPatientDiv() {
    var doctor = document.getElementById("addPatient");
    doctor.style.visibility = 'visible';
}

function addRoomDiv() {
    var doctor = document.getElementById("addRoom");
    doctor.style.visibility = 'visible';
}

function hideDoctorField() {
    alert("Doctor added");

}


function addDoc() {
    var doctor = {};
    doctor.name = document.getElementById("newDoctorName").value;
    var doctorsArr = [];
    $('#docList').find('option').each(function(){doctorsArr.push(this.text)});
    if(doctorsArr.indexOf(doctor.name) >=1) {
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
        doctorDiv.style.visibility = 'hidden';
    }
}

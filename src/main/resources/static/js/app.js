function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function addDoctorField() {
    var doctor = document.getElementById("addDoctor");
    doctor.style.visibility = 'visible';
}

function hideDoctorField() {
    alert("Doctor added");

}

function addDoctor() {
    var doctor = {};
    doctor.name = document.getElementById("newDoctorName").value;
    $.ajax({
        url: "/add/doctor",
        type: "POST",
        data: JSON.stringify(doctor),
        dataType: "json"
    });
    var doctor = document.getElementById("addDoctor");
    doctor.style.visibility = 'hide';
}


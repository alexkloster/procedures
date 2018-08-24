function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function add() {
    var element = document.createElement("input");
    element.setAttribute("type", "text");
    element.setAttribute("name", "mytext");
    var spanvar = document.getElementById("myspan");
    spanvar.appendChild(element);
}
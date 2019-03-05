function confirmDelete() {
	var x = confirm("Are you sure you want to delete?");
	if (x)
		return true;
	else
		return false;
}

$('#activerId').click(function() {
	alert("Call Check action ");
//	if ($("#isAgeSelected").is(':checked'))
//		alert("Check");
//	else {
//		alert("Un Check");
//	}
});

$("div").click(function(){
    alert("The paragraph was clicked.");
});
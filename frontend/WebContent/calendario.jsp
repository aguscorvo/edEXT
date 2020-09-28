<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function(){
	var fechaA= new Date();
	var yyyy= fechaA.getFullYear();

	$("#fechaNacimiento2").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '1910:' + yyyy,
		dateFormat: "dd-mm-yy"
		
	});
});

</script>

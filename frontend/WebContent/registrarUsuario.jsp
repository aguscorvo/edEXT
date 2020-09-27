<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>Registro de usuario</title>
</head>
<body>
<form action="RegistrarUsuario" method="post">
  <div class="form-group">
    <input type="text" name= "nick" class="form-control" placeholder="Nick" required>
  </div>
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required>
  </div>
  <div class="form-group">
    <input type="text" name= "npellido" class="form-control" placeholder="Apellido" required>
  </div>
  <div class="form-group">
    <input type="email" name= "correo" class="form-control" id="exampleInputEmail1" placeholder="Correo electrónico" required>
  </div>
  <div class="form-group">
    <input type="password" name= "pass1" class="form-control" id="exampleInputPassword1" placeholder="Ingresar contraseña" required>
  </div>
  <div class="form-group">
    <input type="password" name= "pass2" class="form-control" id="exampleInputPassword2" placeholder="Confirmar contraseña" required>
  </div>
    <!--fecha-->
  <label for="fechaNacimiento">Fecha de nacimiento:</label>
  <input type="date" id="fechaNacimiento" name="fechaNacimiento">
  
  <!-- segunda opcion Fecha  -->
  
  <div class="form-group">
  <label>Fecha de nacimiento</label>
  <input type="text" id="fechaNacimiento2" class="form-control" readonly="">
 </div>
    
      <!-- RadioButton-->
 <div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="estudiante" id="option1" checked>Estudiante
  </label>
  <label class="btn btn-secondary">
    <input type="radio" name="docente" id="option2">Docente
  </label>
</div>

<div class="form-group">
    <input type="text" name= "instituto" class="form-control" placeholder="Instituto" >
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button> 
  
  
  
</form>


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




</body>
</html>
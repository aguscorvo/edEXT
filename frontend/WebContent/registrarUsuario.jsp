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
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Registro de usuario</title>
</head>
<body>
<form action="RegistrarUsuario" method="post" id="formulario">
  <div class="form-group">
    <input type="text" name= "nick" class="form-control" placeholder="Nick" required >
  </div>
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <div class="form-group">
    <input type="text" name= "apellido" class="form-control" placeholder="Apellido" required>
  </div>
  <div class="form-group">
    <input type="email" name= "email" class="form-control" id="exampleInputEmail1" placeholder="Correo electrónico" required>
  </div>
  <div class="form-group">
    <input type="password" name= "pass1" class="form-control" id="exampleInputPassword1" placeholder="Ingresar contraseña" required>
  </div>
  <div class="form-group">
    <input type="password" name= "pass2" class="form-control" id="exampleInputPassword2" placeholder="Confirmar contraseña" required>
  </div>
   
  <!-- segunda opcion Fecha  -->    
  <div class="form-group">
  <div style="max-width:400px;margin:auto"> 
        <div class="input-icons"> 
			<i class="fa fa-calendar"></i>	
  			<input class="form-control" type="text" name=fechaNacimiento2 id="fechaNacimiento2" placeholder="Fecha de Nacimiento" required>
        </div> 
  </div> 
  </div>
 
      <!-- RadioButton-->
 <div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoUsuario" id="estudiante" value= "estudiante">Estudiante
  </label>
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoUsuario" id="docente" value = "docente">Docente
  </label>
</div>
  <div id = "log" ></div>


<div class="form-group">
    <input type="text" name= "instituto" class="form-control" placeholder="Si es docente ingresar instituto">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button> 
  
   
</form>


<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>
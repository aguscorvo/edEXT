<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
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
    <!-- falta fecha-->
    
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


</body>
</html>
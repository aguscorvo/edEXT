<%@page import="publicadores.ControladorAltaUsuarioPublish" %>
<%@page import="publicadores.ControladorAltaUsuarioPublishService" %>
<%@page import="publicadores.ControladorAltaUsuarioPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%

ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();

String [] institutos= port.getInstitutos();

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>


<title>Registro de usuario</title>
</head>
<body>

<div class="row">
<div class="col-sm-2 mx-auto">
<form action="RegistrarUsuario" method="post" id="formulario">
  
  <h6 style="color:white";>&nbsp Datos básicos:</h6>
  <div class="form-group">
    <input type="text" name= "nick" id="nick" class="form-control" placeholder="Nick" required >
  </div><p id="nickServletResponse" style="color:grey"></p>  
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <div class="form-group">
    <input type="text" name= "apellido" class="form-control" placeholder="Apellido" required>
  </div>
  <div class="form-group">
    <input type="email" name= "email" class="form-control" id="email" placeholder="Correo electrónico" required>
  </div><div id="emailServletResponse" style="color:grey"></div>
  <div class="form-group">
    <input type="password" name= "pass1" class="form-control" id="pass1" placeholder="Ingresar contraseña" required>
  </div>
  <div class="form-group">
    <input type="password" name= "pass2" class="form-control" id="pass2" placeholder="Confirmar contraseña" required>
  </div> <p id="passwordServletResponse" style="color:grey"></p>
  
   
  <!-- segunda opcion Fecha  -->    
  <div class="form-group">
  <div style="max-width:400px;margin:auto"> 
        <div class="input-icons"> 
			<i class="fa fa-calendar"></i>	
  			<input class="form-control" type="text" name=fechaNacimiento2 id="fechaNacimiento2" placeholder=" Fecha de Nacimiento" required>
        </div> 
  </div> 
  </div>
  
  <br>
  <h6 style="color:white";>&nbsp Tipo de usario:</h6>
  
    <!-- RadioButton-->
<div class="form-group">   
 <div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoUsuario" id="estudiante" value= "estudiante">Estudiante
  </label>
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoUsuario" id="docente" value = "docente" checked>Docente
  </label>
</div>
  <div id = "log" ></div>
</div>

<div class="form-group">
   <select name="instituto" class="custom-select" id="instituto" required>
	  <option selected disabled value="">Seleccione instituto</option>
	  
		  <%int i=0;
		  while (i<institutos.length){%>
			  <option value="<%=institutos[i]%>"><%=institutos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  <br>
  <button type="submit" class="btn btn-dark">Confirmar</button> 
  
<script>  
  
  // Accedemos al botón
var inst = document.getElementById('instituto');

// evento para el input radio del "si"
document.getElementById('docente').addEventListener('click', function(e) {
  inst.disabled = false;
});

// evento para el input radio del "no"
document.getElementById('estudiante').addEventListener('click', function(e) {
  inst.disabled = true;
});

</script>



</form>
</div>
</div>

<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>
<script src="js/registrarUsuario.js"></script>






</body>
</html>
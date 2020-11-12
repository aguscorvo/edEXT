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


<title>Modificar datos de usuario</title>
</head>
<body>


<%
//Consigo datos del usuario logueado
HttpSession s = request.getSession();
String nick = (String) s.getAttribute("nick");
String nombre = (String) s.getAttribute("nombre");
String apellido = (String) s.getAttribute("apellido");
String password = (String) s.getAttribute("password");

%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="ModificarDatosUsuario" method="post" id="formulario">
 
 <div class="form-group">
    <input type="hidden" name= "nick" class="form-control" placeholder="Nick" value="<%=nick%>">
  </div>
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" value="<%=nombre%>" required>
  </div>
  <div class="form-group">
    <input type="text" name= "apellido" class="form-control" placeholder="Apellido" value="<%=apellido%>" required>
  </div>
  <div class="form-group">
    <input type="password" name= "password" class="form-control" id="exampleInputPassword1" placeholder="Ingresar contraseña" value="<%=password%>" required>
  </div> 
   
  <div class="form-group">
  <div style="max-width:400px;margin:auto"> 
        <div class="input-icons"> 
			<i class="fa fa-calendar"></i>	
  			<input class="form-control" type="text" name=fechaNacimiento2 id="fechaNacimiento2" placeholder="Fecha de Nacimiento" required>
        </div> 
  </div> 
  </div>
  
  <button type="submit" class="btn btn-dark">Guardar cambios</button>  


</form>

</div>
</div>

<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>
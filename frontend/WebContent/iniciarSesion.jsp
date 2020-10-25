<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Iniciar sesión</title>

</head>
<body>
<form action="IniciarSesion" method="post">
  
<div class="row">
<div class="col-sm-2 mx-auto">
  <div class="form-group">
    <input type="text" name="nickOEmail" class="form-control" id="exampleInputEmail1" placeholder="Nick o correo electrónico" >
  </div>
  
  <div class="form-group">
    <input  type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" >
  </div> 
  
  <br>
  
  	<button type="submit" class="btn btn-dark">Enviar</button>
</div>
</div>
  
</form>


<%@include file="/footer.jsp"%>

</body>
</html>


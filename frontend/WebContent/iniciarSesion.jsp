<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<title>Iniciar sesión</title>
<style>
	body{
		background-color: #364853;
	}
	
	.form-group{
		width: 250px;
		margin: 10px 0px 10px 10px;
		align: center;	
	}
	.btn-dark{
		margin-left: 10px;		
	}
</style>
</head>
<body>
<form>
  
  <div class="form-group">
    <input type="email" name="nickOEmail" class="form-control" id="exampleInputEmail1" placeholder="Nick o correo electrónico" required>
  </div>
  <div class="form-group">
    <input  type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
  </div> 
  	<button type="submit" class="btn btn-dark">Enviar</button>
  
</form>

</body>
</html>


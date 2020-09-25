<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<title>Iniciar sesión</title>
</head>
<body style="background-color: #364853">
<form>
  <div class="form-group">
    <input type="email" name="nickOEmail" class="form-control" id="exampleInputEmail1" placeholder="Nick o correo electrónico">
  </div>
  <div class="form-group">
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>    
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>

</body>
</html>


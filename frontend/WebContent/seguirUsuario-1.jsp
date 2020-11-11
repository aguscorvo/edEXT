<%@page import="publicadores.ControladorSeguirUsuariosPublish" %>
<%@page import="publicadores.ControladorSeguirUsuariosPublishService" %>
<%@page import="publicadores.ControladorSeguirUsuariosPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%

ControladorSeguirUsuariosPublishService cps = new ControladorSeguirUsuariosPublishServiceLocator();
ControladorSeguirUsuariosPublish port = cps.getControladorSeguirUsuariosPublishPort();

String usuario = (String) session.getAttribute("nick");

String [] noSeguidos= port.getUsuariosNoSeguidos(usuario);

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Seguir usuario</title>
</head>
<body>

<br>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="SeguirUsuario" method="post" id="formulario">
  
   
<div class="form-group">
   <select name="usuario" class="custom-select" id="usuario" required>
	  <option selected disabled value="">Seleccione usuario</option>
	  
		  <%int i=0;
		  while (i<noSeguidos.length){%>
			  <option value="<%=noSeguidos[i]%>"><%=noSeguidos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  
  <br>
  
  <button type="submit" class="btn btn-dark">Seguir usuario</button> 
  

</form>

</div>
</div>


<%@include file="/footer.jsp"%>

</body>
</html>
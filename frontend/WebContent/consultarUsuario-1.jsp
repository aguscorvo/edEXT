<%@page import="publicadores.ControladorConsultaUsuarioPublishService" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublish" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">

<title>Consulta de usuario</title>
</head>

<body>

<%
ControladorConsultaUsuarioPublishService cps = new ControladorConsultaUsuarioPublishServiceLocator();
ControladorConsultaUsuarioPublish port = cps.getControladorConsultaUsuarioPublishPort();

String [] arrUsuarios = port.getUsuarios();
%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="consultarUsuario-2.jsp" method="post" id="form1">  
   
	<div class="form-group">
	   <select name="usuario" class="custom-select" id="usuario" required>
		  <option selected disabled value="">Seleccione usuario</option>
		  
			  <%int i=0;
			  while (i<arrUsuarios.length){%>
				  <option value="<%=arrUsuarios[i]%>"><%=arrUsuarios[i]%></option>
				 <% i++;
			  } %>	
		    
	  </select>
	</div>
	  
	 <button type="submit" class="btn btn-dark">Obtener información del usuario</button> 

</form>

</div>
</div>

<%@include file="/footer.jsp"%>
</body>


</html>
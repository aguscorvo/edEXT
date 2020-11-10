<%@page import="publicadores.ControladorConsultaUsuarioPublishService" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublish" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">

<title>Consulta de usuario</title>
</head>
<body>
<%
ControladorConsultaUsuarioPublishService cps = new ControladorConsultaUsuarioPublishServiceLocator();
ControladorConsultaUsuarioPublish port = cps.getControladorConsultaUsuarioPublishPort();

String edicion = request.getParameter("edicion");
String estudiantesAceptados = port.getEstudiantesAceptadosAEdicion(edicion);
%>

<div class="row">
<div class="col-sm-2 mx-auto">

<div class="form-group">
	<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
		  <div class="card-header">ESTUDIANTES ACEPTADOS</div>
		  <div class="card-body">
		  	<p class="card-text">Edicion: <%=edicion%></p>		  	
		    <p class="card-text"><%=estudiantesAceptados%></p>
		  </div>
	</div>
</div>

</div>
</div>


<%@include file="/footer.jsp"%>


</body>
</html>
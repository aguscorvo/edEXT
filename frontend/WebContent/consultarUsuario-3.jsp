<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorConsultaUsuario"%>

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
Fabrica fab = Fabrica.getInstancia();
IControladorConsultaUsuario iCon = fab.getIControladorConsultaUsuario();

String edicion = request.getParameter("edicion");
String estudiantesAceptados = iCon.getEstudiantesAceptadosAEdicion(edicion);
%>

<div class="form-group">
	<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
		  <div class="card-header">ESTUDIANTES ACEPTADOS</div>
		  <div class="card-body">
		  	<p class="card-text">Edicion: <%=edicion%></p>		  	
		    <p class="card-text"><%=estudiantesAceptados%></p>
		  </div>
	</div>
</div>


<%@include file="/footer.jsp"%>


</body>
</html>
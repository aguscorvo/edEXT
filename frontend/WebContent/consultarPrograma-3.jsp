<%@page import="publicadores.ControladorConsultaProgFormacionPublishService" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublish" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublishServiceLocator" %>
<%@page import="publicadores.DtCursoExp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Consultar curso</title>
</head>

<body>

<%
ControladorConsultaProgFormacionPublishService cps = new ControladorConsultaProgFormacionPublishServiceLocator();
ControladorConsultaProgFormacionPublish port = cps.getControladorConsultaProgFormacionPublishPort();
String curso = request.getParameter("cursos");

DtCursoExp dtCurso = port.seleccionarCurso(curso);
String datosCurso = port.obtenerDatosCurso(dtCurso);


%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="index.jsp" id="form1">  

	<div class="form-group">
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			
 			<div class="card-header">DATOS DEL CURSO</div>
  				<div class="card-body">
   					<p class="card-text"><%=datosCurso%></p>
  			</div>
		</div>
	</div>	
	  
  <button type="submit" class="btn btn-dark">Volver a home</button> 

</form>

</div>
</div>

<%@include file="/footer.jsp"%>

</body>
</html>
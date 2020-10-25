<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorConsultaProgFormacion"%>
<%@page import="datatype.DtCursoExp"%>

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
Fabrica fab = Fabrica.getInstancia();
IControladorConsultaProgFormacion iCon = fab.getIControladorConsultaProgFormacion();
String curso = request.getParameter("cursos");

DtCursoExp dtCurso = iCon.seleccionarCurso(curso);
String datosCurso = iCon.obtenerDatosCurso(dtCurso);


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
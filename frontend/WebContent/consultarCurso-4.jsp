<%@page import="publicadores.ControladorConsultaCursoPublishService" %>
<%@page import="publicadores.ControladorConsultaCursoPublish" %>
<%@page import="publicadores.ControladorConsultaCursoPublishServiceLocator" %>
<%@page import="publicadores.DtEdicion"%>
<%@page import="publicadores.DtProgFormacionExp"%>

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
ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();

//verifico si se seleccinó edición o programa
String tipo= request.getParameter("tipoListarPor");
String datos =null;

if (tipo.equals("edicion")){
	String edicion= request.getParameter("edicionPrograma");
	DtEdicion dtEdicion = port.seleccionarEdicion(edicion);
	datos = port.obtenerDatosEdicion(dtEdicion);	
}
else if (tipo.equals("programa")){
	String programa = request.getParameter("edicionPrograma");
	DtProgFormacionExp dtPrograma = port.seleccionarProgFormacion(programa);
	datos = port.obtenerDatosPrograma(dtPrograma);
}

%>


<div class="row">
<div class="col-sm-2 mx-auto">
<form action="index.jsp" id="form1">  

	<div class="form-group">
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<% String titulo=null; 
 			if (tipo.equals("edicion"))
 				titulo= "EDICIÓN";
 			else if (tipo.equals("programa"))
 				titulo="PROGRAMA";
 			 %>
 			<div class="card-header">DATOS DE <%=titulo %></div>
  				<div class="card-body">
   					<p class="card-text"><%=datos%></p>
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
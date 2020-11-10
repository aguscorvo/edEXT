<%@page import="publicadores.ControladorConsultaProgFormacionPublishService" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublish" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Consultar programa de formación</title>
</head>

<body>

<%
ControladorConsultaProgFormacionPublishService cps = new ControladorConsultaProgFormacionPublishServiceLocator();
ControladorConsultaProgFormacionPublish port = cps.getControladorConsultaProgFormacionPublishPort();
String [] arrProgramas = port.getProgramasDeFormacion();


%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="consultarPrograma-2.jsp" method="post" id="form1">  
   
	<div class="form-group">
	   <select name="programa" class="custom-select" id="programa" required>
		  <option selected disabled value="">Seleccione programa</option>
		  
			  <%int i=0;
			  while (i<arrProgramas.length){%>
				  <option value="<%=arrProgramas[i]%>"><%=arrProgramas[i]%></option>
				 <% i++;
			  } %>	
		    
	  </select>
	</div>
	  
	 <button type="submit" class="btn btn-dark">Obtener información del programa</button> 

</form>

</div>
</div>

<%@include file="/footer.jsp"%>

</body>
</html>
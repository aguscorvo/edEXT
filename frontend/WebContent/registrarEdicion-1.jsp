<%@page import="publicadores.ControladorAltaEdicionPublish" %>
<%@page import="publicadores.ControladorAltaEdicionPublishService" %>
<%@page import="publicadores.ControladorAltaEdicionPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Registro de edición de curso</title>
</head>

<body>
<%

ControladorAltaEdicionPublishService cps = new ControladorAltaEdicionPublishServiceLocator();
ControladorAltaEdicionPublish port = cps.getControladorAltaEdicionPublishPort();

String [] institutos= port.getInstitutos();

%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="registrarEdicion-2.jsp" method="post" id="form1">
  
   
<div class="form-group">
   <select name="instituto" class="custom-select" id="instituto" required>
	  <option selected disabled value="">Seleccione instituto</option>
	  
		  <%int i=0;
		  while (i<institutos.length){%>
			  <option value="<%=institutos[i]%>"><%=institutos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  
  <button type="submit" class="btn btn-dark">Obtener cursos</button> 
  

</form>

</div>
</div>

<%@include file="/footer.jsp"%>

</body>
</html>
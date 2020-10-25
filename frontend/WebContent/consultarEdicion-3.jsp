<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorConsultaEdicion"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Consultar edición</title>
</head>

<body>

<%Fabrica fab = Fabrica.getInstancia();
IControladorConsultaEdicion iCon = fab.getIControladorConsultaEdicion();
String curso = request.getParameter("curso");
String [] arrEdiciones = iCon.getEdiciones(curso);
%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="consultarEdicion-4.jsp" method="post" id="form1">  
   
	<div class="form-group">
	   <select name="edicion" class="custom-select" id="edicion" required>
		  <option selected disabled value="">Seleccione Edicion</option>
		  
			  <%int i=0;
			  while (i<arrEdiciones.length){%>
				  <option value="<%=arrEdiciones[i]%>"><%=arrEdiciones[i]%></option>
				 <% i++;
			  } %>	
		    
	  </select>
	</div>
	  
	 <button type="submit" class="btn btn-dark">Mostrar informacion</button> 

</form>

</div>
</div>

</body>
</html>
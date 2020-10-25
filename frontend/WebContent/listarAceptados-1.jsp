<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorListarAceptados" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();
IControladorListarAceptados iCon = fab.getIControladorListarAceptados();
String [] institutos= iCon.getInstitutos();

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Listar Aceptados</title>
</head>
<body>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="listarAceptados-2.jsp" method="post" id="formulario">
  
   
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
  
  <button type="submit" class="btn btn-dark">Obtener Cursos</button> 
  

</form>

</div>
</div>


<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>
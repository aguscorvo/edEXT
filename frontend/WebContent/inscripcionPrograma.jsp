<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorInscripcionAPrograma" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();
IControladorInscripcionAPrograma iCon = fab.getIControladorInscripcionAPrograma();
String [] programas= iCon.getProgramas();

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Inscripción a programa</title>
</head>
<body>

<br>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="InscripcionPrograma" method="post" id="formulario">
  
   
<div class="form-group">
   <select name="programa" class="custom-select" id="programa" required>
	  <option selected disabled value="">Seleccione programa</option>
	  
		  <%int i=0;
		  while (i<programas.length){%>
			  <option value="<%=programas[i]%>"><%=programas[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  
  <br>
  
  <button type="submit" class="btn btn-dark">Confirmar</button> 
  

</form>

</div>
</div>


<%@include file="/footer.jsp"%>


</body>
</html>
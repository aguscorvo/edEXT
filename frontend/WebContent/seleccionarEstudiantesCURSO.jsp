<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorSeleccionarEstudiantes" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();

String inst = request.getParameter("instituto");
IControladorSeleccionarEstudiantes iCon = fab.getIControladorSeleccionarEstudiantes();
String [] cursos= iCon.ingresarInstituto(inst);

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Seleccionar Estudiantes</title>
</head>
<body>
<form action="seleccionarEstudiantesFINAL.jsp" method="post" id="formulario">
  
   
<div class="form-group">
   <select name="curso" class="custom-select" id="curso" required>
	  <option selected disabled value="">Seleccione Curso</option>
	  
		  <%int i=0;
		  while (i<cursos.length){%>
			  <option value="<%=cursos[i]%>"><%=cursos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  
  <button type="submit" class="btn btn-dark">Obtener Estudiantes</button> 
  <p style="color:white";> &nbsp&nbsp Al hacer click en el botón se obtendrán los datos de la edición vigente y sus estudiantes</p>

</form>


<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>
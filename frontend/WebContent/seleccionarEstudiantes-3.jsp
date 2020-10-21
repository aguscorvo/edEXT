<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorSeleccionarEstudiantes" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();

String curso = request.getParameter("curso");
String docente = (String) session.getAttribute("tipoUsuarioLogueado");
System.out.println(docente);
IControladorSeleccionarEstudiantes iCon = fab.getIControladorSeleccionarEstudiantes();
String edicion = iCon.ingresarCurso(curso, docente);
String datos = iCon.obtenerDatosBasicosEd();
String [] estudiantes= iCon.getEstudiantes();

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

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">EDICIÓN VIGENTE</div>
  <div class="card-body">
    <p class="card-text"><%=datos%></p>
  </div>
</div>
</div>

<p> <br></p>

<form action="SeleccionarEstudiantes" method="post" id="formulario">
  
  <input type = "hidden" name = "boton" value = "<%=edicion%>" id="boton">
   
<div class="form-group"> 
  <select name="estudiantes" class="custom-select" multiple id="estudiantes">
	  <option selected disabled value="">Seleccione Estudiantes</option>
	  
		  <%int j=0;
		  while (j<estudiantes.length){%>
			  <option value="<%=estudiantes[j]%>"><%=estudiantes[j]%></option>
			 <% j++;
		  } %>	
	  
  </select>
</div>  
  
  <p> <br></p>
  
  <p style="color:white";> &nbsp &nbsp Seleccionar la opción deseada</p>
  
  <!-- RadioButton-->
	<div class="form-group">   
	 <div class="btn-group btn-group-toggle" data-toggle="buttons">
	  <label class="btn btn-secondary active">
	    <input type="radio" name="AceptarRechazar" id="Aceptar" value= "Aceptar">Aceptar
	  </label>
	  <label class="btn btn-secondary active">
	    <input type="radio" name="AceptarRechazar" id="Rechazar" value = "Rechazar">Rechazar
	  </label>
	</div>
	  <div id = "log" ></div>
	</div>
  
  <p> <br></p>
  
  <button type="submit" class="btn btn-dark">Confirmar</button> 
 
  
</form>


<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>


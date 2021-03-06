<%@page import="publicadores.ControladorConsultaProgFormacionPublishService" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublish" %>
<%@page import="publicadores.ControladorConsultaProgFormacionPublishServiceLocator" %>
<%@page import="publicadores.DtProgFormacionExp"%>



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
String programa = request.getParameter("programa");

//se obtienen datos del programa seleccionado
DtProgFormacionExp dtPF = port.seleccionarPrograma(programa);
String datosPrograma = port.obtenerDatosPrograma(dtPF);
String [] categorias = port.getCategoriasPrograma(programa); //categorias asociadas
String [] cursos = port.getCursos(dtPF); //cursos que lo integran

%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="consultarPrograma-3.jsp" method="post" id="form1">  

	<div class="form-group">
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<div class="card-header">DATOS DEL PROGRAMA</div>
  				<div class="card-body">
   					<p class="card-text"><%=datosPrograma%></p>
  			</div>
		</div>
	</div>
	
	<div class="form-group"> 
  		<select name="categorias" class="custom-select" id="categorias">
	  		<option selected disabled value="">Categorías</option>
	  
			  <%int i=0;
			  while (i<categorias.length){%>
				  <option value="<%=categorias[i]%>"><%=categorias[i]%></option>
				 <% i++;
			  } %>	
	  
 		</select>
	</div> 
	
	<div class="form-group"> 
  		<select name="cursos" class="custom-select" id="cursos" required>
	  		<option selected disabled value="">Cursos</option>
	  
			  <%int j=0;
			  while (j<cursos.length){%>
				  <option value="<%=cursos[j]%>"><%=cursos[j]%></option>
				 <% j++;
			  } %>	
	  
 		</select>
	</div> 
		 
  
  <button type="submit" class="btn btn-dark">Obtener información del curso</button> 

</form>

</div>
</div>


<%@include file="/footer.jsp"%>

</body>
</html>
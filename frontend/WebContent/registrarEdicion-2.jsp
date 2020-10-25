<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorAltaEdicion" %>
<%@page import="logica.Instituto" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Registro de edición de curso</title>
</head>

<body>
<%
Fabrica fab = Fabrica.getInstancia();
IControladorAltaEdicion iCon = fab.getIControladorAltaEdicion();

//devuelvo cursos según el instituto elegido anteriormente
String nombreInstituto = request.getParameter("instituto");
Instituto instituto = iCon.getInstituto(nombreInstituto);
String [] cursos= iCon.getCursos(instituto);

//devuelvo docentes registrados en el sistema
String [] docentes= iCon.getDocentes();

%>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="RegistrarEdicion" method="post" id="formulario">
  
   <!-- Cursos -->
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
	<!-- Nombre -->
	<div class="form-group">
	    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
	  </div>
	<!-- Docentes -->
	<div class="form-group"> 
	  <select name="docente" class="custom-select" multiple id="docentes" required>
		  <option selected disabled value="">Seleccione docentes</option>
		  
			  <%int j=0;
			  while (j<docentes.length){%>
				  <option value="<%=docentes[j]%>"><%=docentes[j]%></option>
				 <% j++;
			  } %>	
		  
	  </select>
	</div> 
	<!-- Fecha de inicio -->
	<div class="form-group">
  		<div style="max-width:400px;margin:auto"> 
        	<div class="input-icons"> 
				<i class="fa fa-calendar"></i>	
	  			<input class="form-control" type="text" name=fechaInicio id="fecha1" placeholder="Fecha de inicio" required>
        	</div> 
 		</div> 
  	</div>	
	<!-- Fecha de finalización -->
	<div class="form-group">
  		<div style="max-width:400px;margin:auto"> 
        	<div class="input-icons"> 
				<i class="fa fa-calendar"></i>	
	  			<input class="form-control" type="text" name=fechaFinalizacion id="fecha2" placeholder="Fecha de finalización" required>
        	</div> 
 		</div> 
  	</div>	
	<!-- Cupo -->
	<div class="form-check form-check-inline">
		<input class="form-check-input" type="checkbox" id="checkboxCupo" name="checkboxCupo" value="tieneCupo" onclick="habilitarInputCupo()">
		<label class="form-check-label" for="checkboxCupo">Cupo</label>
	</div>
	<div class="form-group">
    	<input type="number" name= "cupo" class="form-control" id="cupo" placeholder="Cupo" disabled required>
  	</div>
  	  
	<button type="submit" class="btn btn-dark">Confirmar</button> 
	  
</form>

</div>
</div>


<script>

	function habilitarInputCupo(){
		var checkbox = document.getElementById("checkboxCupo");
		var inputCupo = document.getElementById("cupo");
		if (checkbox.checked==true)
			inputCupo.disabled=false;		
		else	
			inputCupo.disabled=true;
		
	};

</script>


<%@include file="/footer.jsp"%>
<%@include file="/calendarioActual1.jsp"%>
<%@include file="/calendarioActual2.jsp"%>



</body>
</html>
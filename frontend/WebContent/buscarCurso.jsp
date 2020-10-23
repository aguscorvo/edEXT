<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorConsultaCurso"%>
<%@page import="datatype.DtCursoExp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Buscar curso</title>
</head>

<body>

<%
Fabrica fab = Fabrica.getInstancia();
IControladorConsultaCurso iCon = fab.getIControladorConsultaCurso();
String curso = (String) request.getAttribute("curso");


//se obtienen datos del curso seleccionado
DtCursoExp dtCurso = iCon.seleccionarCurso(curso);
String datosCurso = iCon.obtenerDatosCurso(dtCurso);
String [] previas = iCon.getPrevias(curso);
String [] categorias = iCon.getCategorias(curso);

//se obtienen las ediciones/programas en las/los que está el curso
String [] ediciones = iCon.getEdiciones(curso);
String [] programas = iCon.getPFs(curso);
%>

<form action="consultarCurso-4.jsp" method="post" id="form1">  

	<div class="form-group">
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<div class="card-header">DATOS DEL CURSO</div>
  				<div class="card-body">
   					<p class="card-text"><%=datosCurso%></p>
  			</div>
		</div>
	</div>
	
	<div class="form-group"> 
  		<select name="previas" class="custom-select" id="previas">
	  		<option selected disabled value="">Previas</option>
	  
			  <%int i=0;
			  while (i<previas.length){%>
				  <option value="<%=previas[i]%>"><%=previas[i]%></option>
				 <% i++;
			  } %>	
	  
 		</select>
	</div> 
	
	<div class="form-group"> 
  		<select name="categorias" class="custom-select" id="categorias">
	  		<option selected disabled value="">Categorías</option>
	  
			  <%int j=0;
			  while (j<categorias.length){%>
				  <option value="<%=categorias[j]%>"><%=categorias[j]%></option>
				 <% j++;
			  } %>	
	  
 		</select>
	</div> 
	
	<p style="color:white";>Presionar una opción para desplegar ediciones o programas de formación.</p>
	<!-- RadioButton-->
	
	<div class="form-group">   
	 <div class="btn-group btn-group-toggle" data-toggle="buttons">
	  <label class="btn btn-secondary active">
	    <input type="radio" name="tipoListarPor" id="edicion" value= "edicion">Edición
	  </label>
	  <label class="btn btn-secondary active">
	    <input type="radio" name="tipoListarPor" id="programa" value = "programa">Programa
	  </label>
	</div>
	  <div id = "log" ></div>
	</div>

	<div class="form-group">
   		<select name="edicionPrograma" class="custom-select" id="edicionPrograma" disabled required>
	  		<option selected disabled value="">Seleccione un elemento</option>
  		</select>
	</div> 
	 
  
  <button type="submit" class="btn btn-dark">Obtener información de edición/programa</button> 

</form>

<script>    
 
var ediPf = document.getElementById('edicionPrograma');
var nuevoValor;

//si esta seleccionado edición
document.getElementById('edicion').addEventListener('click', function(e) {
  ediPf.disabled = false;
  for (var num1=0 ; num1 < form1.edicionPrograma.options.length ; num1++){
	form1.edicionPrograma.options [num1 + 1]= null;
  } 
  
  <%int k=0;
  while (k<ediciones.length){%>
  
  	nuevoValor = new Option("<%=ediciones[k]%>","<%=ediciones[k]%>");
  	form1.edicionPrograma.options [<%=k%> + 1] = nuevoValor;

  	<%k++;
  }%>
 
});

//si esta seleccionado categoria
document.getElementById('programa').addEventListener('click', function(e) {
  ediPf.disabled = false;
  for (var num2=0 ; num2 < form1.edicionPrograma.options.length ; num2++){
		form1.edicionPrograma.options [num2 + 1]= null;
	  } 
  <%int l=0;
  while (l<programas.length){%>
  
  	nuevoValor = new Option("<%=programas[l]%>","<%=programas[l]%>");
  	form1.edicionPrograma.options [<%=l%> + 1]= nuevoValor;

  	<%l++;
  }%>


  
});

</script>


<%@include file="/footer.jsp"%>

</body>
</html>
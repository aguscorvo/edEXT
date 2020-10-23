<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorBuscarCursoOPrograma"%>
<%@page import="datatype.DtCurso"%>
<%@page import="datatype.DtProgFormacion"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="logica.funcionesAux"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>

<link rel="stylesheet" href="css/estilos.css">
<title>Buscar curso o programa</title>
</head>

<body>

<%

Fabrica fab = Fabrica.getInstancia();
IControladorBuscarCursoOPrograma iCon = fab.getIControladorBuscarCursoOPrograma();

//CURSOS
String curso = request.getParameter("buscar");
ArrayList<DtCurso> cursos = iCon.buscarCursos(curso);

//PROGRAMAS

String programa = request.getParameter("buscar");
ArrayList<DtProgFormacion> programas = iCon.buscarProgramas(programa);

%>

<!-- PESTAÑAS CURSOS Y PROGRAMAS -->

<ul class="nav nav-tabs justify-content-center">
	<li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Cursos</a>
	    <div class="dropdown-menu">
	      <a class="dropdown-item" data-toggle="tab" href="#cursosOrdenadosPorFecha">Ordenados por fecha</a>
	      <a class="dropdown-item" data-toggle="tab" href="#cursosOrdenadosAlfabeticamente">Ordenados alfabéticamente</a>      
	    </div>
	</li>
	<li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Programas</a>
	    <div class="dropdown-menu">
	      <a class="dropdown-item" data-toggle="tab" href="#programasOrdenadosPorFecha">Ordenados por fecha</a>
	      <a class="dropdown-item" data-toggle="tab" href="#programasOrdenadosAlfabeticamente">Ordenados alfabéticamente</a>      
	    </div>
	</li>   
</ul>

<form action="BuscarCursoOPrograma" method="post" id="formulario">

<div class="tab-content">
	
	<!-- CURSOS ORDENADOS POR FECHA -->
	
	<div class="tab-pane fade show active" id="cursosOrdenadosPorFecha">
		<%
		//los cursos se ordenan por fecha
		cursos=iCon.ordenarCursosPorFecha(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">
		    
		  </div>
		  <div class="card-body">
		    <h5 class="card-title"><%=c.getNombre()%></h5>
		    <p class="card-text"><%=c.getDesc() %></p>
		    <button type="submit" class="btn  btn-dark border-secondary" onblur="seleccionCurso1()">Ver información del curso</button> 	    
	    	<input type="hidden" name="nombreCurso1" id="nombreCurso1" value="<%=c.getNombre()%>">
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(c.getFechaR()) %>  
		  </div>
		</div>
		<%} %>
	
	</div>
	
	<!-- CURSOS ORDENADOS ALFABÉTICAMENTE -->
	
	<div class="tab-pane fade" id="cursosOrdenadosAlfabeticamente">
	
		<%
		//los cursos se ordenan alfabeticamente
		cursos=iCon.ordenarCursosAlfabeticamente(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">
		    
		  </div>
		  <div class="card-body">
		    <h5 class="card-title"><%=c.getNombre()%></h5>
		    <p class="card-text"><%=c.getDesc() %></p>
		    <button type="submit" class="btn  btn-dark border-secondary" onblur="seleccionCurso2()">Ver información del curso</button> 	    
	    	<input type="hidden" name="nombreCurso2" id="nombreCurso2"value="<%=c.getNombre()%>">
	    	
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(c.getFechaR()) %>  
		  </div>
		</div>
		<%} %>
	
	</div>
	
	<!-- PROGRAMAS ORDENADOS POR FECHA -->
	
	<div class="tab-pane fade" id="programasOrdenadosPorFecha">
	
		<%
		//los programas se ordenan por fecha
		programas=iCon.ordenarProgramasPorFecha(programas);		
		
		for (DtProgFormacion pf: programas) {%>
	 <div class="card text-center bg-dark border-secondary text-white text-center">
	  <div class="card-header">
	    
	  </div>
	  <div class="card-body">
	    <h5 class="card-title"><%=pf.getNombre()%></h5>
	    <p class="card-text"><%=pf.getDesc() %></p>
	    <button type="submit" class="btn  btn-dark border-secondary" onblur="seleccionPrograma1()">Ver información del programa</button> 	    
	    <input type="hidden" name="nombrePrograma1" value="<%=pf.getNombre()%>">
	  </div>
	  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
	  </div>
	</div>
	
	<%} %>	

	</div>
	
	<!-- PROGRAMAS ORDENADOS ALFABÉTICAMENTE -->
		
	<div class="tab-pane fade" id="programasOrdenadosAlfabeticamente">
	
		<%
		//los programas se ordenan alfabeticamente
		programas=iCon.ordenarProgramasAlfabeticamente(programas);		
		
		for (DtProgFormacion pf: programas) {%>
	<div class="card text-center bg-dark border-secondary text-white text-center">
	  <div class="card-header">
	    
	  </div>
	  <div class="card-body">
	    <h5 class="card-title"><%=pf.getNombre()%></h5>
	    <p class="card-text"><%=pf.getDesc() %></p>
	     <button type="submit" class="btn  btn-dark border-secondary" onblur="seleccionPrograma2()">Ver información del programa</button> 
	    
	    <input type="hidden" name="nombrePrograma2" id="nombrePrograma2" value="<%=pf.getNombre()%>">
	  </div>
	  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
	  </div>
	</div>
	
	<%} %>	


	</div>

</div> 
</form>


</body>


<script>

function seleccionCurso1(){
	var curso1 = document.getElementById("nombreCurso1").value;
	console.log(curso1);
	//document.getElementById("nombreCurso2").value = null;
	//document.getElementById("nombrePrograma1").value = null;
	//document.getElementById("nombrePrograma2").value = null;	
}


function seleccionCurso2(){	
	var curso2 = document.getElementById("nombreCurso2").value;
	console.log(curso2);
	//document.getElementById("nombreCurso1").value = null;
	//document.getElementById("nombrePrograma1").value = null;
	//document.getElementById("nombrePrograma2").value = null;	
}

function seleccionPrograma1(){
	//document.getElementById("nombreCurso1").value = null;	
	//document.getElementById("nombreCurso2").value = null;
	//document.getElementById("nombrePrograma2").value = null;
}

function seleccionPrograma2(){
	//document.getElementById("nombreCurso1").value = null;	
	//document.getElementById("nombreCurso2").value = null;
	//document.getElementById("nombrePrograma1").value = null;
}


</script>


<%@include file="/footer.jsp"%>

</html>
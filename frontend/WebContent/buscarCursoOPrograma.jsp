<%@page import="publicadores.ControladorBuscarCursoOProgramaPublishService" %>
<%@page import="publicadores.ControladorBuscarCursoOProgramaPublish" %>
<%@page import="publicadores.ControladorBuscarCursoOProgramaPublishServiceLocator" %>
<%@page import="publicadores.DtCurso"%>
<%@page import="publicadores.DtProgFormacion"%>
<%@page import="logica.funcionesAux"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>

<link rel="stylesheet" href="css/estilos.css">
<title>Buscar curso o programa de formación</title>
</head>

<body>

<%

ControladorBuscarCursoOProgramaPublishService cps = new ControladorBuscarCursoOProgramaPublishServiceLocator();
ControladorBuscarCursoOProgramaPublish port = cps.getControladorBuscarCursoOProgramaPublishPort();

//CURSOS
String curso = request.getParameter("buscar");
DtCurso[] cursos = port.buscarCursos(curso);

//PROGRAMAS

String programa = request.getParameter("buscar");
DtProgFormacion[] programas = port.buscarProgramas(programa);

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


<div class="row">
<div class="col-sm-3 mx-auto">

<div class="tab-content">
	
	<!-- CURSOS ORDENADOS POR FECHA -->
	
	<div class="tab-pane fade show active" id="cursosOrdenadosPorFecha">
		<form action="consultarCurso-3.jsp" method="post" id="formulario1">
	
		<%
		//los cursos se ordenan por fecha
		cursos=port.ordenarCursosPorFecha(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		    <button type="submit" name="curso" id="curso" value="<%=c.getNombre()%>" class="btn btn-link"><%=c.getNombre()%></button> 
		    <p class="card-text"><%=c.getDesc() %></p>
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(c.getFechaR()) %>  
		  </div>
		</div>
		<%} %>
		</form>
	</div>
	
	<!-- CURSOS ORDENADOS ALFABÉTICAMENTE -->
	
	<div class="tab-pane fade" id="cursosOrdenadosAlfabeticamente">
		<form action="consultarCurso-3.jsp" method="post" id="formulario2">	
		<%
		//los cursos se ordenan alfabeticamente
		cursos=port.ordenarCursosAlfabeticamente(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		    <button type="submit" name="curso" id="curso" value="<%=c.getNombre()%>" class="btn btn-link"><%=c.getNombre()%></button> 
		    <p class="card-text"><%=c.getDesc() %></p>
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(c.getFechaR()) %>  
		  </div>
		</div>
		<%} %>
		</form>
	
	</div>
	
	
	
	<!-- PROGRAMAS ORDENADOS POR FECHA -->
	
	<div class="tab-pane fade" id="programasOrdenadosPorFecha">
		<form action="consultarPrograma-2.jsp" method="post" id="formulario3">
		
			<%
			//los programas se ordenan por fecha
			programas=port.ordenarProgramasPorFecha(programas);		
			
			for (DtProgFormacion pf: programas) {%>
		 <div class="card text-center bg-dark border-secondary text-white text-center" "card bg-light mb-3">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		  	<button type="submit" name="programa" id="programa" value="<%=pf.getNombre()%>" class="btn btn-link"><%=pf.getNombre()%></button>
		    <p class="card-text"><%=pf.getDesc() %></p>
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
		  </div>
		</div>
		
		<%} %>	
		</form>
	</div>
	
	<!-- PROGRAMAS ORDENADOS ALFABÉTICAMENTE -->
		
	<div class="tab-pane fade" id="programasOrdenadosAlfabeticamente">	
		<form action="consultarPrograma-2.jsp" method="post" id="formulario4">	
		
		<%
		//los programas se ordenan alfabeticamente
		programas=port.ordenarProgramasAlfabeticamente(programas);		
		
		for (DtProgFormacion pf: programas) {%>
		<div class="card text-center bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		  	<button type="submit" name="programa" id="programa" value="<%=pf.getNombre()%>" class="btn btn-link"><%=pf.getNombre()%></button>
		    <p class="card-text"><%=pf.getDesc() %></p>
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
		  </div>
		</div>
		
		<%} %>	
	
		</form>
	</div>

</div> 

</div>
</div> 


</body>


<%@include file="/footer.jsp"%>

</html>
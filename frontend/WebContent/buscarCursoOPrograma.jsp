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
<title>Buscar curso o programa de formación</title>
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


<div class="tab-content">
	
	<!-- CURSOS ORDENADOS POR FECHA -->
	
	<div class="tab-pane fade show active" id="cursosOrdenadosPorFecha">
		<form action="consultarCurso-3.jsp" method="post" id="formulario1">
	
		<%
		//los cursos se ordenan por fecha
		cursos=iCon.ordenarCursosPorFecha(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		    <button type="submit" name="curso" id="curso" value="<%=c.getNombre()%>" class="btn  btn-dark border-secondary"><%=c.getNombre()%></button> 
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
		cursos=iCon.ordenarCursosAlfabeticamente(cursos);
		
		for (DtCurso c: cursos) {%>
		<div class="card bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		    <button type="submit" name="curso" id="curso" value="<%=c.getNombre()%>" class="btn  btn-dark border-secondary"><%=c.getNombre()%></button> 
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
			programas=iCon.ordenarProgramasPorFecha(programas);		
			
			for (DtProgFormacion pf: programas) {%>
		 <div class="card text-center bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		  	<button type="submit" name="programa" id="programa" value="<%=pf.getNombre()%>" class="btn  btn-dark border-secondary"><%=pf.getNombre()%></button>
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
		programas=iCon.ordenarProgramasAlfabeticamente(programas);		
		
		for (DtProgFormacion pf: programas) {%>
		<div class="card text-center bg-dark border-secondary text-white text-center">
		  <div class="card-header">		    
		  </div>
		  <div class="card-body">
		  	<button type="submit" name="programa" id="programa" value="<%=pf.getNombre()%>" class="btn  btn-dark border-secondary"><%=pf.getNombre()%></button>
		    <p class="card-text"><%=pf.getDesc() %></p>
		  </div>
		  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
		  </div>
		</div>
		
		<%} %>	
	
		</form>
	</div>

</div> 


</body>


<%@include file="/footer.jsp"%>

</html>
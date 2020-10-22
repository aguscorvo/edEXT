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

//CURSOS
String curso = request.getParameter("buscar");
System.out.println(curso);


Fabrica fab = Fabrica.getInstancia();
IControladorBuscarCursoOPrograma iCon = fab.getIControladorBuscarCursoOPrograma();
ArrayList<DtCurso> cursos = iCon.buscarCursos(curso);

System.out.println("\ncursos que coinciden: ");
for (DtCurso c: cursos){
	System.out.println(c.getNombre());
}

//los cursos se ordenan alfabeticamente
cursos=iCon.ordenarCursosAlfabeticamente(cursos);
System.out.println("\ncursos ordenados alfabeticamente: ");
for (DtCurso c: cursos){
	System.out.println(c.getNombre());
}

//los cursos se ordenan por fecha
cursos=iCon.ordenarCursosPorFecha(cursos);
System.out.println("\ncursos ordenados por fecha: ");
for (DtCurso c: cursos){
	System.out.println(c.getNombre());
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//PROGRAMAS

String programa = request.getParameter("buscar");
System.out.println(programa);

ArrayList<DtProgFormacion> programas = iCon.buscarProgramas(programa);

System.out.println("\nprogramas que coinciden: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
}

//los programas se ordenan alfabeticamente
programas=iCon.ordenarProgramasAlfabeticamente(programas);
System.out.println("\nprogramas ordenados alfabeticamente: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
}

//los programas se ordenan por fecha
programas=iCon.ordenarProgramasPorFecha(programas);
System.out.println("\nprogramas ordenados por fecha: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
}

%>

<ul class="nav nav-tabs justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="#cursos" data-toggle="tab">Cursos</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#programas" data-toggle="tab">Programas</a>
  </li>    
</ul>


<div class="form-group mx-auto">   
 <div class="btn-group btn-group-toggle" data-toggle="buttons">
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoOrden" id="alfabeticamente" value= "alfabeticamente">Ordenar alfabéticamente
  </label>
  <label class="btn btn-secondary active">
    <input type="radio" name="tipoOrden" id="fecha" value = "fecha" checked>Ordenar por fecha
  </label>
</div>
  <div id = "log" ></div>
</div>

<div class="tab-content">
	<div class="tab-pane fade show active" id="cursos">
	<%for (DtCurso c: cursos) {%>
	<div class="card bg-dark border-secondary text-white text-center">
	  <div class="card-header">
	    
	  </div>
	  <div class="card-body">
	    <h5 class="card-title"><%=c.getNombre()%></h5>
	    <p class="card-text"><%=c.getDesc() %></p>
	    <a href="#" class="btn btn-dark border-secondary">Ver información del curso</a>
	  </div>
	  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(c.getFechaR()) %>  
	  </div>
	</div>
	<%} %>
	
	</div>
	
	<div class="tab-pane fade" id="programas">
	
	<%for (DtProgFormacion pf: programas) {%>
<div class="card text-center bg-dark border-secondary text-white text-center">
  <div class="card-header">
    
  </div>
  <div class="card-body">
    <h5 class="card-title"><%=pf.getNombre()%></h5>
    <p class="card-text"><%=pf.getDesc() %></p>
    <a href="#" class="btn  btn-dark border-secondary">Ver información del curso</a>
  </div>
  <div class="card-footer text-muted">Fecha de publicación: <%= funcionesAux.convertirAString(pf.getFechaAlta()) %>  
  </div>
</div>

<%} %>	


	</div>


</div> 




</body>



<%@include file="/footer.jsp"%>

</html>
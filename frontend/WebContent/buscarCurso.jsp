<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorBuscarCursoOPrograma"%>
<%@page import="datatype.DtCurso"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="logica.funcionesAux"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<%@include file="/headerBuscar.jsp"%>

<link rel="stylesheet" href="css/estilos.css">
<title>Buscar curso</title>
</head>
<body>

<%

String cursoOPrograma = request.getParameter("buscar");
session.setAttribute("buscar", cursoOPrograma);
System.out.println(cursoOPrograma);
System.out.println(session.getAttribute("buscar"));


Fabrica fab = Fabrica.getInstancia();
IControladorBuscarCursoOPrograma iCon = fab.getIControladorBuscarCursoOPrograma();
ArrayList<DtCurso> cursos = iCon.buscarCursos(cursoOPrograma);

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


%>
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


</body>



<%@include file="/footer.jsp"%>

</html>
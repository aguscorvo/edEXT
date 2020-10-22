<%@page import="datatype.DtProgFormacion"%>
<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorBuscarCursoOPrograma"%>
<%@page import="datatype.DtCurso"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="logica.funcionesAux"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
String cursoOPrograma = (String) session.getAttribute("buscar");
System.out.println(cursoOPrograma);

Fabrica fab = Fabrica.getInstancia();
IControladorBuscarCursoOPrograma iCon = fab.getIControladorBuscarCursoOPrograma();
ArrayList<DtProgFormacion> programas = iCon.buscarProgramas(cursoOPrograma);

System.out.println("\ncursos que coinciden: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
}

//los cursos se ordenan alfabeticamente
programas=iCon.ordenarProgramasAlfabeticamente(programas);
System.out.println("\ncursos ordenados alfabeticamente: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
}

//los cursos se ordenan por fecha
programas=iCon.ordenarProgramasPorFecha(programas);
System.out.println("\ncursos ordenados por fecha: ");
for (DtProgFormacion pf: programas){
	System.out.println(pf.getNombre());
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


</body>
<%@include file="/footer.jsp"%>

</html>
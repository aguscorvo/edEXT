<%@page import="publicadores.ControladorListarResultadosInscripcionesPublish" %>
<%@page import="publicadores.ControladorListarResultadosInscripcionesPublishService" %>
<%@page import="publicadores.ControladorListarResultadosInscripcionesPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%

ControladorListarResultadosInscripcionesPublishService cps = new ControladorListarResultadosInscripcionesPublishServiceLocator();
ControladorListarResultadosInscripcionesPublish port = cps.getControladorListarResultadosInscripcionesPublishPort();

String estudiante = (String) session.getAttribute("nick");

String pendientes = port.inscripcionesPendientes(estudiante);
String rechazadas = port.inscripcionesRechazadas(estudiante);
String aceptadas = port.inscripcionesAceptadas(estudiante);

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Listar resultados de inscripciones</title>
</head>
<body>

<div class="row">
<div class="col-sm-2 mx-auto">

<h5 style="color:white";><br> &nbsp Este es el estado de tus inscripciones a ediciones de curso: <br><br></h5>

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">PENDIENTES</div>
  <div class="card-body">
    <p class="card-text"><%=pendientes%></p>
  </div>
</div>
</div>

<p> <br></p>

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">ACEPTADAS</div>
  <div class="card-body">
    <p class="card-text"><%=aceptadas%></p>
  </div>
</div>
</div>

<p> <br></p>


<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">RECHAZADAS</div>
  <div class="card-body">
    <p class="card-text"><%=rechazadas%></p>
  </div>
</div>
</div>


</div>
</div>

<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>


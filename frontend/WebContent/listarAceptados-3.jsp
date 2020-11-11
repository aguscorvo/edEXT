<%@page import="publicadores.ControladorListarAceptadosPublish" %>
<%@page import="publicadores.ControladorListarAceptadosPublishService" %>
<%@page import="publicadores.ControladorListarAceptadosPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%

String curso = request.getParameter("curso");
String docente = (String) session.getAttribute("tipoUsuarioLogueado");

ControladorListarAceptadosPublishService cps = new ControladorListarAceptadosPublishServiceLocator();
ControladorListarAceptadosPublish port = cps.getControladorListarAceptadosPublishPort();

String edicion = port.ingresarCurso(curso, docente);
String datos = port.obtenerDatosBasicosEd();
String estudiantes= port.getEstudiantesAceptados();

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Listar Aceptados</title>
</head>
<body>

<div class="row">
<div class="col-sm-2 mx-auto">

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">EDICIÓN VIGENTE</div>
  <div class="card-body">
    <p class="card-text"><%=datos%></p>
  </div>
</div>
</div>

<p> <br></p>

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">ESTUDIANTES ACEPTADOS</div>
  <div class="card-body">
    <p class="card-text"><%=estudiantes%></p>
  </div>
</div>
</div>
  

</div>
</div>

<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>


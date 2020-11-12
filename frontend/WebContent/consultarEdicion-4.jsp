<%@page import="publicadores.ControladorConsultaEdicionPublishService" %>
<%@page import="publicadores.ControladorConsultaEdicionPublish" %>
<%@page import="publicadores.ControladorConsultaEdicionPublishServiceLocator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%
ControladorConsultaEdicionPublishService cps = new ControladorConsultaEdicionPublishServiceLocator();
ControladorConsultaEdicionPublish port = cps.getControladorConsultaEdicionPublishPort();

String edicion = request.getParameter("edicion");
String datos = port.obtenerDatosBasicosEd(edicion);
String docentes= port.getDocentesAsignados(edicion);

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Consultar edición</title>
</head>
<body>

<div class="row">
<div class="col-sm-2 mx-auto">

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">DATOS BÁSICOS</div>
  <div class="card-body">
    <p class="card-text"><%=datos%></p>
  </div>
</div>
</div>

<p> <br></p>

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">DOCENTES ASOCIADOS</div>
  <div class="card-body">
    <p class="card-text"><%=docentes%></p>
  </div>
</div>
</div>

</div>
</div>

<%@include file="/footer.jsp"%>
<%@include file="/calendario.jsp"%>





</body>
</html>


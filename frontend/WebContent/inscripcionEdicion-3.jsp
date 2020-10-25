<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorInscripcionAEdicion" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();

String curso = request.getParameter("curso");
String estudiante = (String) session.getAttribute("tipoUsuarioLogueado");
IControladorInscripcionAEdicion iCon = fab.getIControladorInscripcionAEdicion();
String edicion = iCon.ingresarCurso(curso);
String datos = iCon.obtenerDatosBasicosEd();


%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Seleccionar Estudiantes</title>
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

<form action="InscripcionEdicion" method="post" id="formulario">
  
  <input type = "hidden" name = "boton1" value = "<%=edicion%>" id="boton1">
  <input type = "hidden" name = "boton2" value = "<%=curso%>"id = "boton2">
  
  <button type="submit" class="btn btn-dark">Confirmar</button> 
 
  
</form>

</div>
</div>


<%@include file="/footer.jsp"%>






</body>
</html>


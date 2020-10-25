<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorSeguirUsuarios" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%Fabrica fab = Fabrica.getInstancia();

String usuario = (String) session.getAttribute("nick");
IControladorSeguirUsuarios iCon = fab.getIcontroladorSeguirUsuarios();
String seguidos = iCon.getCadenaUsuariosSeguidos(usuario);

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>	Listar seguidos</title>
</head>
<body>

<br>

<div class="row">
<div class="col-sm-2 mx-auto">

<div class="form-group">
<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
  <div class="card-header">SIGUIENDO A:</div>
  <div class="card-body">
    <p class="card-text"><%=seguidos%></p>
  </div>
</div>
</div>
</div>
</div>

<%@include file="/footer.jsp"%>

</body>
</html>


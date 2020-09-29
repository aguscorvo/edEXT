<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notificación</title>
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">

</head>

<body>
<a style="opacity:0;" id="mensaje">${mensaje}</a>

<script src="js/notificacion.js"></script>
<script src="js/redirectHome.js"></script>


<%@include file="/footer.jsp"%>

</body>
</html>
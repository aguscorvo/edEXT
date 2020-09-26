<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">

<title>Cerrar sesión</title>
</head>
<body>
<%HttpSession s = request.getSession(false);
s.removeAttribute("tipoUsuarioLogueado");
s.getMaxInactiveInterval();
%>
<p>Sesión cerrada</p>

</body>
</html>
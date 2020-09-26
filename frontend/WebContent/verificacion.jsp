<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<p>Mirar en consola</p>
<%
if (session!=null){
	if(session.getAttribute("tipoUsuarioLogueado") != null){
		String tipo = (String) session.getAttribute("tipoUsuarioLogueado");
		System.out.println("usuario logueado. tipo: " +tipo);
	}else{
		System.out.println("usuario no logueado");
	}
}%>

</body>
</html>
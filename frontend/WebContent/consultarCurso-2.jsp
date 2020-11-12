<%@page import="publicadores.ControladorConsultaCursoPublishService" %>
<%@page import="publicadores.ControladorConsultaCursoPublish" %>
<%@page import="publicadores.ControladorConsultaCursoPublishServiceLocator" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Consultar curso</title>
</head>

<body>
<%

ControladorConsultaCursoPublishService cps = new ControladorConsultaCursoPublishServiceLocator();
ControladorConsultaCursoPublish port = cps.getControladorConsultaCursoPublishPort();


String [] arrCursos = null;
String tipo=request.getParameter("tipoListarPor");
if (tipo.equals("instituto")){
	String instituto= request.getParameter("institutosCategorias");
	arrCursos = port.ingresarInstituto(instituto);	
}
else if (tipo.equals("categoria")){
	String categoria = request.getParameter("institutosCategorias");
	arrCursos = port.getCursosPorCategoria(categoria);
}


%>

<div class="row">
<div class="col-sm-2 mx-auto">
<form action="consultarCurso-3.jsp" method="post" id="form1">  
   
	<div class="form-group">
	   <select name="curso" class="custom-select" id="curso" required>
		  <option selected disabled value="">Seleccione Curso</option>
		  
			  <%int i=0;
			  while (i<arrCursos.length){%>
				  <option value="<%=arrCursos[i]%>"><%=arrCursos[i]%></option>
				 <% i++;
			  } %>	
		    
	  </select>
	</div>
	  
	 <button type="submit" class="btn btn-dark">Obtener información de curso</button> 

</form>
</div>
</div>

<%@include file="/footer.jsp"%>

</body>
</html>
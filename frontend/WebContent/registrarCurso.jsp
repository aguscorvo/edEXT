<%@page import="publicadores.ControladorAltaCursoPublish" %>
<%@page import="publicadores.ControladorAltaCursoPublishService" %>
<%@page import="publicadores.ControladorAltaCursoPublishServiceLocator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<title>Registro de curso</title>
</head>

<body>

<%

ControladorAltaCursoPublishService cps = new ControladorAltaCursoPublishServiceLocator();
ControladorAltaCursoPublish port = cps.getControladorAltaCursoPublishPort();

String [] institutos= port.getInstitutos();
String [] cursos=port.getCursos();
String [] categorias=port.getCategorias();

%>
<div class="row">
<div class="col-sm-2 mx-auto">
<form action="RegistrarCurso" method="post" id="formulario">
<div class="form-group">  
  <select name="instituto" class="custom-select" id="instituto" required>
	  <option selected disabled value="">Seleccione instituto</option>
	  
		  <%int i=0;
		  while (i<institutos.length){%>
			  <option value="<%=institutos[i]%>"><%=institutos[i]%></option>
			 <% i++;
		  } %>	
	    
  </select>
</div>
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <div class="form-group">
    <input type="text" name= "descripcion" class="form-control" placeholder="Descripción" required>
  </div>
  <div class="form-group">
    <input type="number" name= "duracion" class="form-control" placeholder="Duración"  required>
  </div>
  <div class="form-group">
    <input type="number" name= "cantHoras" class="form-control" placeholder="Cantidad de horas"  required>
  </div>
  <div class="form-group">
    <input type="number" name= "creditos" class="form-control" placeholder="Créditos"  required>
  </div>
  <div class="form-group">
    <input type="url" name= "url" class="form-control" placeholder="Url" required>
  </div>  
<div class="form-group"> 
  <select name="previas" class="custom-select" multiple id="previas">
	  <option selected disabled value="">Seleccione previa</option>
	  
		  <%int j=0;
		  while (j<cursos.length){%>
			  <option value="<%=cursos[j]%>"><%=cursos[j]%></option>
			 <% j++;
		  } %>	
	  
  </select>
</div>  
<div class="form-group">  
   <select name="categorias" class="custom-select"  multiple id="categorias" required>
	  <option selected disabled value="">Seleccione categoría/s</option>
	  
		<%int k=0;
		  while (k<categorias.length){%>
			  <option value="<%=categorias[k]%>" ><%=categorias[k]%></option>
			 <% k++;
		  } %>	

  </select>
</div>

  <button type="submit" class="btn btn-dark">Confirmar</button> 
  
   
</form>

</div>
</div>




<%@include file="/footer.jsp"%>

</body>
</html>
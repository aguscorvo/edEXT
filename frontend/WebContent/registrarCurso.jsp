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


<form action="RegistrarUsuario" method="post" id="formulario">
  
  <select class="custom-select" id="validationTooltip04" required>
	  <option selected disabled value="">Seleccione instituto</option>
	  
	  <option>...</option>
  </select>
  
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <div class="form-group">
    <input type="text" name= "descripcion" class="form-control" placeholder="Descripción" required>
  </div>
  <div class="form-group">
    <input type="number" name= "duracion" class="form-control" placeholder="Duración" required>
  </div>
  <div class="form-group">
    <input type="number" name= "cantHoras" class="form-control" placeholder="Cantidad de horas" required>
  </div>
  <div class="form-group">
    <input type="number" name= "creditos" class="form-control" placeholder="Créditos" required>
  </div>
  <div class="form-group">
    <input type="url" name= "url" class="form-control" placeholder="Url" required>
  </div>  
  
  <select class="custom-select" multiple id="validationTooltip04" required>
	  <option selected disabled value="">Seleccione previa</option>
	  <option>...</option>
  </select>
   
   <select class="custom-select"  multiple id="validationTooltip04" required>
	  <option selected disabled value="">Seleccione categoría/s</option>
	  <option>...</option>
  </select>


   
  
  
  <button type="submit" class="btn btn-primary">Submit</button> 
  
   
</form>








<%@include file="/footer.jsp"%>

</body>
</html>
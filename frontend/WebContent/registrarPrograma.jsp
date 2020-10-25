<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Crear programa de formación</title>
</head>
<body>

<br>

<div class="row">
<div class="col-sm-2 mx-auto">

<form action="RegistrarPrograma" method="post" id="formulario">
  <div class="form-group">
    <input type="text" name= "nombre" class="form-control" placeholder="Nombre" required >
  </div>
  <br>
  <div class="form-group">
    <input type="text" name= "descripcion" class="form-control" placeholder="Descripcion" required>
  </div>
  <br> 
  <!-- Fecha  -->    
  <div class="form-group">
  <div style="max-width:400px;margin:auto"> 
        <div class="input-icons"> 
			<i class="fa fa-calendar"></i>	
  			<input class="form-control" type="text" name="fecha1" id="fecha1" placeholder="  Fecha de Inicio" required>
        </div> 
  </div> 
  </div>
  <br>
  <!-- Fecha  -->    
  <div class="form-group">
  <div style="max-width:400px;margin:auto"> 
        <div class="input-icons"> 
			<i class="fa fa-calendar"></i>	
  			<input class="form-control" type="text" name="fecha2" id="fecha2" placeholder="  Fecha de Finalizacion" required>
        </div> 
  </div> 
  </div>
  
  <br>
  
  <button type="submit" class="btn btn-dark">Confirmar</button> 
 

</form>

</div>
</div>


<%@include file="/footer.jsp"%>
<%@include file="/calendarioActual1.jsp"%>
<%@include file="/calendarioActual2.jsp"%>





</body>
</html>
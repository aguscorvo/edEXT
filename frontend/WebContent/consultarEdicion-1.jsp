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

String [] arrInstitutos= port.getInstitutos();
String [] arrCategorias= port.getCategoriasGlobal();

%>

<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">
<!--  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.theme.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">-->
<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 

<title>Consultar edición</title>
</head>
<body>


<div class="row">
<div class="col-sm-2 mx-auto">

<form action="consultarEdicion-2.jsp" method="post" name="form1">
    <p style="color:white";>Presionar una opcion para desplegar institutos o categorias</p>
	<!-- RadioButton-->
	
	<div class="form-group">   
	 <div class="btn-group btn-group-toggle" data-toggle="buttons">
	  <label class="btn btn-secondary active">
	    <input type="radio" name="tipoListarPor" id="instituto" value= "instituto">Instituto
	  </label>
	  <label class="btn btn-secondary active">
	    <input type="radio" name="tipoListarPor" id="categoria" value = "categoria">Categoria
	  </label>
	</div>
	  <div id = "log" ></div>
	</div>

	<div class="form-group">
   		<select name="institutosCategorias" class="custom-select" id="institutosCategorias" onchange="cargarCursos()" disabled required>
	  		<option selected disabled value="">Seleccione un elemento</option>
  		</select>
	</div> 


 <button type="submit" class="btn btn-dark">Obtener cursos</button>   
  
</form>

</div>
</div>


<script>    
 
var instCat = document.getElementById('institutosCategorias');
var nuevoValor;

//si esta seleccionado instituto
document.getElementById('instituto').addEventListener('click', function(e) {
  instCat.disabled = false;
  for (var num1=0 ; num1 < form1.institutosCategorias.options.length ; num1++){
	form1.institutosCategorias.options [num1 + 1]= null;
  } 
  
  <%int i=0;
  while (i<arrInstitutos.length){%>
  
  	nuevoValor = new Option("<%=arrInstitutos[i]%>","<%=arrInstitutos[i]%>","defaultSelected");
  	form1.institutosCategorias.options [<%=i%> + 1] = nuevoValor;

  	<%i++;
  }%>
 
});

//si esta seleccionado categoria
document.getElementById('categoria').addEventListener('click', function(e) {
  instCat.disabled = false;
  for (var num2=0 ; num2 < form1.institutosCategorias.options.length ; num2++){
		form1.institutosCategorias.options [num2 + 1]= null;
	  } 
  <%int j=0;
  while (j<arrCategorias.length){%>
  
  	nuevoValor = new Option("<%=arrCategorias[j]%>","<%=arrCategorias[j]%>","defaultSelected");
  	form1.institutosCategorias.options [<%=j%> + 1]= nuevoValor;

  	<%j++;
  }%>


  
});

</script>

<%@include file="/footer.jsp"%>

</body>
</html>
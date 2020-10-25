<%@page import="interfaces.Fabrica" %>
<%@page import="interfaces.IControladorConsultaUsuario"%>
<%@page import="datatype.DtUsuario"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/header.jsp"%>
<link rel="stylesheet" href="css/estilos.css">

<title>Consulta de usuario</title>
</head>

<body>

<%
Fabrica fab = Fabrica.getInstancia();
IControladorConsultaUsuario iCon = fab.getIControladorConsultaUsuario();

String usuario = request.getParameter("usuario");
DtUsuario dtUsuario = iCon.seleccionarUsuario(usuario);
String datosUsuario = iCon.obtenerDatosUsuario(dtUsuario);

//verifico de que tipo es el usuario seleccionado y si consulta por su propio perfil (si el usuario seleccionado en la consulta es el usuario logueado)
String tipo = "";
Boolean consultaPorUsuarioLogueado= false;

HttpSession s = request.getSession();
if (s.getAttribute("nick") != null && usuario.equals(s.getAttribute("nick").toString())){
	tipo= (String) s.getAttribute("tipoUsuarioLogueado");
	consultaPorUsuarioLogueado= true;
}else{
	tipo= iCon.tipoUsuarioSeleccionado(usuario);
	consultaPorUsuarioLogueado= false;
}

//ediciones asociadas al usuario seleccionado
String [] ediciones = iCon.getEdiciones(dtUsuario);

String [] programas = null;
String [] edicionesRechazadas = null;

if (tipo.equals("estudiante") ){
	//programas asociados al estudiante seleccionado
	programas = iCon.getProgramas(dtUsuario);
	
	if (consultaPorUsuarioLogueado){ 				 //si es estudiante y consulta por su propio perfil
		edicionesRechazadas = iCon.getEdicionesInscRechazadas(dtUsuario);
	}
	
}

%>

<div class="row">
<div class="col-sm-2 mx-auto">

	<!--  DATOS DE USUARIO -->
	<div class="form-group"> 
	
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<div class="card-header">DATOS DEL USUARIO</div>
  				<div class="card-body">
   					<p class="card-text"><%=datosUsuario%></p>
  			</div>
		</div>
	</div>
	
	<!-- EDICIONES ASOCIADAS -->
	<form action="consultarEdicion-4.jsp" method="post" id="form1">  	
	<div class="form-group"> 
  		<select name="edicion" class="custom-select" id="edicion" required>
	  		<option selected disabled value="">Ediciones</option>
	  
			  <%int i=0;
			  while (i<ediciones.length){%>
				  <option value="<%=ediciones[i]%>"><%=ediciones[i]%></option>
				 <% i++;
			  } %>	
	  
 		</select>
 		<button type="submit" class="btn btn-dark">Obtener información de edición</button> 
 		
	</div> 
	</form>
	
	
	<!-- PROGRAMAS ASOCIADOS -->
	<form action="consultarPrograma-2.jsp" method="post" id="form2"> 	
	<% if(tipo.equals("estudiante")){%>
		<div class="form-group"> 
	  		<select name="programa" class="custom-select" id="programa" required>
		  		<option selected disabled value="">Programas</option>
		  
				  <%int j=0;
				  while (j<programas.length){%>
					  <option value="<%=programas[j]%>"><%=programas[j]%></option>
					 <% j++;
				  } %>	
		  
	 		</select>
	 		 <button type="submit" class="btn btn-dark">Obtener información del programa</button> 
	 		
		</div> 
	<%} %>
	</form>
		
		
	<!-- SI ES ESTUDIANTE CONSULTANDO SU PROPIO PERFIL -->	
	<!--  EDICIONES CON INSCRIPCIONES RECHAZADAS --> 
	<% if(tipo.equals("estudiante")&& consultaPorUsuarioLogueado){%> 
		<div class="form-group"> 
	  		<select name="edicion" class="custom-select" id="edicion">
		  		<option selected disabled value="">Inscripciones rechazadas</option>
		  
				  <%int k=0;
				  while (k<edicionesRechazadas.length){%>
					  <option value="<%=edicionesRechazadas[k]%>"><%=edicionesRechazadas[k]%></option>
					 <% k++;
				  } %>	
		  
	 		</select>	 		
		</div> 
	<%} %>
	
	<!--  MUESTRO LISTA DE EDICIONES Y SE SELECCIONA UNA PARA VER LISTA DE ACEPTADOS  -->
	<form action="consultarUsuario-3.jsp" method="post" id="form2"> 	
	<% if(tipo.equals("docente") && consultaPorUsuarioLogueado){%>
		<div class="form-group"> 
	  		<select name="edicion" class="custom-select" id="edicion" required>
		  		<option selected disabled value="">Seleccionar una edición</option>
		  
				  <%int l=0;
				  while (l<ediciones.length){%>
					  <option value="<%=ediciones[l]%>"><%=ediciones[l]%></option>
					 <% l++;
				  } %>	
		  
	 		</select>
	 		 <button type="submit" class="btn btn-dark">Obtener estudiantes aceptados</button>
	 		    		  
	 		
		</div> 
	<%} %>
	</form>
	
</div>
</div>
	 
  




<%@include file="/footer.jsp"%>
</body>
</html>
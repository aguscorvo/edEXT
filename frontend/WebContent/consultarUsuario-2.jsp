<%@page import="interfaces.Fabrica" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublishService" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublish" %>
<%@page import="publicadores.ControladorConsultaUsuarioPublishServiceLocator" %>
<%@page import="interfaces.IControladorSeguirUsuarios"%>
<%@page import="publicadores.DtUsuario"%>


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
ControladorConsultaUsuarioPublishService cps = new ControladorConsultaUsuarioPublishServiceLocator();
ControladorConsultaUsuarioPublish port = cps.getControladorConsultaUsuarioPublishPort();

Fabrica fab = Fabrica.getInstancia();
IControladorSeguirUsuarios iConSeguir = fab.getIcontroladorSeguirUsuarios();


String usuario = request.getParameter("usuario");

String seguidos = iConSeguir.getCadenaUsuariosSeguidos(usuario);
String seguidores = iConSeguir.getCadenaUsuariosSeguidores(usuario);

DtUsuario dtUsuario = port.seleccionarUsuario(usuario);
String datosUsuario = port.obtenerDatosUsuario(dtUsuario);

//verifico de que tipo es el usuario seleccionado y si consulta por su propio perfil (si el usuario seleccionado en la consulta es el usuario logueado)
String tipo = "";
Boolean consultaPorUsuarioLogueado= false;

HttpSession s = request.getSession();
if (s.getAttribute("nick") != null && usuario.equals(s.getAttribute("nick").toString())){
	tipo= (String) s.getAttribute("tipoUsuarioLogueado");
	consultaPorUsuarioLogueado= true;
}else{
	tipo= port.tipoUsuarioSeleccionado(usuario);
	consultaPorUsuarioLogueado= false;
}

//ediciones asociadas al usuario seleccionado
String [] ediciones = port.getEdiciones(dtUsuario);

String [] programas = null;
String [] edicionesRechazadas = null;

if (tipo.equals("estudiante") ){
	//programas asociados al estudiante seleccionado
	programas = port.getProgramas(dtUsuario);
	
	if (consultaPorUsuarioLogueado){ 				 //si es estudiante y consulta por su propio perfil
		edicionesRechazadas = port.getEdicionesInscRechazadas(dtUsuario);
	}
	
}

%>

<div style = "float: left" class="row">
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
	
	
	
	
</div>
</div>
	 
<div style = "float: left" class="row">
<div class="col-sm-2 mx-auto">

	
		<!--  DATOS DE USUARIO -->
	<div class="form-group"> 
	
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<div class="card-header">SIGUE A:</div>
  				<div class="card-body">
   					<p class="card-text"><%=seguidos%></p>
  			</div>
		</div>
	</div>
</div>
</div>

<div style = "float: left" class="row">
<div class="col-sm-2 mx-auto">

	
		<!--  DATOS DE USUARIO -->
	<div class="form-group"> 
	
		<div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
 			<div class="card-header">SEGUIDORES:</div>
  				<div class="card-body">
   					<p class="card-text"><%=seguidores%></p>
  			</div>
		</div>
	</div>
</div>
</div>

	
	<div style = "float: left" class="row">
	<div class="col-sm-2 mx-auto">
	
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
	
	<!-- SI ES DOCENTE CONSULTANDO SU PROPIO PERFIL -->	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a id="titulo" class="navbar-brand" href="index.jsp">edEXT</a>
  <script src="js/headerCambiarAHome.js"></script>
  <script src="js/headerCambiarAEdext.js"></script>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav mr-auto">
    
      <%if (session!=null){
    	
    	    	  
    	  if(session.getAttribute("tipoUsuarioLogueado") == null){ %>						<!-- si es visitante -->
      <li class="nav-item">
        <a class="nav-link" href="iniciarSesion.jsp">Iniciar sesión</a>
      </li>
     	<%}else if(session.getAttribute("tipoUsuarioLogueado") != null){ %>					<!-- si es un usuario registrado -->
      <li class="nav-item dropdown">
         <%String nickConArroba="@"+session.getAttribute("nick");%>      
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <%=nickConArroba%>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">  
        <% String nombreCompleto = session.getAttribute("nombre") + " " + session.getAttribute("apellido");%>        
          <a class="dropdown-item disabled" href=""><%= nombreCompleto%></a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="listarSeguidos.jsp">Siguiendo</a>
          <a class="dropdown-item" href="listarSeguidores.jsp">Seguidores </a> 
          <a class="dropdown-item" href="modificarDatosUsuario.jsp">Modificar datos de usuario</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="cerrarSesion.jsp">Cerrar sesión</a>          
      	</div>
	  </li>      
      
      	<%}%>
      	
      	
      	<!-- si es visitante -->
      	
      	<%if(session.getAttribute("tipoUsuarioLogueado") == null){%>
      	<li class="nav-item">
        	<a class="nav-link" href="registrarUsuario.jsp">Registrate</a>
        </li>     
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Consultas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="consultarCurso-1.jsp">Curso</a>
          <a class="dropdown-item" href="consultarEdicion-1.jsp">Edición de curso</a>
          <a class="dropdown-item" href="consultarPrograma-1.jsp">Programa de formación</a>
          <a class="dropdown-item" href="consultarUsuario-1.jsp">Usuario</a>
      	</div>
	  </li>

	  
	    <%}%>
	    
      	
      	<!-- si es docente -->      	
      	
      	<%if(session.getAttribute("tipoUsuarioLogueado") == "docente"){%>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Registros
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		      	    <a class="dropdown-item" href="registrarCurso.jsp">Curso</a>
		    		<a class="dropdown-item" href="registrarEdicion-1.jsp">Edición de curso</a> 
		    		<a class="dropdown-item" href="registrarPrograma.jsp">Programa de formación</a> 
		   		</div>
		      </li> 
		      
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Consultas
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="consultarCurso-1.jsp">Curso</a>
		          <a class="dropdown-item" href="consultarEdicion-1.jsp">Edición de curso</a>
		          <a class="dropdown-item" href="consultarPrograma-1.jsp">Programa de formación</a>
          		  <a class="dropdown-item" href="consultarUsuario-1.jsp">Usuario</a>   
		      	</div>
			  </li>
			  
			  <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Edición de curso
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="seleccionarEstudiantes-1.jsp">Seleccionar estudiantes</a>
		          <a class="dropdown-item" href="listarAceptados-1.jsp">Listar estudiantes aceptados</a>          
		      	</div>
			  </li>
			  
			  <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Programa de formación
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="agregarCursoPrograma.jsp">Agregar curso</a>
		                
		      	</div>
			  </li>
			  
			   <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Seguir usuarios
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="seguirUsuario-1.jsp">Seguir un usuario</a>
		          <a class="dropdown-item" href="dejarDeSeguir-1.jsp">Dejar de seguir un usuario</a>
		             
		      	</div>
			  </li>
			  
	  	<%}%>
	  
	  <!-- si es estudiante -->
	  
	  	<%if(session.getAttribute("tipoUsuarioLogueado") == "estudiante"){%>
	  

		   <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Consultas
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
	          <a class="dropdown-item" href="consultarCurso-1.jsp">Curso</a>
	          <a class="dropdown-item" href="consultarEdicion-1.jsp">Edición de curso</a>
	          <a class="dropdown-item" href="consultarPrograma-1.jsp">Programa de formación</a>
	          <a class="dropdown-item" href="consultarUsuario-1.jsp">Usuario</a>
	      	</div>
		  </li>
		  
		   <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Inscripciones
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
	          <a class="dropdown-item" href="inscripcionEdicion-1.jsp">Edición de curso</a>          
	          <a class="dropdown-item" href="inscripcionPrograma.jsp">Programa de formación</a>    
	      	</div>
		  </li>      
           <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Edición de Curso
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
	          <a class="dropdown-item" href="listarResultadosInscripciones.jsp">Listar resultados de inscripciones</a>          
	      	</div>
		  </li> 
		  
		  <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Seguir usuarios
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="seguirUsuario-1.jsp">Seguir un usuario</a>
		          <a class="dropdown-item" href="dejarDeSeguir-1.jsp">Dejar de seguir un usuario</a>		           
		      	</div>
			  </li>
			       
      	<%}%>
      
     <%}%>
    		
    	       
      </ul>
      
      <form action="buscarCursoOPrograma.jsp" method="post" class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" name="buscar" type="search" placeholder="Ingrese curso o programa" aria-label="Buscar">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
    </form> 
    
  </div>
</nav>


</body>
</html>
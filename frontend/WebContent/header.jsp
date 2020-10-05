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
    <ul class="navbar-nav">
    
      <%if (session!=null){
    	
    	    	  
    	  if(session.getAttribute("tipoUsuarioLogueado") == null){ %>						<!-- si es visitante -->
      <li class="nav-item">
        <a class="nav-link" href="iniciarSesion.jsp">Iniciar sesión</a>
      </li>
     	<%}else if(session.getAttribute("tipoUsuarioLogueado") != null){ %>					<!-- si es un usuario registrado -->
      <li class="nav-item">
        <a class="nav-link" href="cerrarSesion.jsp" >Cerrar sesión</a>
      </li>
      	<%}%>
      	
      	
      	<!-- si es visitante -->
      	
      	<%if(session.getAttribute("tipoUsuarioLogueado") == null){%>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Registros
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
          <a class="dropdown-item" href="registrarUsuario.jsp">Usuario</a>
      	</div>
	  </li>
	  
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Consultas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
          <a class="dropdown-item" href="consultarCurso.jsp">Curso</a>
          <a class="dropdown-item disabled" href="#">Edición de curso</a>
          
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
		    		<a class="dropdown-item disabled" href="#">Edición de curso</a> 
		   		</div>
		      </li> 
		      
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Consultas
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item" href="consultarCurso.jsp">Curso</a>
		          <a class="dropdown-item disabled" href="#">Edición de curso</a>
		          
		      	</div>
			  </li>
			  
			  <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Edición de curso
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
		          <a class="dropdown-item disabled" href="#">Seleccionar estudiantes</a>
		          <a class="dropdown-item disabled" href="#">Listar estudiantes aceptados</a>          
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
	          <a class="dropdown-item" href="consultarCurso.jsp">Curso</a>
	          <a class="dropdown-item disabled" href="#">Edición de curso</a>
	          
	      	</div>
		  </li>
		  
		   <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Inscripciones
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">          
	          <a class="dropdown-item disabled" href="#">Edición de curso</a>          
	      	</div>
		  </li>      
          
      	<%}%>
      
     <%}%>
    		
    	     
     
      </ul>          
  </div>
</nav>


</body>
</html>
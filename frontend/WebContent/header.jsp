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
<% /*
if (!session.isNew()){
	String tipo="estudiante";
	session.getAttribute("tipoUsuarioLogueado");
	if (session.getAttribute("tipoUsuarioLogueado").equals(tipo)){
		System.out.println("es un estudiante");
	}
	else 	System.out.println("usuario no logueado o docente");
}
*/

%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp">edEXT</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
    <!-- si es visitante -->
      <li class="nav-item">
        <a class="nav-link" href="iniciarSesion.jsp">Iniciar sesión</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cerrarSesion.jsp" data-toggle="modal">Cerrar sesión</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="verificacion.jsp">Verifico si hay usuario logueado</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Altas
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
  </div>
</nav>


</body>
</html>
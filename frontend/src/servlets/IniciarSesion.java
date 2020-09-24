package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;


@WebServlet("/IniciarSesion")
public class IniciarSesion  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IniciarSesion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nickOEmail");
		String correo = request.getParameter("nickOEmail");
		String contraseña = request.getParameter("password");
		Fabrica fabrica = Fabrica.getInstancia();
		/*IControlador icon = fabrica.getIControlador();
		icon.agregarSocio(cedula, nombre);
		RequestDispatcher rd;
		request.setAttribute("mensaje", "Se ha ingresado correctamente al socio " + nombre + " de CI " + cedula + " en el sistema.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);*/
	}

}
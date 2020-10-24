package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatype.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorModificarDatosUsuario;
import logica.funcionesAux;


@WebServlet("/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificarDatosUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String password = request.getParameter("password");
		System.out.println("contrasenia modificada: " + password);
		String fecha= request.getParameter("fechaNacimiento2");
		Date fechaNac= funcionesAux.convertirADate(fecha);
		System.out.println("fechaNac modificada: " + fecha);
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorModificarDatosUsuario iCon = fabrica.getIControladorModificarDatosUsuario();
		
		DtUsuario dt= iCon.seleccionarUsuario(nick);
		DtUsuario nuevoDt = new DtUsuario (nick, nombre, apellido, dt.getCorreo(), fechaNac, password);		
		iCon.modificarDatosUsuario(nuevoDt);
		
		RequestDispatcher rd;		
		request.setAttribute("mensaje", "Los datos del usuario "+ nick + " se han modificado exitosamente.");							
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}

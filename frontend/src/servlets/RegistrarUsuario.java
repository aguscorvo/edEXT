package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import logica.funcionesAux;


@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nick = request.getParameter("nick");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String tipo = request.getParameter("tipoUsuario");
		String fecha= request.getParameter("fechaNacimiento2");
		Date fechaNac= funcionesAux.convertirADate(fecha);
		
		DtUsuario dt=null;
		
		if(tipo.equals("docente")) {
			String instituto = request.getParameter("instituto");
			dt= new DtDocente(nick, nombre, apellido, email, fechaNac, pass1, instituto);

		}else if(tipo.equals("estudiante")) {
			dt= new DtEstudiante(nick, nombre, apellido, email, fechaNac, pass1);
			System.out.println(dt.getCorreo());
		}
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorAltaUsuario iCon = fabrica.getIControladorAltaUsuario();
		
		try {
			iCon.ingresarDtUsuario(dt);
			iCon.confirmarAltaUsuario();
		} catch (UsuarioRepetidoException e1) {
			throw new ServletException(e1.getMessage());
		}catch (NoExisteInstitutoException e2) {
			throw new ServletException(e2.getMessage());
		}		
					
		RequestDispatcher rd;
		request.setAttribute("mensaje", "El usuario "+ nick + " se ha creado con éxito en el sistema.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;

import excepciones.ContraseniaIncorrectaException;
import excepciones.NoExisteUsuarioException;
import interfaces.Fabrica;
import interfaces.IControladorIniciarSesion;
import publicadores.ControladorIniciarSesionPublish;
import publicadores.ControladorIniciarSesionPublishService;
import publicadores.ControladorIniciarSesionPublishServiceLocator;
import publicadores.DtUsuarioLogueado;


@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IniciarSesion() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickOEmail = request.getParameter("nickOEmail");
		String contraseña = request.getParameter("password");
		String nickName="";
		DtUsuarioLogueado usuarioLogueado=null;
		Boolean loginExitoso=false;
		
		
		
		
		try {
			usuarioLogueado= iniciarSesion(nickOEmail, contraseña);
			loginExitoso=true;
			request.setAttribute("mensaje", "'@" + usuarioLogueado.getNick() + "'" + " ha iniciado sesión.");	
		} catch (NoExisteUsuarioException e) {
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");			
			loginExitoso=false;
		} catch (ContraseniaIncorrectaException cie) {
			request.setAttribute("mensaje", "La contraseña ingresada es incorrecta.\nIntente nuevamente.");
			loginExitoso=false;
		} catch (Exception e) {
			e.printStackTrace();
		} 		
		
		if (loginExitoso) {
			
			HttpSession session = request.getSession(true);
			if (usuarioLogueado.getTipo().equals("estudiante"))
				session.setAttribute("tipoUsuarioLogueado", "estudiante");
			else if(usuarioLogueado.getTipo().equals("docente"))
				session.setAttribute("tipoUsuarioLogueado", "docente");
			
			session.setAttribute("nick", usuarioLogueado.getNick());
			session.setAttribute("nombre", usuarioLogueado.getNombre());
			session.setAttribute("apellido", usuarioLogueado.getApellido());
			session.setAttribute("fechaNac", usuarioLogueado.getFechaNac());
			session.setAttribute("password", usuarioLogueado.getPassword());
			
		}	
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
	}

	
	public DtUsuarioLogueado iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException, ContraseniaIncorrectaException, Exception, ServiceException {
		
		ControladorIniciarSesionPublishService cps = new ControladorIniciarSesionPublishServiceLocator();
		ControladorIniciarSesionPublish port = cps.getControladorIniciarSesionPublishPort();
		return port.iniciarSesion(nickOEmail, contraseña);

	}
}





	
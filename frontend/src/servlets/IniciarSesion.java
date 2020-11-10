package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.ContraseniaIncorrectaException;
import publicadores.NoExisteUsuarioException;
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
		} catch (Exception e) {			
				request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
				loginExitoso=false;			
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

	
	public DtUsuarioLogueado iniciarSesion(String nickOEmail, String contraseña) throws ServiceException, NoExisteUsuarioException, ContraseniaIncorrectaException, java.rmi.RemoteException {
		
		ControladorIniciarSesionPublishService cps = new ControladorIniciarSesionPublishServiceLocator();
		ControladorIniciarSesionPublish port = cps.getControladorIniciarSesionPublishPort();
		return port.iniciarSesion(nickOEmail, contraseña);

	}
}





	
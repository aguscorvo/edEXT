package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.ControladorModificarDatosUsuarioPublish;
import publicadores.ControladorModificarDatosUsuarioPublishService;
import publicadores.ControladorModificarDatosUsuarioPublishServiceLocator;
import publicadores.DtUsuario;
import publicadores.funcionesAux;


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
		String fecha= request.getParameter("fechaNacimiento2");
		Date fechaNac= funcionesAux.convertirADate(fecha);
		
		
		DtUsuario dt = new DtUsuario();
		try {
			dt = seleccionarUsuario(nick);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		DtUsuario nuevoDt = new DtUsuario (apellido, dt.getCorreo(), fechaNac, nick, nombre, password);		
		
		HttpSession s = request.getSession();
		s.setAttribute("nombre", nombre);
		s.setAttribute("apellido", apellido);
		s.setAttribute("password", password);
		s.setAttribute("fechaNac", fechaNac);
		
		try {
			modificarDatosUsuario(nuevoDt);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd;		
		request.setAttribute("mensaje", "Los datos del usuario "+ nick + " se han modificado exitosamente.");							
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

	public DtUsuario seleccionarUsuario(String nick) throws RemoteException, ServiceException{
		
		ControladorModificarDatosUsuarioPublishService cps = new ControladorModificarDatosUsuarioPublishServiceLocator();
		ControladorModificarDatosUsuarioPublish port = cps.getControladorModificarDatosUsuarioPublishPort();
		return port.seleccionarUsuario(nick);

	}

	public void modificarDatosUsuario(DtUsuario nuevoDt) throws RemoteException, ServiceException{
		
		ControladorModificarDatosUsuarioPublishService cps = new ControladorModificarDatosUsuarioPublishServiceLocator();
		ControladorModificarDatosUsuarioPublish port = cps.getControladorModificarDatosUsuarioPublishPort();
		port.modificarDatosUsuario(nuevoDt);

	}
	
}

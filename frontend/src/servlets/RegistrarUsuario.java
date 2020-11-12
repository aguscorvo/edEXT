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
import javax.xml.rpc.ServiceException;

import publicadores.DtDocente;
import publicadores.DtEstudiante;
import publicadores.NoExisteInstitutoException;
import publicadores.UsuarioRepetidoExceptionMail;
import publicadores.UsuarioRepetidoExceptionNick;
import publicadores.funcionesAux;
import publicadores.ControladorAltaUsuarioPublish;
import publicadores.ControladorAltaUsuarioPublishService;
import publicadores.ControladorAltaUsuarioPublishServiceLocator;


@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nick = request.getParameter("nick").trim();
    	String correo = request.getParameter("email").trim();

    	ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
    	ControladorAltaUsuarioPublish port=null;
		try {
			port = cps.getControladorAltaUsuarioPublishPort();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
    	
    	String respuestaNick= "";
    	String respuestaCorreo= "";
    	
		response.setContentType("text/plain");
		response.getWriter().write("");

    	//VERIFICO NICK
		if(nick == null || "".equals(nick)){
			respuestaNick = "";
			response.getWriter().write(respuestaNick);
		}else if (port.existeUsuarioNick(nick)) {
			respuestaNick = "El nick está en uso";
			response.getWriter().write(respuestaNick);
		}else if (!port.existeUsuarioNick(nick)) {
			respuestaNick = "El nick está disponible";
			response.getWriter().write(respuestaNick);
		}
		
		//VERIFICO CORREO
		if(correo == null || "".equals(correo)){
			respuestaCorreo = "";
			response.getWriter().write(respuestaCorreo);
		}else if (port.existeUsuarioCorreo(correo)) {
			respuestaCorreo = "El correo está en uso";
			response.getWriter().write(respuestaCorreo);
		}else if (!port.existeUsuarioCorreo(correo)) {
			respuestaCorreo = "El correo está disponible";
			response.getWriter().write(respuestaCorreo);
		}
				
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
		
		DtEstudiante dtEst=null;
		DtDocente dtDoc=null;
		boolean esDocente = false;
		if(tipo.equals("docente")) {
			esDocente = true;
			String instituto = request.getParameter("instituto");
			dtDoc= new DtDocente(apellido, email, fechaNac, nick, nombre, pass1, instituto);

		}else if(tipo.equals("estudiante")) {
			esDocente = false;
			dtEst= new DtEstudiante(apellido, email, fechaNac, nick, nombre, pass1);
		}
		
				
		RequestDispatcher rd;
		
		if (!pass1.equals(pass2)) {
			request.setAttribute("mensaje", "Error al procesar.\nLas contraseñas ingresadas no coinciden.\nIntenta nuevamente.");
		}
		else {
			try {
				if(esDocente) {
					ingresarDtDocenteFrontEnd(dtDoc);
					confirmarAltaUsuario();
				}
				else if(!esDocente){
					ingresarDtEstudianteFrontEnd(dtEst);
					confirmarAltaUsuario();
				}
				request.setAttribute("mensaje", "El usuario "+ nick + " se ha creado con éxito en el sistema.");
			} catch (Exception e) {
				request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
			}
		}
					
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
	
	public void ingresarDtDocenteFrontEnd(DtDocente dt) throws ServiceException, UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, RemoteException {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.ingresarDtDocenteFrontEnd(dt);		
	}
	
	public void ingresarDtEstudianteFrontEnd(DtEstudiante dt) throws ServiceException, UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail, RemoteException {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.ingresarDtEstudianteFrontEnd(dt);
	}
	
	public void confirmarAltaUsuario() throws ServiceException, NoExisteInstitutoException, RemoteException {
		ControladorAltaUsuarioPublishService cps = new ControladorAltaUsuarioPublishServiceLocator();
		ControladorAltaUsuarioPublish port = cps.getControladorAltaUsuarioPublishPort();
		port.confirmarAltaUsuario();
	}
}
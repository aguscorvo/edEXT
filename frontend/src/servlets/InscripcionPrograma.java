package servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import publicadores.ControladorIniciarSesionPublish;
import publicadores.ControladorIniciarSesionPublishService;
import publicadores.ControladorIniciarSesionPublishServiceLocator;
import publicadores.ControladorInscripcionAProgramaPublish;
import publicadores.ControladorInscripcionAProgramaPublishService;
import publicadores.ControladorInscripcionAProgramaPublishServiceLocator;


@WebServlet("/InscripcionPrograma")
public class InscripcionPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InscripcionPrograma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("nick");
		
		String programa = request.getParameter("programa");
		boolean inscribir = false;
				
		
		try {
			inscribir= confirmarInscripcion(nick, programa);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		RequestDispatcher rd;
		
		if (inscribir) {
			request.setAttribute("mensaje", "Tu inscripción al programa '" + programa + "' se ha efectuado con éxito.");
		}
		else {
			request.setAttribute("mensaje", "Error al procesar.\nYa te has inscripto con anterioridad al programa '" + programa + "'.");
				
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}
	
	public boolean confirmarInscripcion(String nick, String programa) throws ServiceException, RemoteException {
		ControladorInscripcionAProgramaPublishService cps = new ControladorInscripcionAProgramaPublishServiceLocator();
		ControladorInscripcionAProgramaPublish port = cps.getControladorInscripcionAProgramaPublishPort();
		return port.confirmarInscripcion(nick, programa);
	}

}

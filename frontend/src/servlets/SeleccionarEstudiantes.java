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

import publicadores.ControladorSeleccionarEstudiantesPublish;
import publicadores.ControladorSeleccionarEstudiantesPublishService;
import publicadores.ControladorSeleccionarEstudiantesPublishServiceLocator;
import publicadores.EstadoInscripcion;


@WebServlet("/SeleccionarEstudiantes")
public class SeleccionarEstudiantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SeleccionarEstudiantes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstadoInscripcion ei = EstadoInscripcion.INSCRIPTO;
		
		String [] estudiantes = request.getParameterValues("estudiantes");
		String tipo = request.getParameter("AceptarRechazar");
		String edi = request.getParameter("boton");
		
		if(tipo.equals("Aceptar"))
			ei = EstadoInscripcion.ACEPTADO;
		
		else if(tipo.equals("Rechazar")) 
			ei = EstadoInscripcion.RECHAZADO;
		

		HttpSession session = request.getSession();
		String docente = (String) session.getAttribute("nick");
		
		boolean esDocente = true;
		try {
			esDocente = esDocenteEdicion(docente, edi);
		} catch (ServiceException e) {
		
			e.printStackTrace();
		}
		
		RequestDispatcher rd;
		
		if (!esDocente) {
			request.setAttribute("mensaje", "Error al procesar.\nNo puedes modificar las inscripciones porque no tienes asociada la edición '" + edi +"'.");     
		}
		else {
			try {
				confirmarSeleccionarEstudiantes(estudiantes, ei, edi);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			request.setAttribute("mensaje", "El estado de inscripción de los estudiantes seleccionados ha sido modificado con éxito.");
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

	public void confirmarSeleccionarEstudiantes(String [] estudiantes, EstadoInscripcion ei, String edi) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		port.confirmarSeleccionarEstudiantes(estudiantes, ei, edi);
	}
	
	public boolean esDocenteEdicion(String docente, String edi) throws ServiceException, RemoteException {
		ControladorSeleccionarEstudiantesPublishService cps = new ControladorSeleccionarEstudiantesPublishServiceLocator();
		ControladorSeleccionarEstudiantesPublish port = cps.getControladorSeleccionarEstudiantesPublishPort();
		return port.esDocenteEdicion(docente, edi);
	}
	
}

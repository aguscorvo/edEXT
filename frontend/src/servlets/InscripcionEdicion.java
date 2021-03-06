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


import publicadores.ControladorInscripcionAEdicionPublish;
import publicadores.ControladorInscripcionAEdicionPublishService;
import publicadores.ControladorInscripcionAEdicionPublishServiceLocator;
import publicadores.EstadoInscripcion;




@WebServlet("/InscripcionEdicion")
public class InscripcionEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InscripcionEdicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstadoInscripcion ei;
		HttpSession session = request.getSession();
		String nick = (String) session.getAttribute("nick");
		
		String edi = request.getParameter("boton1");
		String curso = request.getParameter("boton2");
				
				
		Date fecha = new Date();
		
		try {
			ingresarEstudiante(nick, fecha);
		} catch (Exception e1) {
			System.out.println("entre a e1");
			e1.printStackTrace();
		}
		
		
		try {
			ingresarCurso(curso);
		} catch (Exception e2) {
			System.out.println("entre a e2");
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
		}
	    
		RequestDispatcher rd;
		try {
			boolean tiene = tieneInscripcion();
			//ei = chequearEstudianteEdicion(); // si el estudiante no se inscribio salta a la excepcion (e5), nunca entra al if de null
			if (!tiene) {
				try {
					confirmarInscripcionAEdicion();
					request.setAttribute("mensaje", "Tu inscripción a la edición " + edi + " se ha efectuado con éxito.");

				} catch (Exception e3) {
					System.out.println("entre a e3");
					e3.printStackTrace();
				}
			}
			else {
				ei = chequearEstudianteEdicion();
				if (ei == EstadoInscripcion.RECHAZADO){
					//no está entrando acá, si la inscripcion tiene estado RECHAZADO (en bd) entra a INSCRIPTO.
					try {
						confirmarInscripcionAEdicion();
						request.setAttribute("mensaje", "Tu inscripción a la edición " + edi + " se ha efectuado con éxito.");

					} catch (ServiceException e4) {
						System.out.println("entre a e4");
						e4.printStackTrace();
					}
				}
				else {
					if (ei == EstadoInscripcion.INSCRIPTO) {
						//entra correctamente
						request.setAttribute("mensaje", "Error al procesar. Ya te has inscripto con anterioridad a la edición." + edi + ".");
					}
					else if (ei == EstadoInscripcion.ACEPTADO) {
						//entra correctamente
						request.setAttribute("mensaje", "Error al procesar. Ya te has inscripto con anterioridad y has sido aceptado en la edición." + edi + ".");
					}
				}
			}
		} catch (Exception e5) {
			System.out.println("entre a e5");
			e5.printStackTrace();
		}		
		
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

	public void ingresarEstudiante(String nick, Date fecha) throws RemoteException, ServiceException{
		ControladorInscripcionAEdicionPublishService cps = new ControladorInscripcionAEdicionPublishServiceLocator();
		ControladorInscripcionAEdicionPublish port = cps.getControladorInscripcionAEdicionPublishPort();
		port.ingresarEstudiante(nick,fecha);		
	}
	
	public void ingresarCurso(String curso) throws RemoteException, ServiceException{
		ControladorInscripcionAEdicionPublishService cps = new ControladorInscripcionAEdicionPublishServiceLocator();
		ControladorInscripcionAEdicionPublish port = cps.getControladorInscripcionAEdicionPublishPort();
		port.ingresarCurso(curso);		
	}
	
	public EstadoInscripcion chequearEstudianteEdicion() throws RemoteException, ServiceException{
		ControladorInscripcionAEdicionPublishService cps = new ControladorInscripcionAEdicionPublishServiceLocator();
		ControladorInscripcionAEdicionPublish port = cps.getControladorInscripcionAEdicionPublishPort();
		return port.chequearEstudianteEdicion();		
	}
	
	public void confirmarInscripcionAEdicion() throws RemoteException, ServiceException{
		ControladorInscripcionAEdicionPublishService cps = new ControladorInscripcionAEdicionPublishServiceLocator();
		ControladorInscripcionAEdicionPublish port = cps.getControladorInscripcionAEdicionPublishPort();
		port.confirmarInscripcionAEdicion();		
	}
	
	public boolean tieneInscripcion() throws RemoteException, ServiceException{
		ControladorInscripcionAEdicionPublishService cps = new ControladorInscripcionAEdicionPublishServiceLocator();
		ControladorInscripcionAEdicionPublish port = cps.getControladorInscripcionAEdicionPublishPort();
		return port.tieneInscripcion();		
	}
}

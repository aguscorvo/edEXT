package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatype.EstadoInscripcion;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.Fabrica;

import interfaces.IControladorInscripcionAEdicion;



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
		
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorInscripcionAEdicion iCon = fabrica.getIControladorInscripcionAEdicion();
		
		Date fecha = new Date();
		
		iCon.ingresarEstudiante(nick, fecha);
		
		
		try {
			iCon.ingresarCurso(curso);
		} catch (NoExisteEdicionVigenteException e) {
			e.printStackTrace();
		}
	    
		ei = iCon.chequearEstudianteEdicion();
		
		RequestDispatcher rd;
		
		if (ei == null) {
			iCon.confirmarInscripcionAEdicion();
			request.setAttribute("mensaje", "Tu inscripción a la edición " + edi + " se ha efectuado con éxito.");
		}
		else {
			if (ei == EstadoInscripcion.RECHAZADO){
			iCon.confirmarInscripcionAEdicion();
			request.setAttribute("mensaje", "Tu inscripción a la edición " + edi + " se ha efectuado con éxito.");
			}
			else {
				if (ei == EstadoInscripcion.INSCRIPTO) {
					request.setAttribute("mensaje", "Error al procesar. Ya te has inscripto con anterioridad a la edición " + edi + ".");
				}
				else if (ei == EstadoInscripcion.ACEPTADO) {
					request.setAttribute("mensaje", "Error al procesar. Ya te has inscripto con anterioridad y has sido aceptado en la edición" + edi + ".");
				}
			}
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}

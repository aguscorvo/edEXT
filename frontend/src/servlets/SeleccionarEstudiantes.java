package servlets;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import datatype.EstadoInscripcion;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorSeleccionarEstudiantes;
import logica.funcionesAux;
import persistencia.Conexion;


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
		
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorSeleccionarEstudiantes iCon = fabrica.getIControladorSeleccionarEstudiantes();
		
		
	    iCon.confirmarSeleccionarEstudiantes(estudiantes, ei, edi);
		
		RequestDispatcher rd;
		request.setAttribute("mensaje", "El estado de inscripción de los estudiantes seleccionados ha sido modificado con éxito.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
	}

}

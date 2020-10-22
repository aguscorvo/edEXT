package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatype.DtEdicionExp;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicion;
import logica.funcionesAux;


@WebServlet("/RegistrarEdicion")
public class RegistrarEdicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarEdicion() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("curso");
		String nombre = request.getParameter("nombre");
		String [] docentes = request.getParameterValues("docente");	
		List<String> docentesSeleccionados = new ArrayList <String>();
		
		if (docentes!=null) {
			for(int i=0; i<docentes.length; i++) {
				docentesSeleccionados.add(docentes[i]);
			}
		}
		
		String fecha1= request.getParameter("fechaInicio");
		String fecha2= request.getParameter("fechaFinalizacion");
		Date fechaI= funcionesAux.convertirADate(fecha1);
		Date fechaF= funcionesAux.convertirADate(fecha2);
		Date fechaPub = new Date();
		
		int cupo = 0;
		String checkboxCupo = request.getParameter("checkboxCupo");
		
		if (checkboxCupo!=null) {
			int valorCupo = Integer.valueOf(request.getParameter("cupo"));
			cupo = valorCupo;
		}
		
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaEdicion iCon = f.getIControladorAltaEdicion();
			
		
		DtEdicionExp edicion= new DtEdicionExp (nombre, fechaI, fechaF, cupo, fechaPub, docentesSeleccionados);

		
		try {
			iCon.seleccionarCurso(curso);
			iCon.ingresarDtEdicion(edicion);
			iCon.confirmarAltaEdicion();
			
		}catch (NoExisteCursoException nece) {
			throw new ServletException(nece.getMessage());
		}catch(EdicionRepetidaException ere) {
			throw new ServletException (ere.getMessage());
		}
		
		RequestDispatcher rd;
		request.setAttribute("mensaje", "La edición" + nombre + " se ha creado con éxito en el sistema");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}

}

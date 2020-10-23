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
import datatype.DtProgFormacion;
import excepciones.CursoRepetidoException;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicion;
import interfaces.IControladorAltaProgFormacion;
import logica.funcionesAux;


@WebServlet("/RegistrarPrograma")
public class RegistrarPrograma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrarPrograma() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fecha1a= request.getParameter("fecha1");
		String fecha2a= request.getParameter("fecha2");
		Date fechaI= funcionesAux.convertirADate(fecha1a);
		Date fechaF= funcionesAux.convertirADate(fecha2a);
		Date fechaAlta = new Date();
		
		DtProgFormacion nuevoProg = new DtProgFormacion(nombre, descripcion, fechaI, fechaF, fechaAlta);
		
		Fabrica f = Fabrica.getInstancia();
		IControladorAltaProgFormacion iCon = f.getIControladorAltaProgFormacion();
		
		RequestDispatcher rd;
		
		try {
			iCon.ingresarProgFormacion(nuevoProg);
			iCon.confirmarAltaPrograma();
			request.setAttribute("mensaje", "El programa de formación " + nombre + " se ha creado con éxito en el sistema");
		} catch (ProgramaRepetidoException e) {
			request.setAttribute("mensaje", "El programa de formación '" + nombre + "' ya existe en el sistema.\nIntenta registrar el programa de formación con un nombre diferente.");
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}

}

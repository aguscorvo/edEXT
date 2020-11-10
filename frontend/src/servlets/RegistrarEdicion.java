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

import publicadores.funcionesAux;
import publicadores.ControladorAltaEdicionPublish;
import publicadores.ControladorAltaEdicionPublishService;
import publicadores.ControladorAltaEdicionPublishServiceLocator;
import publicadores.DtEdicionExp;
import publicadores.EdicionRepetidaException;
import publicadores.NoExisteCursoException;


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
		
					
		
		DtEdicionExp edicion= new DtEdicionExp (cupo, fechaF, fechaI, fechaPub, nombre, docentes);

		
		try {
			seleccionarCurso(curso);
			ingresarDtEdicion(edicion);
			confirmarAltaEdicion();
			request.setAttribute("mensaje", "La edición" + "'" + nombre + "'" + " se ha creado con éxito en el sistema.");			
		}catch (Exception e) {
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void seleccionarCurso(String curso) throws ServiceException, NoExisteCursoException, RemoteException {
		ControladorAltaEdicionPublishService cps = new ControladorAltaEdicionPublishServiceLocator();
		ControladorAltaEdicionPublish port = cps.getControladorAltaEdicionPublishPort();
		port.seleccionarCurso(curso);

	}
	
	public void ingresarDtEdicion(DtEdicionExp edicion) throws ServiceException, EdicionRepetidaException, RemoteException {
		ControladorAltaEdicionPublishService cps = new ControladorAltaEdicionPublishServiceLocator();
		ControladorAltaEdicionPublish port = cps.getControladorAltaEdicionPublishPort();
		port.ingresarDtEdicion(edicion);

	}
	
	public void confirmarAltaEdicion() throws ServiceException, RemoteException {
		ControladorAltaEdicionPublishService cps = new ControladorAltaEdicionPublishServiceLocator();
		ControladorAltaEdicionPublish port = cps.getControladorAltaEdicionPublishPort();
		port.confirmarAltaEdicion();

	}
}

package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import publicadores.DtEdicionExp;
import publicadores.DtProgFormacion;
import publicadores.funcionesAux;
import publicadores.ControladorAltaProgFormacionPublish;
import publicadores.ControladorAltaProgFormacionPublishService;
import publicadores.ControladorAltaProgFormacionPublishServiceLocator;
import publicadores.ControladorIniciarSesionPublish;
import publicadores.ControladorIniciarSesionPublishService;
import publicadores.ControladorIniciarSesionPublishServiceLocator;


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
		RequestDispatcher rd;
		
		try {
			ingresarProgFormacion(nuevoProg);
			confirmarAltaPrograma();
			request.setAttribute("mensaje", "El programa de formación " + nombre + " se ha creado con éxito en el sistema");
		} catch (Exception e) {
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void ingresarProgFormacion(DtProgFormacion aux) throws ServiceException, publicadores.ProgramaRepetidoException, RemoteException {
		ControladorAltaProgFormacionPublishService cps = new ControladorAltaProgFormacionPublishServiceLocator();
		ControladorAltaProgFormacionPublish port = cps.getControladorAltaProgFormacionPublishPort();
		port.ingresarProgFormacion(aux);
		
	}
	
	public void confirmarAltaPrograma() throws RemoteException, ServiceException {
		ControladorAltaProgFormacionPublishService cps = new ControladorAltaProgFormacionPublishServiceLocator();
		ControladorAltaProgFormacionPublish port = cps.getControladorAltaProgFormacionPublishPort();
		port.confirmarAltaPrograma();
		
	}
}

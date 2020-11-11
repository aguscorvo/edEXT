package servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import publicadores.ControladorAgregarCursoAPFPublish;
import publicadores.ControladorAgregarCursoAPFPublishService;
import publicadores.ControladorAgregarCursoAPFPublishServiceLocator;



@WebServlet("/AgregarCurso")
public class AgregarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AgregarCurso() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String programa = request.getParameter("programa");
		String curso = request.getParameter("curso");
			
		RequestDispatcher rd;
		
		try {
			seleccionarPrograma(programa);
		} catch (Exception e) {
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");

		}
		try {
			seleccionarCurso(curso);
			request.setAttribute("mensaje", "Se agregó '" + curso + "' al programa de formación ' " + programa + "' con éxito.");
		} catch (Exception e) {
			request.setAttribute("mensaje", "Los datos ingresados son incorrectos.\nIntente nuevamente.");
		}
		
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		
	}
	
	public void seleccionarPrograma(String programa) throws ServiceException, RemoteException {
		ControladorAgregarCursoAPFPublishService cps = new ControladorAgregarCursoAPFPublishServiceLocator();
		ControladorAgregarCursoAPFPublish port = cps.getControladorAgregarCursoAPFPublishPort();
		port.seleccionarPrograma(programa);
		
	}
	
	public void seleccionarCurso(String curso) throws ServiceException, publicadores.CursoEnPFRepetidoException, RemoteException {
		ControladorAgregarCursoAPFPublishService cps = new ControladorAgregarCursoAPFPublishServiceLocator();
		ControladorAgregarCursoAPFPublish port = cps.getControladorAgregarCursoAPFPublishPort();
		port.seleccionarCurso(curso);
		
	}
}
